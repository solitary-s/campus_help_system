package com.aloneness.compusHelpSystem.service;

import com.aloneness.compusHelpSystem.dto.BaseResult;
import com.aloneness.compusHelpSystem.dto.PageInfo;
import com.aloneness.compusHelpSystem.entity.Used;

public interface UsedService {


    PageInfo<Used> page(int start, int length, int draw, Used used);

    int count(Used used);

    Used getByUsedDetailId(String used_detail_id);

    BaseResult update(Used used);

    void delete(String used_detail_id);

}
