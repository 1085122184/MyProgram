package com.handler.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enumtype.EnumType;
import com.handler.HandlerFactory;
import com.handler.HandlerService;
import com.service.SendEmailService;
@Component
public class SendEmailHandler implements HandlerService {
	@Autowired
	SendEmailService service;
	@Autowired
	HandlerFactory handlerFactory;
	
	
	
	@PostConstruct
	void init(){
		handlerFactory.regist(this);
	}
	

	@Override
	public EnumType getType() {
		// TODO Auto-generated method stub
		return EnumType.SEND_EMAIL;
	}

	@Override
	public String handler(String req) {
		service.send();
		return "send email SUCCESS";
	}

}
