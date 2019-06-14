package com.aloneness.compusHelpSystem.dao;

import com.aloneness.compusHelpSystem.entity.Express;
import com.aloneness.compusHelpSystem.entity.ExpressDetail;
import com.aloneness.compusHelpSystem.entity.Used;
import com.aloneness.compusHelpSystem.entity.UsedDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by huanshaolst on 2019/5/7.
 */
@Repository
public interface UsedDao {

    void saveUsed(Used used);

    Used getByUsedDetailId(String used_detail_id);

    List<Used> queryUsedByPage(Map<String,Object> data);

    List<Used> queryUsedByPageAndSearCh(Map<String,Object> data);

    List<Used> getUsedByPublish(String publish_id);

    List<Used> getUsedByAccept(String accept_id);

    List<Used> getUsedByProcess(String phone);

    List<Used> getUsedByFinish(String phone);

    void updateUsedByAccept(Used used);

    void cancelUsed(Used used);

    void finishUsed(Used used);

    void finishUsedDetail(UsedDetail usedDetail);

}
