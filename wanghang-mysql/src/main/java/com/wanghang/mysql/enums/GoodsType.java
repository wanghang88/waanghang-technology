package com.wanghang.mysql.enums;


import com.wanghang.mysql.common.enmuns.EnumBase;
import com.wanghang.mysql.common.enmuns.ErrorCodeInterface;
import com.wanghang.mysql.common.service.logic.entity.BaseEnumVO;
import com.wanghang.mysql.common.untils.EnumUtils;

import java.util.List;


/**
 * 双指枚举的使用
 */
public enum GoodsType implements EnumBase<Integer, GoodsType> {
	GENERAL(1, "普通货物"),
	DANGEROUS(2, "危险货物"),
	TEMPERATURECONTROLL(3, "温控货物")
	;


	private Integer code;
	private String name;
	private GoodsType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	public Integer getCode() {
		return this.code;
	}
	public String getName() {
		return this.name;
	}



	public static void main(String[] args) {
		List<BaseEnumVO> enumList = EnumUtils.getEnumList(GoodsType.class);
		System.out.print("enumList:"+enumList);
		GoodsType goodsType = (GoodsType)EnumUtils.getEnumByCode(GoodsType.class, 1);
		System.out.print("goodsType:"+goodsType);  // 这个获取的是,GENERAL这个值
	}


}
