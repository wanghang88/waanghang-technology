package com.wanghang.mysql.common.enmuns;

public interface EnumBase<C, T extends Enum<T> & EnumBase<C, T>> {
	C getCode();

	String getName();
}
