package com.warehouse.permGraph.common;

public class PathRequest {
	private Long dbID1;
	private Long dbID2;
	private Integer depth;

	public Long getDbID1() {
		return dbID1;
	}

	public void setDbID1(Long dbID1) {
		this.dbID1 = dbID1;
	}

	public Long getDbID2() {
		return dbID2;
	}

	public void setDbID2(Long dbID2) {
		this.dbID2 = dbID2;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public PathRequest() {

	}

}
