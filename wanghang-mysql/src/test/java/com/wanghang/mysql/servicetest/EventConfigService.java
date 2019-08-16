package com.wanghang.mysql.servicetest;


import com.wanghang.mysql.common.service.logic.entity.PageBack;
import com.wanghang.mysql.common.service.logic.entity.PageVo;
import com.wanghang.mysql.db.entity.TEventConfig;
import com.wanghang.mysql.service.ITEventConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventConfigService {
	@Autowired
	private ITEventConfigService tEventConfigService;


	@Test
	public void  listEventConfigTest(){
		PageVo<TEventConfig> pageVo=new PageVo<TEventConfig>();
		if (Objects.isNull(pageVo.getPage())) {
			pageVo.setPage(1);
		}
		if (Objects.isNull(pageVo.getPageSize())) {
			pageVo.setPageSize(10);
		}
		PageBack<TEventConfig> pageBack = tEventConfigService.queryPage(pageVo);
	}
}
