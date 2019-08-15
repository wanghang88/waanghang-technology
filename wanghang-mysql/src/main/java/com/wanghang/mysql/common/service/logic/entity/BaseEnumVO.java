package com.wanghang.mysql.common.service.logic.entity;



public class BaseEnumVO {
	private String key;
	private String label;

	public BaseEnumVO(String key, String label) {
		this.key = key;
		this.label = label;
	}

	public String getKey() {
		return this.key;
	}

	public String getLabel() {
		return this.label;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof BaseEnumVO)) {
			return false;
		} else {
			BaseEnumVO other = (BaseEnumVO)o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				Object this$key = this.getKey();
				Object other$key = other.getKey();
				if (this$key == null) {
					if (other$key != null) {
						return false;
					}
				} else if (!this$key.equals(other$key)) {
					return false;
				}

				Object this$label = this.getLabel();
				Object other$label = other.getLabel();
				if (this$label == null) {
					if (other$label != null) {
						return false;
					}
				} else if (!this$label.equals(other$label)) {
					return false;
				}

				return true;
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof BaseEnumVO;
	}

	public int hashCode() {
		int result = 1;
		Object $key = this.getKey();
		result = result * 59 + ($key == null ? 43 : $key.hashCode());
		Object $label = this.getLabel();
		result = result * 59 + ($label == null ? 43 : $label.hashCode());
		return result;
	}

	public String toString() {
		return "BaseEnumVO(key=" + this.getKey() + ", label=" + this.getLabel() + ")";
	}


}
