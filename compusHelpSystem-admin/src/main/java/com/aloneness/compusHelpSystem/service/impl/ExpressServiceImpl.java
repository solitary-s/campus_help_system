package com.aloneness.compusHelpSystem.service.impl;

import com.aloneness.compusHelpSystem.dao.ExpressDao;
import com.aloneness.compusHelpSystem.dao.ExpressDetailDao;
import com.aloneness.compusHelpSystem.dto.BaseResult;
import com.aloneness.compusHelpSystem.dto.PageInfo;
import com.aloneness.compusHelpSystem.entity.Express;
import com.aloneness.compusHelpSystem.entity.ExpressDetail;
import com.aloneness.compusHelpSystem.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private ExpressDetailDao expressDetailDao;

    @Autowired
    private ExpressDao expressDao;

    @Override
    public PageInfo<Express> page(int start, int length, int draw, Express express) {
        int count = expressDao.count(express);
        Map<String, Object> map = new HashMap<>();
        map.put("start",start);
        map.put("length",length);
        map.put("express",express);

        PageInfo<Express> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(expressDao.page(map));

        return pageInfo;
    }

    @Override
    public int count(Express express) {
        return expressDao.count(express);
    }



    @Override
    public Express getByExpressDetailId(String express_detail_id) {
        return  expressDao.getByExpressDetailId(express_detail_id);
    }

    @Override
    public BaseResult update(Express express) {
        BaseResult baseResult = BaseResult.success();
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            ExpressDetail expressDetail = express.getExpressDetail();
            expressDao.updateExpressDetail(expressDetail);
            expressDao.updateExpress(express);
            baseResult.setMessage("编辑快递订单成功");
        }
        return baseResult;
    }

    @Override
    public void delete(String express_detail_id) {
        expressDao.deleteExpressDetail(express_detail_id);
        expressDao.deleteExpress(express_detail_id);
    }

}
