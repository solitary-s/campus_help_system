package com.aloneness.compusHelpSystem.service.impl;


import com.aloneness.compusHelpSystem.common.constant.UsedConstant;
import com.aloneness.compusHelpSystem.dao.UsedDao;
import com.aloneness.compusHelpSystem.dao.UsedDetailDao;
import com.aloneness.compusHelpSystem.dto.BaseResult;
import com.aloneness.compusHelpSystem.dto.PageInfo;
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
    public PageInfo<Used> page(int start, int length, int draw, Used used) {
        int count = usedDao.count(used);
        Map<String, Object> map = new HashMap<>();
        map.put("start",start);
        map.put("length",length);
        map.put("used",used);

        PageInfo<Used> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(usedDao.page(map));

        return pageInfo;
    }

    @Override
    public int count(Used used) {
        return usedDao.count(used);
    }


    @Override
    public Used getByUsedDetailId(String used_detail_id) {
        return usedDao.getByUsedDetailId(used_detail_id);
    }

    @Override
    public BaseResult update(Used used) {
        BaseResult baseResult = BaseResult.success();
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            UsedDetail usedDetail = used.getUsedDetail();
            usedDao.updateUsedDetail(usedDetail);
            usedDao.updateUsed(used);
            baseResult.setMessage("编辑快递订单成功");
        }
        return baseResult;
    }

    @Override
    public void delete(String used_detail_id) {
        usedDao.deleteUsed(used_detail_id);
        usedDao.deleteUsedDetail(used_detail_id);
    }

}
