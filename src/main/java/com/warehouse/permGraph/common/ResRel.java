package com.warehouse.permGraph.common;

import com.warehouse.permGraph.model.IRel;

public class ResRel {
	private Integer start;
	private Integer end;
	private String title;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ResRel(int start, int end, IRel r) {
		this.start = start;
		this.end = end;
		this.title = r.getTitle();
		this.type = r.getType();
	}

	@Override
	public String toString() {
		return "ResRel [start=" + start + ", end=" + end + ", title=" + title + ", type=" + type + "]";
	}

}
