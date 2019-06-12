package com.warehouse.permGraph.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result {
	private Set<ResNode> nodes;
	private List<ResRel> links;

	public Set<ResNode> getNodes() {
		return nodes;
	}

	public void setNodes(Set<ResNode> nodes) {
		this.nodes = nodes;
	}

	public List<ResRel> getLinks() {
		return links;
	}

	public void setLinks(List<ResRel> links) {
		this.links = links;
	}

	public Result() {
		this.nodes = new HashSet<ResNode>();
		this.links = new ArrayList<ResRel>();
	}
}
