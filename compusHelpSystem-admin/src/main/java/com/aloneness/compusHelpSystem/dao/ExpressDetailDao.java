package com.aloneness.compusHelpSystem.dao;

import com.aloneness.compusHelpSystem.entity.ExpressDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpressDetailDao {

    int saveExpressDetail(ExpressDetail expressDetail);

}
