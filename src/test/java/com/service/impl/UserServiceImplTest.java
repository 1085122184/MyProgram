package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService service;
    @Autowired
    UserMapper mapper;

    @Test
    public void test1() {
        for (int i=0;i<10;i++){
            service.test();
        }
    }
    @Test
    public void mapperTest(){
       int result= mapper.selectByTime();
         System.out.println(result);
    }
}