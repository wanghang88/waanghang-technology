package com.wanghang.mysql.common.service.logic.entity;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class BaseService <Mapper extends BaseMapper<T>, T> implements IBaseService<T> {

	@Autowired
	private Mapper mapperService;


	public T save(T item){
		Integer insert = this.mapperService.insert(item);
		if (insert.intValue() > 0) {
			return item;
		}
		return null;
	}


	public T updateById(T item){
		Integer updateById = this.mapperService.updateById(item);
		if (updateById.intValue() > 0) {
			return item;
		}
		return null;
	}


	public Boolean removeById(Serializable id){
		T item = this.mapperService.selectById(id);
		Integer deleteById = this.mapperService.delete(new EntityWrapper(item));
		if (deleteById.intValue() > 0) {
			return Boolean.valueOf(true);
		}
		return Boolean.valueOf(false);
	}


	public T queryById(Serializable id){
		return (T)this.mapperService.selectById(id);
	}


	public T queryOne(T item){
		List<T> queryList = queryList(item);
		if ((queryList != null) && (queryList.size() > 0)) {
			return (T)queryList.get(0);
		}
		return null;
	}


	public List<T> queryList(T item){
		Wrapper<T> wrapper = new EntityWrapper(item);
		return this.mapperService.selectList(wrapper);
	}


	public Integer queryCount(T item){
		Wrapper<T> wrapper = new EntityWrapper(item);
		return this.mapperService.selectCount(wrapper);
	}


	public PageBack<T> queryPage(PageVo<T> pageVo){
		Wrapper<T> wrapper = new EntityWrapper(pageVo.getParam());
		Page<T> pages = pageVo.getPages();
		PageBack<T> pageBack = queryListPage(pages, wrapper);
		return pageBack;
	}


	public Integer queryCountBy(Wrapper<T> wrapper){
		return this.mapperService.selectCount(wrapper);
	}


	public List<T> queryListBy(Wrapper<T> wrapper){
		return this.mapperService.selectList(wrapper);
	}


	public PageBack<T> queryListPage(Page<T> pages, Wrapper<T> wrapper){
		List<T> selectPage = this.mapperService.selectPage(pages, wrapper);
		PageBack<T> pageBack = new PageBack(pages, selectPage);
		return pageBack;
	}
}
