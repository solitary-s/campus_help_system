package com.aloneness.compusHelpSystem.web.controller;

import com.aloneness.compusHelpSystem.dto.BaseResult;
import com.aloneness.compusHelpSystem.dto.PageInfo;
import com.aloneness.compusHelpSystem.entity.Express;
import com.aloneness.compusHelpSystem.entity.ExpressDetail;
import com.aloneness.compusHelpSystem.service.ExpressService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "express")
public class ExpressController {

    @Autowired
    private ExpressService expressService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "express_list";
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String getExpressByDetailId(@RequestParam String express_detail_id, Model model){
        Express express = expressService.getByExpressDetailId(express_detail_id);
        model.addAttribute("express",express);
        return "express_detail";
    }

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<Express> page(HttpServletRequest request, @RequestParam(required = false) String publish_id,
                                  @RequestParam(required = false) String accept_id,@RequestParam(required = false) String express_detail_id){
        Map<String,Object> result = new HashMap<>();
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
        Express express = new Express();
        express.setPublish_id(publish_id);
        express.setAccept_id(accept_id);

        ExpressDetail expressDetail = new ExpressDetail();
        expressDetail.setExpress_detail_id(express_detail_id);
        express.setExpressDetail(expressDetail);

        System.out.println(express);
        PageInfo<Express> pageInfo = expressService.page(start,length,draw,express);
        return pageInfo;

    }

    @RequestMapping(value = "formUpdate", method = RequestMethod.GET)
    public String update(Model model,@RequestParam(required = true) String express_detail_id){
        Express express = expressService.getByExpressDetailId(express_detail_id);
        model.addAttribute("express",express);
        return "express_update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute Express express, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = expressService.update(express);
        if(baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/express/list";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "express_update";
        }
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        String express_detail_id = ids;
        if (StringUtils.isNotBlank(express_detail_id)) {
            expressService.delete(express_detail_id);
            baseResult = BaseResult.success("删除快递订单成功");
        } else {
            baseResult = BaseResult.fail("删除快递订单失败");
        }
        return baseResult;
    }

}
