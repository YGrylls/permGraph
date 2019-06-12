package com.warehouse.permGraph.common;

import com.warehouse.permGraph.model.RelationDirectIn;

public class ResRel {
	private Long start;
	private Long end;
	private String title;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ResRel(RelationDirectIn r) {
		this.start = r.getStart().getId();
		this.end = r.getEnd().getId();
		this.title = r.getTitle();
	}

	@Override
	public String toString() {
		return "ResRel [start=" + start + ", end=" + end + ", title=" + title + ", type=" + type + "]";
	}

}
