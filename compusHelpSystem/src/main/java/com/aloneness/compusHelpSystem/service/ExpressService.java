package com.aloneness.compusHelpSystem.service;

import com.aloneness.compusHelpSystem.entity.APIResult;
import com.aloneness.compusHelpSystem.entity.Express;

public interface ExpressService {

    APIResult saveExpress(Express express);

    APIResult getByExpressDetailId(String express_detail_id);

    APIResult getExpressByPage(int currPage);

    APIResult getExpressByPageAndSearch(int currPage, String search_content);

    APIResult getExpressByPublish(String publish_id);

    APIResult getExpressByAccept(String accept_id);

    APIResult getExpressByProcess(String phone);

    APIResult getExpressByFinish(String phone);

    APIResult updateExpressByAccept(String express_detail_id, String accept_id);

    APIResult cancelExpress(String express_detail_id);

    APIResult finishExpress(String express_detail_id);

}
