package com.wanghang.mysql.common.service.logic.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity<T> implements Serializable {

	protected static final long serialVersionUID = 1L;
	@ApiModelProperty("表主键ID")
	@TableId(value="id", type= IdType.UUID)
	protected String id;
	@ApiModelProperty("创建时间")
	@TableField(value="create_time", fill=FieldFill.INSERT)
	protected Date createTime;
	@ApiModelProperty("创修改时间")
	@TableField(value="update_time", fill= FieldFill.INSERT_UPDATE)
	protected Date updateTime;
	@ApiModelProperty("删除标记:0-正常;1-删除")
	@TableLogic
	@TableField(value="del_flag", fill=FieldFill.INSERT)
	protected String delFlag;

	public void setId(String id){
		this.id = id;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}

	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}

	public boolean equals(Object o){
		if (o == this) {
			return true;
		}
		if (!(o instanceof BaseEntity)) {
			return false;
		}
		BaseEntity<?> other = (BaseEntity)o;
		if (!other.canEqual(this)) {
			return false;
		}
		Object this$id = getId();Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
			return false;
		}
		Object this$createTime = getCreateTime();Object other$createTime = other.getCreateTime();
		if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime)) {
			return false;
		}
		Object this$updateTime = getUpdateTime();Object other$updateTime = other.getUpdateTime();
		if (this$updateTime == null ? other$updateTime != null : !this$updateTime.equals(other$updateTime)) {
			return false;
		}
		Object this$delFlag = getDelFlag();Object other$delFlag = other.getDelFlag();return this$delFlag == null ? other$delFlag == null : this$delFlag.equals(other$delFlag);
	}

	protected boolean canEqual(Object other){
		return other instanceof BaseEntity;
	}

	public int hashCode(){
		int PRIME = 59;int result = 1;Object $id = getId();result = result * 59 + ($id == null ? 43 : $id.hashCode());Object $createTime = getCreateTime();result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());Object $updateTime = getUpdateTime();result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());Object $delFlag = getDelFlag();result = result * 59 + ($delFlag == null ? 43 : $delFlag.hashCode());return result;
	}

	public String toString(){
		return "BaseEntity(id=" + getId() + ", createTime=" + getCreateTime() + ", updateTime=" + getUpdateTime() + ", delFlag=" + getDelFlag() + ")";
	}

	public String getId(){
		return this.id;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	public Date getUpdateTime(){
		return this.updateTime;
	}

	public String getDelFlag(){
		return this.delFlag;
	}

	protected Serializable pkVal(){
		return this.id;
	}

}
