package com.aloneness.compusHelpSystem.dao;

import com.aloneness.compusHelpSystem.entity.UsedDetail;
import org.springframework.stereotype.Repository;

/**
 * Created by huanshaolst on 2019/5/7.
 */
@Repository
public interface UsedDetailDao {

    void saveUsedDetail(UsedDetail usedDetail);
}
