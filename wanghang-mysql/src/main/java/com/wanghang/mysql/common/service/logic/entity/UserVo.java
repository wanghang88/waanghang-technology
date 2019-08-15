package com.wanghang.mysql.common.service.logic.entity;


import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UserVo {
	@ApiModelProperty("用户ID")
	protected String userId;
	@ApiModelProperty("业务团体")
	protected String tenantId;
	@ApiModelProperty("用户角色")
	private List<String> roleIds;
	@ApiModelProperty("用户ID")
	protected String openId;
	@ApiModelProperty("isAdmin:0不是1是")
	private Integer isAdmin;
	public UserVo() {
	}
	public String getUserId() {
		return this.userId;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public List<String> getRoleIds() {
		return this.roleIds;
	}

	public String getOpenId() {
		return this.openId;
	}

	public Integer getIsAdmin() {
		return this.isAdmin;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof UserVo)) {
			return false;
		} else {
			UserVo other = (UserVo)o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				label71: {
					Object this$userId = this.getUserId();
					Object other$userId = other.getUserId();
					if (this$userId == null) {
						if (other$userId == null) {
							break label71;
						}
					} else if (this$userId.equals(other$userId)) {
						break label71;
					}

					return false;
				}

				Object this$tenantId = this.getTenantId();
				Object other$tenantId = other.getTenantId();
				if (this$tenantId == null) {
					if (other$tenantId != null) {
						return false;
					}
				} else if (!this$tenantId.equals(other$tenantId)) {
					return false;
				}

				label57: {
					Object this$roleIds = this.getRoleIds();
					Object other$roleIds = other.getRoleIds();
					if (this$roleIds == null) {
						if (other$roleIds == null) {
							break label57;
						}
					} else if (this$roleIds.equals(other$roleIds)) {
						break label57;
					}

					return false;
				}

				Object this$openId = this.getOpenId();
				Object other$openId = other.getOpenId();
				if (this$openId == null) {
					if (other$openId != null) {
						return false;
					}
				} else if (!this$openId.equals(other$openId)) {
					return false;
				}

				Object this$isAdmin = this.getIsAdmin();
				Object other$isAdmin = other.getIsAdmin();
				if (this$isAdmin == null) {
					if (other$isAdmin == null) {
						return true;
					}
				} else if (this$isAdmin.equals(other$isAdmin)) {
					return true;
				}

				return false;
			}
		}
	}
	protected boolean canEqual(Object other) {
		return other instanceof UserVo;
	}

	public int hashCode() {
		int result = 1;
		Object $userId = this.getUserId();
		result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
		Object $tenantId = this.getTenantId();
		result = result * 59 + ($tenantId == null ? 43 : $tenantId.hashCode());
		Object $roleIds = this.getRoleIds();
		result = result * 59 + ($roleIds == null ? 43 : $roleIds.hashCode());
		Object $openId = this.getOpenId();
		result = result * 59 + ($openId == null ? 43 : $openId.hashCode());
		Object $isAdmin = this.getIsAdmin();
		result = result * 59 + ($isAdmin == null ? 43 : $isAdmin.hashCode());
		return result;
	}

	public String toString() {
		return "UserVo(userId=" + this.getUserId() + ", tenantId=" + this.getTenantId() + ", roleIds=" + this.getRoleIds() + ", openId=" + this.getOpenId() + ", isAdmin=" + this.getIsAdmin() + ")";
	}
}
