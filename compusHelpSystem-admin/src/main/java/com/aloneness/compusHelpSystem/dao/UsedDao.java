package com.aloneness.compusHelpSystem.dao;

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

    List<Used> page(Map<String,Object> map);

    int count(Used used);

    void updateUsed(Used used);

    void updateUsedDetail(UsedDetail usedDetail);

    void deleteUsed(String used_detail_id);

    void deleteUsedDetail(String used_detail_id);

    Used getByUsedDetailId(String used_detail_id);

}
