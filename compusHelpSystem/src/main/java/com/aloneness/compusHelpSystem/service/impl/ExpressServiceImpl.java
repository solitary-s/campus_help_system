package com.aloneness.compusHelpSystem.service.impl;

import com.aloneness.compusHelpSystem.common.constant.ExpressConstant;
import com.aloneness.compusHelpSystem.dao.ExpressDao;
import com.aloneness.compusHelpSystem.dao.ExpressDetailDao;
import com.aloneness.compusHelpSystem.entity.APIResult;
import com.aloneness.compusHelpSystem.entity.Express;
import com.aloneness.compusHelpSystem.entity.ExpressDetail;
import com.aloneness.compusHelpSystem.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private ExpressDetailDao expressDetailDao;

    @Autowired
    private ExpressDao expressDao;

    @Override
    public APIResult saveExpress(Express express) {
        expressDetailDao.saveExpressDetail(express.getExpressDetail());
        expressDao.saveExpress(express);
        Express e = expressDao.getByExpressDetailId(express.getExpressDetail().getExpress_detail_id());
        APIResult apiResult = new APIResult();
        if(e == null){
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("发布失败！插入异常");
        }else{
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("发布成功！");
            apiResult.setData(e);
        }
        return apiResult;
    }

    @Override
    public APIResult getByExpressDetailId(String express_detail_id) {
        APIResult apiResult = new APIResult();
        Express express = expressDao.getByExpressDetailId(express_detail_id);
        if(express == null){
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("获取失败，查询异常");
        }else{
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("获取成功");
            apiResult.setData(express);
        }
        return apiResult;
    }

    @Override
    public APIResult getExpressByPage(int currPage) {
        APIResult apiResult = new APIResult();
        Map<String,Object> map = new HashMap<>();
        map.put("currPage",(currPage-1)*ExpressConstant.PAGE_SIZE);
        map.put("pageSize", ExpressConstant.PAGE_SIZE);
        List<Express> expresses = expressDao.queryExpressByPage(map);
        if(expresses == null || expresses.size() == 0){
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("获取失败，没有更多的数据了");
        }else{
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("获取成功");
            apiResult.setData(expresses);
        }
        return apiResult;
    }

    @Override
    public APIResult getExpressByPageAndSearch(int currPage, String search_content) {
        APIResult apiResult = new APIResult();
        Map<String,Object> map = new HashMap<>();
        map.put("currPage",(currPage-1)*ExpressConstant.PAGE_SIZE);
        map.put("pageSize", ExpressConstant.PAGE_SIZE);
        map.put("search_content", search_content);
        List<Express> expresses = expressDao.queryExpressByPageAndSearCh(map);
        if(expresses == null || expresses.size() == 0){
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("获取失败，没有更多的数据了");
        }else{
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("获取成功");
            apiResult.setData(expresses);
        }
        return apiResult;
    }

    @Override
    public APIResult getExpressByPublish(String publish_id) {
        List<Express> expresses = expressDao.getExpressByPublish(publish_id);
        APIResult apiResult = new APIResult();

        apiResult.setCode(APIResult.SUCCESS_CODE);
        apiResult.setMessage("获取成功");
        apiResult.setData(expresses);

        return apiResult;
    }

    @Override
    public APIResult getExpressByAccept(String accept_id) {
        List<Express> expresses = expressDao.getExpressByAccept(accept_id);
        APIResult apiResult = new APIResult();

        apiResult.setCode(APIResult.SUCCESS_CODE);
        apiResult.setMessage("获取成功");
        apiResult.setData(expresses);

        return apiResult;
    }

    @Override
    public APIResult getExpressByProcess(String phone) {
        List<Express> expresses = expressDao.getExpressByProcess(phone);
        APIResult apiResult = new APIResult();

        apiResult.setCode(APIResult.SUCCESS_CODE);
        apiResult.setMessage("获取成功");
        apiResult.setData(expresses);

        return apiResult;
    }

    @Override
    public APIResult getExpressByFinish(String phone) {
        List<Express> expresses = expressDao.getExpressByFinish(phone);
        APIResult apiResult = new APIResult();

        apiResult.setCode(APIResult.SUCCESS_CODE);
        apiResult.setMessage("获取成功");
        apiResult.setData(expresses);

        return apiResult;
    }

    @Override
    public APIResult updateExpressByAccept(String express_detail_id, String accept_id) {
        Express express = expressDao.getByExpressDetailId(express_detail_id);
        APIResult apiResult= new APIResult();
        if(express != null){
            express.setOrder_status(1002);
            express.setAccept_id(accept_id);
            expressDao.updateExpressByAccept(express);
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("接受成功");
            apiResult.setData(express);
        }else{
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("接受失败，更新异常");
        }
        return apiResult;
    }

    @Override
    public APIResult cancelExpress(String express_detail_id) {
        Express express = expressDao.getByExpressDetailId(express_detail_id);
        APIResult apiResult= new APIResult();
        if(express != null){
            express.setOrder_status(1004);
            expressDao.cancelExpress(express);
            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("取消成功");
            apiResult.setData(express);
        }else{
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("取消失败");
        }
        return apiResult;
    }

    @Override
    public APIResult finishExpress(String express_detail_id) {
        Express express = expressDao.getByExpressDetailId(express_detail_id);
        APIResult apiResult= new APIResult();
        if(express != null){
            express.setOrder_status(1003);
            ExpressDetail expressDetail = express.getExpressDetail();
            expressDetail.setExpress_finishtime(new Date());
            expressDao.finishExpressDetail(expressDetail);

            express.setExpressDetail(expressDetail);
            expressDao.finishExpress(express);

            apiResult.setCode(APIResult.SUCCESS_CODE);
            apiResult.setMessage("完成订单成功");
            apiResult.setData(express);
        }else{
            apiResult.setCode(APIResult.Fail_CODE);
            apiResult.setMessage("完成失败");
        }
        return apiResult;
    }
}
