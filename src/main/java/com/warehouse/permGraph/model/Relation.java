package com.warehouse.permGraph.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("DIRECT_IN")
public class Relation implements IRel {

	@Property
	private String title = null;
	@StartNode
	private IMapper start;
	@EndNode
	private IMapper end;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public IMapper getStart() {
		return start;
	}

	public void setStart(IMapper start) {
		this.start = start;
	}

	public IMapper getEnd() {
		return end;
	}

	public void setEnd(IMapper end) {
		this.end = end;
	}

	public Relation() {

	}

	@Override
	public String toString() {
		return "Relation [title=" + title + ", start=" + start + ", end=" + end + "]";
	}

}
