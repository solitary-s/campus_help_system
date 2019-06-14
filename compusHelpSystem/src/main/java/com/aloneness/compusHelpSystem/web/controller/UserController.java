package com.aloneness.compusHelpSystem.web.controller;

import com.aloneness.compusHelpSystem.entity.APIResult;
import com.aloneness.compusHelpSystem.entity.User;
import com.aloneness.compusHelpSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "";
    }

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    @ResponseBody
    public APIResult register(@ModelAttribute User user){
        return userService.register(user);
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public APIResult userLogin(@RequestParam String account, @RequestParam String password){
        return userService.login(account,password);
    }

    @RequestMapping(value = "/user/get",method = RequestMethod.GET)
    @ResponseBody
    public APIResult getUser(@RequestParam String acceptId){
        return userService.getUser(acceptId);
    }

}
