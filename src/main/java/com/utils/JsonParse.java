package com.utils;



import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class JsonParse<T> {
	
	public String toString(Class<T> clazz){
		return JSON.toJSONString(clazz);
	}
	
	public T toObject(String text,Class<T> clazz){
		return JSON.parseObject(text, clazz);
	}
	
	
}