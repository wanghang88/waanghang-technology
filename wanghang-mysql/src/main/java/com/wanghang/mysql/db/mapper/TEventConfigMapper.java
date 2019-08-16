package com.wanghang.mysql.db.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wanghang.mysql.db.entity.TEventConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  * (订单追踪)事件配置表 Mapper 接口
 * </p>
 *
 * @author Damon
 * @since 2019-08-15
 */
@Repository
public interface TEventConfigMapper extends BaseMapper<TEventConfig> {

	List<Integer> getEventSysno();


}