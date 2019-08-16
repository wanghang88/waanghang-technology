package com.wanghang.mysql.service;

import com.wanghang.mysql.common.service.logic.entity.IBaseService;
import com.wanghang.mysql.db.entity.TEventConfig;

/**
 * <p>
 * (订单追踪)事件配置表 服务类
 * </p>
 *
 * @author Damon
 * @since 2019-08-15
 */
public interface ITEventConfigService extends IBaseService<TEventConfig>{
	String getEventSysno() throws Exception;
	
}
