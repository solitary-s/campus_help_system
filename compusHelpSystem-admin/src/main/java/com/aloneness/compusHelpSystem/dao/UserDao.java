package com.aloneness.compusHelpSystem.dao;

import com.aloneness.compusHelpSystem.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    /**
     * 分页查询
     * @return
     */
    List<User> page(Map<String,Object> map);

    int count(User user);

    void insert(User user);

    void update(User user);

    User getByAccount(String account);

    List<User> search(User user);

    void delete(String account);
}
