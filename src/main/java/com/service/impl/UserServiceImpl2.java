package com.service.impl;

import java.util.List;

import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.service.UserService2;
@Service
public class UserServiceImpl2 implements UserService2{
	@Autowired
	UserMapper mapper;
	
	@Override
	@Async
	public void test(int i) {
		try {
			System.out.println("service2开始了");
//			User user = new User();
//				user.setEmail("service2@com"+i);
//				user.setName("service2"+i);
				//mapper.insert(user);
//			List<User> list = mapper.selectAll();
//			for (User user2 : list) {
//				System.out.println("service2select"+user2.getName());
//			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
