package com.aloneness.compusHelpSystem.service;

import com.aloneness.compusHelpSystem.dto.BaseResult;
import com.aloneness.compusHelpSystem.dto.PageInfo;
import com.aloneness.compusHelpSystem.entity.Express;

public interface ExpressService {


    PageInfo<Express> page(int start, int length, int draw, Express express);

    int count(Express express);

    Express getByExpressDetailId(String express_detail_id);

    BaseResult update(Express express);

    void delete(String express_detail_id);

}
