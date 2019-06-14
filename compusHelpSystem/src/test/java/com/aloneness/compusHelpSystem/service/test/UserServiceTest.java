package com.aloneness.compusHelpSystem.service.test;

import com.aloneness.compusHelpSystem.entity.APIResult;
import com.aloneness.compusHelpSystem.entity.Express;
import com.aloneness.compusHelpSystem.entity.ExpressDetail;
import com.aloneness.compusHelpSystem.entity.User;
import com.aloneness.compusHelpSystem.service.ExpressDetailService;
import com.aloneness.compusHelpSystem.service.ExpressService;
import com.aloneness.compusHelpSystem.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ExpressDetailService expressDetailService;

    @Autowired
    private ExpressService expressService;

    @Test
    public void testSelectAll(){



    }

    @Test
    public void testSaveUser(){
//
//        Express express = new Express();
//        express.setPublish_id("12837619823");
//        express.setOrder_status(1001);
//        express.setOrder_type(101);
//        ExpressDetail expressDetail = new ExpressDetail();
//        expressDetail.setExpress_detail_id("1557111360395");
//        expressDetail.setExpress_campany("圆通");
//        expressDetail.setExpress_message("lkasdjfklsjakldfjklsdj");
//        expressDetail.setExpress_publishtime(new Date());
//        expressDetail.setExpress_phone("13420109876");
//        expressDetail.setExpress_site("海湛B411");
//        expressDetail.setExpress_reward(12f);
//        expressDetail.setExpress_contact("13413397654");
//        expressDetail.setExpress_note("aklsdfjlksajdf");
//        express.setExpressDetail(expressDetail);
//        APIResult apiResult = expressService.saveExpress(express);
//        System.out.println(apiResult);

    }

}
