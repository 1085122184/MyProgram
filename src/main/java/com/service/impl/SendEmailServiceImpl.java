package com.service.impl;

import org.springframework.stereotype.Service;

import com.service.SendEmailService;
@Service
public class SendEmailServiceImpl implements SendEmailService{

	@Override
	public void send() {
		System.out.println("send email");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
