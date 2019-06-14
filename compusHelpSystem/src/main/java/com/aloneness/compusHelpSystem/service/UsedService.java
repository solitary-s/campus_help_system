package com.aloneness.compusHelpSystem.service;

import com.aloneness.compusHelpSystem.entity.APIResult;

import com.aloneness.compusHelpSystem.entity.Used;

public interface UsedService {

    APIResult saveUsed(Used used);

    APIResult getUsedByPage(int currPage);

    APIResult getUsedByPageAndSearch(int currPage, String search_content);

    APIResult getByUsedDetailId(String used_detail_id);

    APIResult getUsedByPublish(String publish_id);

    APIResult getUsedByAccept(String accept_id);

    APIResult getUsedByProcess(String phone);

    APIResult getUsedByFinish(String phone);

    APIResult updateUsedByAccept(String used_detail_id, String accept_id);

    APIResult cancelUsed(String used_detail_id);

    APIResult finishUsed(String used_detail_id);
}
