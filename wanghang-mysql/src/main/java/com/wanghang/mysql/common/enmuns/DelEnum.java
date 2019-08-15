package com.wanghang.mysql.common.enmuns;

public enum DelEnum {
	VALID(0, "有效的"),
	NO_VALID(1, "无效的");

	public int type;
	public String name;
	private DelEnum(int type, String name){
		this.type = type;
		this.name = name;
	}
	public int getType(){
		return this.type;
	}
	public String getName(){
		return this.name;
	}
}
