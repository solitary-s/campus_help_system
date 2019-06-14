package com.aloneness.compusHelpSystem.web.controller;

import com.aloneness.compusHelpSystem.dto.BaseResult;
import com.aloneness.compusHelpSystem.dto.PageInfo;
import com.aloneness.compusHelpSystem.entity.User;
import com.aloneness.compusHelpSystem.service.UserService;
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
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        String account = ids;
        if (StringUtils.isNotBlank(account)) {
            userService.delete(account);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }
        return baseResult;
    }


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = userService.save(user);

        if(baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = userService.update(user);

        if(baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "user_update";
        }
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "user_form";
    }



    @RequestMapping(value = "formUpdate", method = RequestMethod.GET)
    public String update(Model model,@RequestParam(required = true) String account){
        User user = userService.getByAccount(account);
        model.addAttribute("user",user);
        return "user_update";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "user_list";
    }

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<User> page(HttpServletRequest request, User user){
        Map<String,Object> result = new HashMap<>();
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
        System.out.println(user);
        PageInfo<User> pageInfo = userService.page(start,length,draw,user);
        return pageInfo;
    }

}
