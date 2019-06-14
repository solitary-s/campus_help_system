package com.aloneness.compusHelpSystem.dao;

import com.aloneness.compusHelpSystem.entity.Express;
import com.aloneness.compusHelpSystem.entity.ExpressDetail;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface ExpressDao {

    void saveExpress(Express express);

    Express getByExpressDetailId(String express_detail_id);

    List<Express> queryExpressByPage(Map<String,Object> data);

    List<Express> queryExpressByPageAndSearCh(Map<String,Object> data);

    List<Express> getExpressByPublish(String publish_id);

    List<Express> getExpressByAccept(String accept_id);

    List<Express> getExpressByProcess(String phone);

    List<Express> getExpressByFinish(String phone);

    void updateExpressByAccept(Express express);

    void cancelExpress(Express express);

    void finishExpress(Express express);

    void finishExpressDetail(ExpressDetail expressDetail);

}
