package com.aloneness.compusHelpSystem.web.controller;

import com.aloneness.compusHelpSystem.entity.*;
import com.aloneness.compusHelpSystem.service.UsedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class UsedController {

    @Autowired
    private UsedService usedService;

    private Logger logger = LoggerFactory.getLogger(UsedController.class);

    @RequestMapping(value = "/used/accept", method = RequestMethod.POST)
    @ResponseBody
    public APIResult acceptUsed(@RequestParam String accept_id,@RequestParam String used_detail_id){
        return usedService.updateUsedByAccept(used_detail_id, accept_id);
    }

    @RequestMapping(value = "/used/cancel", method = RequestMethod.GET)
    @ResponseBody
    public APIResult cancelUsed(@RequestParam String used_detail_id){
        return usedService.cancelUsed(used_detail_id);
    }

    @RequestMapping(value = "/used/finish", method = RequestMethod.GET)
    @ResponseBody
    public APIResult finishUsed(@RequestParam String used_detail_id){
        return usedService.finishUsed(used_detail_id);
    }


    @RequestMapping(value = "/used/getByPublish", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getOrderByPublish(@RequestParam String publish_id){
        return usedService.getUsedByPublish(publish_id);
    }

    @RequestMapping(value = "/used/getByAccept", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getOrderByAccept(@RequestParam String accept_id){
        return usedService.getUsedByAccept(accept_id);
    }

    @RequestMapping(value = "/used/getByProcess", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getOrderByProcess(@RequestParam String phone){
        return usedService.getUsedByProcess(phone);
    }

    @RequestMapping(value = "/used/getByFinish", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getOrderByFinish(@RequestParam String phone){
        return usedService.getUsedByFinish(phone);
    }


    @RequestMapping(value = "/used/detail", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getExpressByPage(@RequestParam String used_detail_id){
        return usedService.getByUsedDetailId(used_detail_id);
    }


    @RequestMapping(value = "/used/getByPage", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getExpressByPage(@RequestParam int currPage){
        return usedService.getUsedByPage(currPage);
    }

    @RequestMapping(value = "/used/search", method = RequestMethod.GET)
    @ResponseBody
    public APIResult getExpressByPage(@RequestParam int currPage,@RequestParam String search_content){
        return usedService.getUsedByPageAndSearch(currPage,search_content);
    }


    @RequestMapping(value = "/used/publish", method = RequestMethod.POST)
    @ResponseBody
    public APIResult publishExpress(@RequestParam String used_title,@RequestParam String used_message,
                                    @RequestParam String used_contact,@RequestParam String used_note,
                                    @RequestParam Float used_price,@RequestParam String used_img,
                                    @RequestParam String publish_id){
        Used used = new Used();
        used.setPublish_id(publish_id);
        used.setOrder_type(102);
        used.setOrder_status(1001);
        UsedDetail usedDetail = new UsedDetail();
        usedDetail.setUsed_detail_id(System.currentTimeMillis()+"");
        usedDetail.setUsed_publishtime(new Date());
        usedDetail.setUsed_title(used_title);
        usedDetail.setUsed_message(used_message);
        usedDetail.setUsed_contact(used_contact);
        usedDetail.setUsed_note(used_note);
        usedDetail.setUsed_price(used_price);
        usedDetail.setUsed_img(used_img);
        used.setUsedDetail(usedDetail);
        return usedService.saveUsed(used);
    }

    @ResponseBody
    @RequestMapping(value = "/used/upload")
    public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        APIResult apiResult = new APIResult();
        request.setCharacterEncoding("UTF-8");
        logger.info("执行图片上传");
        String user = request.getParameter("user");
        logger.info("user:"+user);
        String trueFileName = null;
        if(!file.isEmpty()) {
            logger.info("成功获取照片");
            String fileName = file.getOriginalFilename();
            String path = null;
            String type = null;
            logger.info("图片初始名称为：" + fileName);
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            logger.info("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF");
                    // 自定义的文件名称
                    trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = realPath + "\\uploads\\" + trueFileName;
                    logger.info("存放图片文件的路径:" + path);
                    File f = new File(path);
                    File fp = f.getParentFile();
                    if(!fp.exists()){
                        fp.mkdirs();
                    }
                    file.transferTo(f);
                    logger.info("文件成功上传到指定目录下");
                }else {
                    logger.info("不是我们想要的文件类型,请按要求重新上传");
                    return "";
                }
            }else {
                return "";
            }
        }else {
            return "";
        }
        return trueFileName;
    }
}

