package com.wanghang.mysql.db;


import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.wanghang.mysql.common.enmuns.DelEnum;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;


/**
 * 这个类我也不确定有什么用了
 */

public class MyMetaObjectHandler extends MetaObjectHandler{
	@Override
	public void insertFill(MetaObject metaObject) {
		System.out.println("*************************");
		System.out.println("insert fill");
		System.out.println("*************************");

		Object create_time = getFieldValByName("createTime", metaObject);
		Object del_flag = getFieldValByName("delFlag", metaObject);
		Object update_time = getFieldValByName("updateTime", metaObject);
		if (null == update_time) {
			setFieldValByName("updateTime", new Date(), metaObject);
		}
		if (null == create_time) {
			setFieldValByName("createTime", new Date(), metaObject);
		}
		if (null == del_flag) {
			setFieldValByName("delFlag", "" + DelEnum.VALID.getType(), metaObject);
		}
	}
	@Override
	public void updateFill(MetaObject metaObject) {
		System.out.println("*************************");
		System.out.println("update fill");
		System.out.println("*************************");
		Object update_time = getFieldValByName("updateTime", metaObject);
		if (null == update_time) {
			setFieldValByName("updateTime", new Date(), metaObject);
		}
	}
}
