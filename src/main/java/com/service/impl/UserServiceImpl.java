package com.service.impl;

import java.util.List;

import com.entity.User;
import com.utils.async.ExecutorPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper mapper;
	@Autowired
	ExecutorPool executorPool;
	
	@Override
	public void test() {
			executorPool.Async(new Runnable() {
				@Override
				public void run() {
					System.out.println("service1开始了");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});

//			User user = new User();
//			user.setEmail("service1@com");
//			user.setName("service1");
//			mapper.insert(user);
//			List<User> list = mapper.selectAll();
//			for (User user2 : list) {
//				System.out.println("service1select"+user2.getName());
//			}
	}

}
