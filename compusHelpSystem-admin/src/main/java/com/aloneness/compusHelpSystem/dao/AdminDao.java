package com.aloneness.compusHelpSystem.dao;

import com.aloneness.compusHelpSystem.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created by huanshaolst on 2019/5/17.
 */
@Repository
public interface AdminDao {

    /***
     * 根据邮箱密码返回用户
     * @param email
     * @return
     */

    Admin getAdminByEmailAndPassword(String email);

}
