package com.handler;

import com.enumtype.EnumType;

public interface HandlerService {
	EnumType getType();
	String handler(String req);
}
