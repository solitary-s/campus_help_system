package com.aloneness.compusHelpSystem.service.impl;

import com.aloneness.compusHelpSystem.dao.UserDao;
import com.aloneness.compusHelpSystem.dto.BaseResult;
import com.aloneness.compusHelpSystem.dto.PageInfo;
import com.aloneness.compusHelpSystem.entity.User;
import com.aloneness.compusHelpSystem.service.UserService;
import com.aloneness.compusHelpSystem.utils.RegexpUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public PageInfo<User> page(int start, int length, int draw, User user) {
        int count = userDao.count(user);
        Map<String, Object> map = new HashMap<>();
        map.put("start",start);
        map.put("length",length);
        map.put("user",user);

        PageInfo<User> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(userDao.page(map));

        return pageInfo;
    }

    @Override
    public int count(User user) {
        return userDao.count(user);
    }

    @Override
    public BaseResult save(User user) {
        BaseResult baseResult = checkUser(user);

        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            User u = userDao.getByAccount(user.getAccount());
            //新增
            if(u == null){
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
                user.setCreated(new Date());
                userDao.insert(user);
                baseResult.setMessage("保存用户信息成功");
            }else{
                baseResult.setStatus(BaseResult.STATUS_FAIL);
                baseResult.setMessage("已经存在该用户");
            }

        }
        return baseResult;
    }

    @Override
    public BaseResult update(User user) {
        BaseResult baseResult = checkUser(user);
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            user.setCreated(new Date());
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            userDao.update(user);
            baseResult.setMessage("编辑用户成功");
        }
        return baseResult;
    }

    @Override
    public List<User> search(String keyword) {
        User user = new User();
        user.setUsername(keyword);
        user.setEmail(keyword);
        user.setAccount(keyword);
        return userDao.search(user);
    }

    @Override
    public User getByAccount(String account) {
        return userDao.getByAccount(account);
    }

    @Override
    public void delete(String account) {
        userDao.delete(account);
    }

    private BaseResult checkUser(User user){
        BaseResult baseResult = BaseResult.success();
        if(StringUtils.isBlank(user.getAccount())){
            baseResult = BaseResult.fail("手机账号不能为空,请重新输入");
        }
        else if(!RegexpUtils.checkPhone(user.getAccount())){
            baseResult = BaseResult.fail("手机账号格式不正确,请重新输入");
        }
        else if(StringUtils.isBlank(user.getPassword())){
            baseResult = BaseResult.fail("登录密码不能为空,请重新输入");
        }

        else if(StringUtils.isBlank(user.getEmail())){
            baseResult = BaseResult.fail("邮箱不能为空,请重新输入");
        }
        else if(!RegexpUtils.checkEmail(user.getEmail())){
            baseResult = BaseResult.fail("手机账号格式不正确,请重新输入");
        }

        else if(StringUtils.isBlank(user.getUsername())){
            baseResult = BaseResult.fail("用户名不能为空,请重新输入");
        }
        return baseResult;
    }
}
