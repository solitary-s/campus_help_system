package com.aloneness.compusHelpSystem.service.impl;

import com.aloneness.compusHelpSystem.dao.UserDao;
import com.aloneness.compusHelpSystem.entity.APIResult;
import com.aloneness.compusHelpSystem.entity.User;
import com.aloneness.compusHelpSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public APIResult register(User user) {
        User u = userDao.getByAccount(user.getAccount());
        APIResult apiResult = new APIResult();
        if(u == null){
            String password = user.getPassword();
            String mdPassword = DigestUtils.md5DigestAsHex(password.getBytes());
            user.setPassword(mdPassword);
            user.setCreated(new Date());
            userDao.insert(user);
            u = userDao.getByAccount(user.getAccount());
            if(u == null){
                apiResult.setCode(APIResult.Fail_CODE);
                apiResult.setMessage("注册失败，插入数据异常");
                return apiResult;
            }else{
                apiResult.setCode(APIResult.SUCCESS_CODE);
                apiResult.setMessage("注册成功！");
            }
        }else{
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("注册失败，该用户已经注册");
        }
        return apiResult;
    }

    @Override
    public APIResult login(String account, String password) {
        User user = userDao.getByAccount(account);
        String md5Password = null;
        APIResult apiResult = new APIResult();
        if(user == null){
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("登录失败，手机账号未注册");
        }else{
            md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(user.getPassword())){
                apiResult.setCode(APIResult.SUCCESS_CODE);
                apiResult.setMessage("登录成功");
                user.setPassword(null);
                apiResult.setData(user);
            }else {
                apiResult.setCode(APIResult.Fail_CODE);
                apiResult.setMessage("登录失败，密码错误");
            }
        }
        return apiResult;
    }

    @Override
    public APIResult getUser(String account) {
        User user = userDao.getByAccount(account);
        APIResult apiResult = new APIResult();
        if(user == null){
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("获取失败");
        }else{
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("获取成功");
            user.setPassword(null);
            apiResult.setData(user);
        }
        return apiResult;
    }
}
