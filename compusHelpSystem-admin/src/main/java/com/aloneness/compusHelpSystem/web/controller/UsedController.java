package com.aloneness.compusHelpSystem.web.controller;

import com.aloneness.compusHelpSystem.dto.BaseResult;
import com.aloneness.compusHelpSystem.dto.PageInfo;
import com.aloneness.compusHelpSystem.entity.*;
import com.aloneness.compusHelpSystem.service.UsedService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "used")
public class UsedController {

    @Autowired
    private UsedService usedService;

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute Used used, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = usedService.update(used);
        if(baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/used/list";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "used_update";
        }
    }


    @RequestMapping(value = "formUpdate", method = RequestMethod.GET)
    public String update(Model model,@RequestParam(required = true) String used_detail_id){
        Used used = usedService.getByUsedDetailId(used_detail_id);
        model.addAttribute("used",used);
        return "used_update";
    }


    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String getUsedByDetailId(@RequestParam String used_detail_id, Model model){
        Used used = usedService.getByUsedDetailId(used_detail_id);
        model.addAttribute("used",used);
        return "used_detail";
    }


    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "used_list";
    }

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<Used> page(HttpServletRequest request, @RequestParam(required = false) String publish_id,
                                  @RequestParam(required = false) String accept_id, @RequestParam(required = false) String used_detail_id){
        Map<String,Object> result = new HashMap<>();
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        Used used = new Used();
        used.setPublish_id(publish_id);
        used.setAccept_id(accept_id);

        UsedDetail usedDetail = new UsedDetail();
        usedDetail.setUsed_detail_id(used_detail_id);
        used.setUsedDetail(usedDetail);

        System.out.println(used);
        PageInfo<Used> pageInfo = usedService.page(start,length,draw,used);
        return pageInfo;

    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        String used_detail_id = ids;
        if (StringUtils.isNotBlank(used_detail_id)) {
            usedService.delete(used_detail_id);
            baseResult = BaseResult.success("删除二手物品订单成功");
        } else {
            baseResult = BaseResult.fail("删除二手物品订单失败");
        }
        return baseResult;
    }
}

