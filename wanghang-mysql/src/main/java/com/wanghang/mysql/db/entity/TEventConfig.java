package com.wanghang.mysql.db.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;


import com.wanghang.mysql.common.service.logic.entity.BaseMode;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * (订单追踪)事件配置表
 * </p>
 *
 * @author Damon
 * @since 2019-08-15
 */
@Data
@Accessors(chain = true)
@TableName("t_event_config")
public class TEventConfig extends BaseMode<TEventConfig> {

    private static final long serialVersionUID = 1L;
    /**
     * sysno
     */
	@TableId(value="sysno", type= IdType.AUTO)
	private Integer sysno;
    /**
     * 事件编码
     */
	@TableField("event_code")
	private String eventCode;
    /**
     * 事件名称
     */
	@TableField("event_name")
	private String eventName;
    /**
     * 状态 1 生效 2 禁用
     */
	private Integer status;
    /**
     * created_by
     */
	@TableField("created_by")
	private Integer createdBy;
    /**
     * updated_by
     */
	@TableField("updated_by")
	private Integer updatedBy;


	@Override
	protected Serializable pkVal() {
		return this.sysno;
	}

}
