package com.enumtype;

public enum EnumType {
	USER_REGIST(100,"用户注册"),
	SEND_EMAIL(110,"发送邮件");
	
	private final int id;
	private final String name;
	private EnumType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static EnumType getTypeName(int id){
		for (EnumType type : EnumType.values()) {
			if(type.getId()==id){
				return type;
			}
		}
		 throw new RuntimeException("错误的服务类型~");
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
