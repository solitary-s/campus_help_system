package com.aloneness.compusHelpSystem.dao;

import com.aloneness.compusHelpSystem.entity.Express;
import com.aloneness.compusHelpSystem.entity.ExpressDetail;
import com.aloneness.compusHelpSystem.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface ExpressDao {

    List<Express> page(Map<String,Object> map);

    int count(Express express);

    void updateExpress(Express express);

    void updateExpressDetail(ExpressDetail expressDetail);

    void deleteExpress(String express_detail_id);

    void deleteExpressDetail(String express_detail_id);

    Express getByExpressDetailId(String express_detail_id);


}
