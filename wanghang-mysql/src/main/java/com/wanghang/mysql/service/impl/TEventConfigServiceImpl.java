package com.wanghang.mysql.service.impl;


import com.wanghang.mysql.common.service.logic.entity.BaseService;
import com.wanghang.mysql.db.entity.TEventConfig;
import com.wanghang.mysql.db.mapper.TEventConfigMapper;
import com.wanghang.mysql.service.ITEventConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * (订单追踪)事件配置表 服务实现类
 * </p>
 *
 * @author Damon
 * @since 2019-08-15
 */
@Service
public class TEventConfigServiceImpl extends BaseService<TEventConfigMapper, TEventConfig> implements ITEventConfigService{

	private static final String EVENT_CODE_PRE="PT";


	@Autowired
	private TEventConfigMapper tEventConfigMapper;


	@Override
	public String getEventSysno() throws Exception {
		String eventCode=null;
		List<Integer> list = tEventConfigMapper.getEventSysno();
		if(list==null || list.size()==0){
			eventCode=EVENT_CODE_PRE+"001";
		}else {
			Integer  currentSysno = list.get(0);
			if(String.valueOf(currentSysno).length()==1){
				eventCode=EVENT_CODE_PRE+"00"+(currentSysno+1);
			}else if(String.valueOf(currentSysno).length()==2){
				eventCode=EVENT_CODE_PRE+"0"+(currentSysno+1);
			}else if(String.valueOf(currentSysno).length()==3){
				eventCode=EVENT_CODE_PRE+(currentSysno+1);
			}else {
				throw new Exception("生成事件编码异常");
			}
		}
		return eventCode;
	}


}
