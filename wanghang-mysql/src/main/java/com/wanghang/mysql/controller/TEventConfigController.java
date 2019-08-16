package com.wanghang.mysql.controller;


import com.wanghang.mysql.common.response.Response;
import com.wanghang.mysql.common.response.ResponseUtil;
import com.wanghang.mysql.common.service.logic.entity.BaseController;
import com.wanghang.mysql.common.service.logic.entity.PageBack;
import com.wanghang.mysql.common.service.logic.entity.PageVo;
import com.wanghang.mysql.common.service.logic.entity.UserVo;
import com.wanghang.mysql.db.entity.TEventConfig;
import com.wanghang.mysql.service.ITEventConfigService;
import com.wanghang.mysql.vo.EventConfigVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * (订单追踪)事件配置表 前端控制器
 * </p>
 *
 * @author Damon
 * @since 2019-08-15
 */
@RestController
@RequestMapping("/api/basic/tEventConfig")
public class TEventConfigController extends BaseController {

	@Autowired
	private ITEventConfigService tEventConfigService;


	@ApiOperation(value = "平台事件配置列表显示")
	@PostMapping("/listEventConfig")
	public Response<PageBack<TEventConfig>> listEventConfig(@RequestBody PageVo<TEventConfig> pageVo){
		if (Objects.isNull(pageVo.getPage())) {
			pageVo.setPage(1);
		}
		if (Objects.isNull(pageVo.getPageSize())) {
			pageVo.setPageSize(10);
		}
		PageBack<TEventConfig> pageBack = tEventConfigService.queryPage(pageVo);
		return ResponseUtil.ok(pageBack);
	}



	@ApiOperation(value = "设置平台事件配置")
	@PostMapping("/setEventConfig")
	public Response setEventConfig(@RequestBody EventConfigVo eventConfigVo) throws Exception {
		UserVo userVo = this.getUserVo();

		TEventConfig tEventConfig=new TEventConfig();
		String eventName = eventConfigVo.getEventName();
		if(StringUtils.isBlank(eventName)){
			return ResponseUtil.error("平台事件类型不能为空");
		}
		tEventConfig.setEventName(eventConfigVo.getEventName());
		Integer eventNameCont = tEventConfigService.queryCount(tEventConfig);
		if(eventNameCont>0){
			return ResponseUtil.error("该事件类型已存在");
		}
		Integer sysno = eventConfigVo.getSysno();
		if(sysno==null){
			String eventCode = tEventConfigService.getEventSysno();
			tEventConfig.setEventCode(eventCode);
			tEventConfig.setStatus(1);
			tEventConfig.setCreatedBy(Integer.parseInt(userVo.getUserId()));
			tEventConfig.setUpdatedBy(Integer.parseInt(userVo.getUserId()));
			tEventConfigService.save(tEventConfig);
		}else {
			tEventConfig.setSysno(sysno);
			tEventConfig.setStatus(eventConfigVo.getStatus());
			tEventConfig.setUpdatedBy(Integer.parseInt(userVo.getUserId()));
			tEventConfigService.updateById(tEventConfig);
		}
		return ResponseUtil.ok();
	}


	@ApiOperation(value = "根据id查询记录")
	@GetMapping("/getEventConfigBySysno")
	public Response<TEventConfig> getEventConfigBySysno(
			@ApiParam(value = "平台事件记录的sysno",name = "sysno",required = true) @RequestParam(required = true)Integer sysno){
		return ResponseUtil.ok(tEventConfigService.queryById(sysno));
	}


	@ApiOperation(value = "停用或启用平台事件的配置")
	@GetMapping("/setEventConfigIsDisable")
	public Response setEventConfigIsDisable(
			@ApiParam(value = "平台事件记录的sysno",name = "sysno",required = true) @RequestParam(required = true)Integer sysno,
			@ApiParam(value = "平台事件记录的状态,1:启用;0:停用",name = "status",required = true) @RequestParam(required = true)Integer status){
		UserVo userVo = this.getUserVo();
		TEventConfig tEventConfig=new TEventConfig();

		tEventConfig.setSysno(sysno);
		tEventConfig.setStatus(status);
		tEventConfig.setUpdatedBy(Integer.parseInt(userVo.getUserId()));
		tEventConfigService.updateById(tEventConfig);
		return ResponseUtil.ok();
	}


	@ApiOperation(value = "获取平台所有有效事件配置")
	@GetMapping("/getAllEventConfig")
	public Response<List<EventConfigVo>> getAllEventConfig(){
		TEventConfig tEventConfig=new TEventConfig();
		tEventConfig.setStatus(1);
		tEventConfig.setDelFlag("0");
		List<TEventConfig> tEventConfigList = tEventConfigService.queryList(tEventConfig);

		List<EventConfigVo> list=new ArrayList<>();
		if(tEventConfigList!=null && tEventConfigList.size()>0){
			EventConfigVo eventConfigVo=null;
			for(TEventConfig dbtEventConfig:tEventConfigList){
				eventConfigVo=new EventConfigVo();
				eventConfigVo.setEventCode(dbtEventConfig.getEventCode());
				eventConfigVo.setEventName(dbtEventConfig.getEventName());
				list.add(eventConfigVo);
			}
		}
		return ResponseUtil.ok(list);
	}

}
