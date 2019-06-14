package com.aloneness.compusHelpSystem.service.impl;

import com.aloneness.compusHelpSystem.dao.ExpressDetailDao;
import com.aloneness.compusHelpSystem.entity.ExpressDetail;
import com.aloneness.compusHelpSystem.service.ExpressDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpressDetailServiceImpl implements ExpressDetailService {

    @Autowired
    private ExpressDetailDao expressDetailDao;

    @Override
    public void saveExpressDetail(ExpressDetail expressDetail) {
        expressDetailDao.saveExpressDetail(expressDetail);
    }
}
