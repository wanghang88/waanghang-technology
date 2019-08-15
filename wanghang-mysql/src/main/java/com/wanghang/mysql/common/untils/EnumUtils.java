package com.wanghang.mysql.common.untils;


import com.wanghang.mysql.common.enmuns.EnumBase;
import com.wanghang.mysql.common.service.logic.entity.BaseEnumVO;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EnumUtils {

	public EnumUtils(){
	}

	public static <E extends Enum<E> & EnumBase<Integer, E>> E getEnumByCode(Class<E> enumClass, Integer code) {
		if (code == null) {
			return null;
		} else {
			List<E> enumList = org.apache.commons.lang3.EnumUtils.getEnumList(enumClass);
			Iterator var3 = enumList.iterator();

			Enum e;
			do {
				if (!var3.hasNext()) {
					return null;
				}

				e = (Enum)var3.next();
			} while(!((Integer)((EnumBase)e).getCode()).equals(code));
			return (E) e;
		}
	}

	public static <E extends Enum<E> & EnumBase<Integer, E>> List<BaseEnumVO> getEnumList(Class<E> enumClass) {
		return (List) org.apache.commons.lang3.EnumUtils.getEnumList(enumClass).stream().map((e) -> {
			return new BaseEnumVO(((Integer)((EnumBase)e).getCode()).toString(), ((EnumBase)e).getName());
		}).collect(Collectors.toList());
	}





}
