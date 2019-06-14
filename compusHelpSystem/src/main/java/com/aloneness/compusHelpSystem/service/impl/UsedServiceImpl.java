package com.aloneness.compusHelpSystem.service.impl;


import com.aloneness.compusHelpSystem.common.constant.UsedConstant;
import com.aloneness.compusHelpSystem.dao.UsedDao;
import com.aloneness.compusHelpSystem.dao.UsedDetailDao;
import com.aloneness.compusHelpSystem.entity.*;

import com.aloneness.compusHelpSystem.service.UsedService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsedServiceImpl implements UsedService {

    @Autowired
    private UsedDetailDao usedDetailDao;

    @Autowired
    private UsedDao usedDao;

    @Override
    public APIResult saveUsed(Used used) {
        usedDetailDao.saveUsedDetail(used.getUsedDetail());
        usedDao.saveUsed(used);
        Used u = usedDao.getByUsedDetailId(used.getUsedDetail().getUsed_detail_id());
        APIResult apiResult = new APIResult();
        if(u == null){
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("发布失败！插入异常");
        }else{
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("发布成功！");
            apiResult.setData(u);
        }
        return apiResult;
    }

    @Override
    public APIResult getUsedByPage(int currPage) {
        APIResult apiResult = new APIResult();
        Map<String,Object> map = new HashMap<>();
        map.put("currPage",(currPage-1)* UsedConstant.PAGE_SIZE);
        map.put("pageSize", UsedConstant.PAGE_SIZE);
        List<Used> useds = usedDao.queryUsedByPage(map);
        if(useds == null || useds.size() == 0){
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("获取失败，没有更多的数据了");
        }else{
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("获取成功");
            apiResult.setData(useds);
        }
        return apiResult;
    }

    @Override
    public APIResult getUsedByPageAndSearch(int currPage, String search_content) {
        APIResult apiResult = new APIResult();
        Map<String,Object> map = new HashMap<>();
        map.put("currPage",(currPage-1)*UsedConstant.PAGE_SIZE);
        map.put("pageSize", UsedConstant.PAGE_SIZE);
        map.put("search_content", search_content);
        List<Used> useds = usedDao.queryUsedByPageAndSearCh(map);
        if(useds == null || useds.size() == 0){
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("获取失败，没有更多的数据了");
        }else{
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("获取成功");
            apiResult.setData(useds);
        }
        return apiResult;
    }

    @Override
    public APIResult getByUsedDetailId(String used_detail_id) {
        APIResult apiResult = new APIResult();
        Used used = usedDao.getByUsedDetailId(used_detail_id);
        if(used == null){
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("获取失败，查询异常");
        }else{
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("获取成功");
            apiResult.setData(used);
        }
        return apiResult;
    }

    @Override
    public APIResult getUsedByPublish(String publish_id) {
        List<Used> useds = usedDao.getUsedByPublish(publish_id);
        APIResult apiResult = new APIResult();

        apiResult.setCode(APIResult.SUCCESS_CODE);
        apiResult.setMessage("获取成功");
        apiResult.setData(useds);

        return apiResult;
    }

    @Override
    public APIResult getUsedByAccept(String accept_id) {
        List<Used> useds = usedDao.getUsedByAccept(accept_id);
        APIResult apiResult = new APIResult();

        apiResult.setCode(APIResult.SUCCESS_CODE);
        apiResult.setMessage("获取成功");
        apiResult.setData(useds);

        return apiResult;
    }

    @Override
    public APIResult getUsedByProcess(String phone) {
        List<Used> useds = usedDao.getUsedByProcess(phone);
        APIResult apiResult = new APIResult();

        apiResult.setCode(APIResult.SUCCESS_CODE);
        apiResult.setMessage("获取成功");
        apiResult.setData(useds);

        return apiResult;
    }

    @Override
    public APIResult getUsedByFinish(String phone) {
        List<Used> useds = usedDao.getUsedByFinish(phone);
        APIResult apiResult = new APIResult();

        apiResult.setCode(APIResult.SUCCESS_CODE);
        apiResult.setMessage("获取成功");
        apiResult.setData(useds);

        return apiResult;
    }

    @Override
    public APIResult updateUsedByAccept(String used_detail_id, String accept_id) {
        Used used = usedDao.getByUsedDetailId(used_detail_id);
        APIResult apiResult= new APIResult();
        if(used != null){
            used.setOrder_status(1002);
            used.setAccept_id(accept_id);
            usedDao.updateUsedByAccept(used);
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("接受成功");
            apiResult.setData(used);
        }else{
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("接受失败，更新异常");
        }
        return apiResult;
    }

    /**
     * 取消订单(二手市场)
     * @param used_detail_id
     * @return
     */
    @Override
    public APIResult cancelUsed(String used_detail_id) {
        Used used = usedDao.getByUsedDetailId(used_detail_id);
        APIResult apiResult= new APIResult();
        if(used != null){
            used.setOrder_status(1004);
            usedDao.cancelUsed(used);
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("取消成功");
            apiResult.setData(used);
        }else{
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("取消失败");
        }
        return apiResult;
    }

    /**
     * 完成订单(二手市场)
     * @param used_detail_id
     * @return
     */

    @Override
    public APIResult finishUsed(String used_detail_id) {
        Used used = usedDao.getByUsedDetailId(used_detail_id);
        APIResult apiResult= new APIResult();
        if(used != null){
            used.setOrder_status(1003);
            UsedDetail usedDetail = used.getUsedDetail();
            usedDetail.setUsed_finishtime(new Date());
            usedDao.finishUsedDetail(usedDetail);

            used.setUsedDetail(usedDetail);
            usedDao.finishUsed(used);

            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("完成订单成功");
            apiResult.setData(used);
        }else{
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("完成失败");
        }
        return apiResult;
    }
}
