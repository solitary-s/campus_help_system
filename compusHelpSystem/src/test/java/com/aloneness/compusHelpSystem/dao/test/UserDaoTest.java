package com.aloneness.compusHelpSystem.dao.test;

import com.aloneness.compusHelpSystem.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;


    @Test
    public void testQueryOrderByPage(){

    }

    @Test
    public void testGetByOrderDetailId(){

    }

    @Test
    public void testSaveOrderDetail(){

    }

    @Test
    public void testGetByAccount(){

    }

}
