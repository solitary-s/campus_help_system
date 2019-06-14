package com.aloneness.compusHelpSystem.service;

import com.aloneness.compusHelpSystem.entity.APIResult;
import com.aloneness.compusHelpSystem.entity.User;

import java.util.List;

public interface UserService {

    public APIResult register(User user);

    public APIResult login(String account, String password);

    public APIResult getUser(String account);
}
