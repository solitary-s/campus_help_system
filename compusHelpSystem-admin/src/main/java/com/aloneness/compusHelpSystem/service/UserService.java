package com.aloneness.compusHelpSystem.service;

import com.aloneness.compusHelpSystem.dto.BaseResult;
import com.aloneness.compusHelpSystem.dto.PageInfo;
import com.aloneness.compusHelpSystem.entity.User;

import java.util.List;

public interface UserService {

    PageInfo<User> page(int start, int length, int draw, User user);

    int count(User user);

    BaseResult save(User user);

    BaseResult update(User user);

    List<User> search(String keyword);

    User getByAccount(String account);

    void delete(String account);

}
