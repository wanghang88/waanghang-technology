package com.wanghang.mysql.common.service.logic.entity;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;


/**
 * IBaseService上面的@RequestMapping注解可以不用, 可以根据需要添加(可能service需要独立部署等，还需思考下）
 * @param <T>
 */

public interface IBaseService<T>{

	@RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST}, value={"/save"})
	public abstract T save(@RequestBody T paramT);

	@RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST}, value={"/updateById"})
	public abstract T updateById(@RequestBody T paramT);

	@RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/removeById"})
	public abstract Boolean removeById(@RequestParam("id") Serializable paramSerializable);

	@RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/queryById"})
	public abstract T queryById(@RequestParam("id") Serializable paramSerializable);

	@RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST}, value={"/queryOne"})
	public abstract T queryOne(@RequestBody T paramT);

	@RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST}, value={"/queryCount"})
	public abstract Integer queryCount(@RequestBody T paramT);

	@RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST}, value={"/queryList"})
	public abstract List<T> queryList(@RequestBody T paramT);

	@RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST}, value={"/queryPage"})
	public abstract PageBack<T> queryPage(@RequestBody PageVo<T> paramPageVo);
}
