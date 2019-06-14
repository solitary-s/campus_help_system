package com.aloneness.compusHelpSystem.dao;

import com.aloneness.compusHelpSystem.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public void insert(User user);

    public User getByAccount(String account);

}
