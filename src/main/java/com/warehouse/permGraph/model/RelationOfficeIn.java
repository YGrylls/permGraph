package com.warehouse.permGraph.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("OFFICE_IN")
public class RelationOfficeIn implements IRel {
	@Id
	private Long id;

	@Property
	private String title = null;
	@StartNode
	private IMapper start;
	@EndNode
	private IMapper end;

	public String getType() {
		return "OFFICE_IN";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public RelationOfficeIn() {

	}

	@Override
	public String toString() {
		return "RelationOfficeIn [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end + "]";
	}
}
