package com.aloneness.compusHelpSystem.service.impl;

import com.aloneness.compusHelpSystem.dao.AdminDao;
import com.aloneness.compusHelpSystem.entity.Admin;
import com.aloneness.compusHelpSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String email, String password) {
        Admin admin = adminDao.getAdminByEmailAndPassword(email);
        if(admin == null){
            return null;
        }else{
            if(admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }
}
