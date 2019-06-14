package com.aloneness.compusHelpSystem.web.controller;

import com.aloneness.compusHelpSystem.entity.APIResult;
import com.aloneness.compusHelpSystem.entity.Express;
import com.aloneness.compusHelpSystem.entity.ExpressDetail;
import com.aloneness.compusHelpSystem.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class ExpressController {

    @Autowired
    private ExpressService expressService;


    @RequestMapping(value = "/express/accept", method = RequestMethod.POST)
    @ResponseBody
    public APIResult acceptExpress(@RequestParam String accept_id,@RequestParam String express_detail_id){
        return expressService.updateExpressByAccept(express_detail_id,accept_id);
    }

    @RequestMapping(value = "/express/cancel", method = RequestMethod.GET)
    @ResponseBody
    public APIResult cancelExpress(@RequestParam String express_detail_id){
        return expressService.cancelExpress(express_detail_id);
    }

    @RequestMapping(value = "/express/finish", method = RequestMethod.GET)
    @ResponseBody
    public APIResult finishExpress(@RequestParam String express_detail_id){
        return expressService.finishExpress(express_detail_id);
    }


    @RequestMapping(value = "/express/getByPublish", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getExpressByPublish(@RequestParam String publish_id){
        return expressService.getExpressByPublish(publish_id);
    }

    @RequestMapping(value = "/express/getByAccept", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getExpressByAccept(@RequestParam String accept_id){
        return expressService.getExpressByAccept(accept_id);
    }

    @RequestMapping(value = "/express/getByProcess", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getExpressByProcess(@RequestParam String phone){
        return expressService.getExpressByProcess(phone);
    }

    @RequestMapping(value = "/express/getByFinish", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getExpressByFinish(@RequestParam String phone){
        return expressService.getExpressByFinish(phone);
    }


    @RequestMapping(value = "/express/detail", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getExpressByDetailId(@RequestParam String express_detail_id){
        return expressService.getByExpressDetailId(express_detail_id);
    }

    @RequestMapping(value = "/express/getByPage", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getExpressByPage(@RequestParam int currPage){
        return expressService.getExpressByPage(currPage);
    }

    @RequestMapping(value = "/express/search", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getExpressByPageAndSearch(@RequestParam int currPage,@RequestParam String search_content){
        return expressService.getExpressByPageAndSearch(currPage,search_content);
    }

    @RequestMapping(value = "/express/publish", method = RequestMethod.POST)
    @ResponseBody
    public APIResult publishExpress(@RequestParam String publish_id,@RequestParam String express_campany,
                                    @RequestParam String express_message,@RequestParam String express_phone,
                                    @RequestParam Float express_reward,@RequestParam String express_site,
                                    @RequestParam String express_contact,@RequestParam String express_note){
        Express express = new Express();
        express.setPublish_id(publish_id);
        express.setOrder_type(101);
        express.setOrder_status(1001);
        ExpressDetail expressDetail = new ExpressDetail();
        expressDetail.setExpress_detail_id(System.currentTimeMillis()+"");
        expressDetail.setExpress_publishtime(new Date());
        expressDetail.setExpress_campany(express_campany);
        expressDetail.setExpress_message(express_message);
        expressDetail.setExpress_phone(express_phone);
        expressDetail.setExpress_site(express_site);
        expressDetail.setExpress_reward(express_reward);
        expressDetail.setExpress_contact(express_contact);
        expressDetail.setExpress_note(express_note);
        express.setExpressDetail(expressDetail);
        return expressService.saveExpress(express);
    }

}
