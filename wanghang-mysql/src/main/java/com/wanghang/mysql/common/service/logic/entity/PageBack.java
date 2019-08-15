package com.wanghang.mysql.common.service.logic.entity;


import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PageBack<T>{
	@ApiModelProperty("当前页")
	protected Integer page;
	@ApiModelProperty("每页数")
	protected Integer pageSize;
	@ApiModelProperty("总条数")
	protected Integer total;
	@ApiModelProperty("当前数据")
	protected List<T> records;
	public PageBack() {
	}

	public PageBack(Page<?> pages, List<T> records) {
		this.page = pages.getCurrent();
		this.pageSize = pages.getSize();
		this.total = pages.getTotal();
		this.records = records;
	}

	public PageBack(PageBack<?> pages, List<T> records) {
		this.page = pages.getPage();
		this.pageSize = pages.getPageSize();
		this.total = pages.getTotal();
		this.records = records;
	}

	public static <T> PageBack.PageBackBuilder<T> builder() {
		return new PageBack.PageBackBuilder();
	}

	public Integer getPage() {
		return this.page;
	}

	public Integer getPageSize() {
		return this.pageSize;
	}

	public Integer getTotal() {
		return this.total;
	}

	public List<T> getRecords() {
		return this.records;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof PageBack)) {
			return false;
		} else {
			PageBack<?> other = (PageBack)o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				label59: {
					Object this$page = this.getPage();
					Object other$page = other.getPage();
					if (this$page == null) {
						if (other$page == null) {
							break label59;
						}
					} else if (this$page.equals(other$page)) {
						break label59;
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

				Object this$total = this.getTotal();
				Object other$total = other.getTotal();
				if (this$total == null) {
					if (other$total != null) {
						return false;
					}
				} else if (!this$total.equals(other$total)) {
					return false;
				}

				Object this$records = this.getRecords();
				Object other$records = other.getRecords();
				if (this$records == null) {
					if (other$records != null) {
						return false;
					}
				} else if (!this$records.equals(other$records)) {
					return false;
				}

				return true;
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof PageBack;
	}

	public int hashCode() {
		int result = 1;
		Object $page = this.getPage();
		result = result * 59 + ($page == null ? 43 : $page.hashCode());
		Object $pageSize = this.getPageSize();
		result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
		Object $total = this.getTotal();
		result = result * 59 + ($total == null ? 43 : $total.hashCode());
		Object $records = this.getRecords();
		result = result * 59 + ($records == null ? 43 : $records.hashCode());
		return result;
	}

	public String toString() {
		return "PageBack(page=" + this.getPage() + ", pageSize=" + this.getPageSize() + ", total=" + this.getTotal() + ", records=" + this.getRecords() + ")";
	}

	public PageBack(Integer page, Integer pageSize, Integer total, List<T> records) {
		this.page = page;
		this.pageSize = pageSize;
		this.total = total;
		this.records = records;
	}

	public static class PageBackBuilder<T> {
		private Integer page;
		private Integer pageSize;
		private Integer total;
		private List<T> records;

		PageBackBuilder() {
		}
		public PageBack.PageBackBuilder<T> page(Integer page) {
			this.page = page;
			return this;
		}

		public PageBack.PageBackBuilder<T> pageSize(Integer pageSize) {
			this.pageSize = pageSize;
			return this;
		}

		public PageBack.PageBackBuilder<T> total(Integer total) {
			this.total = total;
			return this;
		}
		public PageBack.PageBackBuilder<T> records(List<T> records) {
			this.records = records;
			return this;
		}
		public PageBack<T> build() {
			return new PageBack(this.page, this.pageSize, this.total, this.records);
		}

		public String toString() {
			return "PageBack.PageBackBuilder(page=" + this.page + ", pageSize=" + this.pageSize + ", total=" + this.total + ", records=" + this.records + ")";
		}
	}
}
