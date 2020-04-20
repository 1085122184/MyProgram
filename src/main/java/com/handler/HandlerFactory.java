package com.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.enumtype.EnumType;

@Component
public class HandlerFactory {
	 private static Map<EnumType, HandlerService> handlerMap = new ConcurrentHashMap<EnumType, HandlerService>();
	
	public void regist(HandlerService handler){
		EnumType serviceType = handler.getType();
		System.out.println("注册类型："+serviceType);
		handlerMap.put(serviceType, handler);
	}
	
    public HandlerService getHandler(int serviceType){
    	EnumType enumType = EnumType.getTypeName(serviceType);
		return handlerMap.get(enumType);
	}
	public void test(){
		System.out.println(handlerMap.size());
	}

}
