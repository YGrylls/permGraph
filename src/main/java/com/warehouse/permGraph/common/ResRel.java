package com.warehouse.permGraph.common;

import com.warehouse.permGraph.model.IRel;

public class ResRel {
	private Integer target;
	private Integer source;
	private String title;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ResRel(int start, int end, IRel r) {
		this.source = start;
		this.target = end;
		this.title = r.getTitle();
		this.type = r.getType();
	}

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "ResRel [target=" + target + ", source=" + source + ", title=" + title + ", type=" + type + "]";
	}

}
