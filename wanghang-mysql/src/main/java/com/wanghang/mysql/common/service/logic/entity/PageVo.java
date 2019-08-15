package com.wanghang.mysql.common.service.logic.entity;

import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class PageVo<T> {
	@ApiModelProperty("当前页")
	protected Integer page;
	@ApiModelProperty("每页数")
	protected Integer pageSize;
	@ApiModelProperty("当前参数")
	protected T param;
	@ApiModelProperty("排序字段")
	protected String orderByField;
	@ApiModelProperty("排序类型：0升序1降序")
	protected Integer type;

	@JsonIgnore
	public Page<T> getPages() {
		Page<T> pages = new Page(this.page, this.pageSize);
		if (this.type != null) {
			if (this.type == 0) {
				pages.setOrderByField(this.orderByField);
				pages.setAsc(true);
			}
			if (this.type == 1) {
				pages.setOrderByField(this.orderByField);
				pages.setAsc(false);
			}
		}
		return pages;
	}

	public static <T> PageVo.PageVoBuilder<T> builder() {
		return new PageVo.PageVoBuilder();
	}

	public Integer getPage() {
		return this.page;
	}

	public Integer getPageSize() {
		return this.pageSize;
	}

	public T getParam() {
		return this.param;
	}

	public String getOrderByField() {
		return this.orderByField;
	}

	public Integer getType() {
		return this.type;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setParam(T param) {
		this.param = param;
	}

	public void setOrderByField(String orderByField) {
		this.orderByField = orderByField;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof PageVo)) {
			return false;
		} else {
			PageVo<?> other = (PageVo)o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				label71: {
					Object this$page = this.getPage();
					Object other$page = other.getPage();
					if (this$page == null) {
						if (other$page == null) {
							break label71;
						}
					} else if (this$page.equals(other$page)) {
						break label71;
					}

					return false;
				}

				Object this$pageSize = this.getPageSize();
				Object other$pageSize = other.getPageSize();
				if (this$pageSize == null) {
					if (other$pageSize != null) {
						return false;
					}
				} else if (!this$pageSize.equals(other$pageSize)) {
					return false;
				}

				label57: {
					Object this$param = this.getParam();
					Object other$param = other.getParam();
					if (this$param == null) {
						if (other$param == null) {
							break label57;
						}
					} else if (this$param.equals(other$param)) {
						break label57;
					}

					return false;
				}

				Object this$orderByField = this.getOrderByField();
				Object other$orderByField = other.getOrderByField();
				if (this$orderByField == null) {
					if (other$orderByField != null) {
						return false;
					}
				} else if (!this$orderByField.equals(other$orderByField)) {
					return false;
				}

				Object this$type = this.getType();
				Object other$type = other.getType();
				if (this$type == null) {
					if (other$type == null) {
						return true;
					}
				} else if (this$type.equals(other$type)) {
					return true;
				}
				return false;
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof PageVo;
	}

	public int hashCode() {
		int result = 1;
		Object $page = this.getPage();
		result = result * 59 + ($page == null ? 43 : $page.hashCode());
		Object $pageSize = this.getPageSize();
		result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
		Object $param = this.getParam();
		result = result * 59 + ($param == null ? 43 : $param.hashCode());
		Object $orderByField = this.getOrderByField();
		result = result * 59 + ($orderByField == null ? 43 : $orderByField.hashCode());
		Object $type = this.getType();
		result = result * 59 + ($type == null ? 43 : $type.hashCode());
		return result;
	}

	public String toString() {
		return "PageVo(page=" + this.getPage() + ", pageSize=" + this.getPageSize() + ", param=" + this.getParam() + ", orderByField=" + this.getOrderByField() + ", type=" + this.getType() + ")";
	}

	public PageVo() {
	}
	public PageVo(Integer page, Integer pageSize, T param, String orderByField, Integer type) {
		this.page = page;
		this.pageSize = pageSize;
		this.param = param;
		this.orderByField = orderByField;
		this.type = type;
	}
	public static class PageVoBuilder<T> {
		private Integer page;
		private Integer pageSize;
		private T param;
		private String orderByField;
		private Integer type;

		PageVoBuilder() {
		}
		public PageVo.PageVoBuilder<T> page(Integer page) {
			this.page = page;
			return this;
		}
		public PageVo.PageVoBuilder<T> pageSize(Integer pageSize) {
			this.pageSize = pageSize;
			return this;
		}
		public PageVo.PageVoBuilder<T> param(T param) {
			this.param = param;
			return this;
		}
		public PageVo.PageVoBuilder<T> orderByField(String orderByField) {
			this.orderByField = orderByField;
			return this;
		}
		public PageVo.PageVoBuilder<T> type(Integer type) {
			this.type = type;
			return this;
		}
		public PageVo<T> build() {
			return new PageVo(this.page, this.pageSize, this.param, this.orderByField, this.type);
		}
		public String toString() {
			return "PageVo.PageVoBuilder(page=" + this.page + ", pageSize=" + this.pageSize + ", param=" + this.param + ", orderByField=" + this.orderByField + ", type=" + this.type + ")";
		}
	}



}
