package com.wanghang.mysql.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EventConfigVo",description = "平台事件配置对象vo")
public class EventConfigVo {

	@ApiModelProperty(value = "事件id")
	private Integer sysno;

	@ApiModelProperty(value = "事件名称")
	private String eventName;

	@ApiModelProperty(value = "事件编码")
	private String eventCode;

	@ApiModelProperty(value = "状态,新增默认是启用")
	private Integer status;

}
