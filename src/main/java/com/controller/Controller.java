package com.controller;

import com.alibaba.fastjson.JSON;
import com.entity.User;
import com.service.UserService;
import com.service.UserService2;
import com.service.UserService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    @Autowired
    UserService service;



    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage()  {
    	long startTime = System.currentTimeMillis();

        return "ok";
    }
    @GetMapping("/test")
    public String test()  {
        for (int i=0;i<10;i++){
            service.test();
        }
    	return "ok";
    }
}
