package com.handler.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enumtype.EnumType;
import com.handler.HandlerFactory;
import com.handler.HandlerService;
import com.service.UserService;
@Component
public class RegistHandler implements HandlerService {
	@Autowired
	UserService service;
	@Autowired
	HandlerFactory handlerFactory;
	
	
	
	@PostConstruct
	void init(){
		handlerFactory.regist(this);
	}
	

	@Override
	public EnumType getType() {
		// TODO Auto-generated method stub
		return EnumType.USER_REGIST;
	}

	@Override
	public String handler(String req) {
		service.test();
		return "regist SUCCESS";
	}

}
