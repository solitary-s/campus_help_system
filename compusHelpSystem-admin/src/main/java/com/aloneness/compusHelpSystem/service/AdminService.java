package com.aloneness.compusHelpSystem.service;

import com.aloneness.compusHelpSystem.entity.Admin;

public interface AdminService {

    Admin login(String email,String password);

}
