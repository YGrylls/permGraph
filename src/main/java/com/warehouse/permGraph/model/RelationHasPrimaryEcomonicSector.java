package com.warehouse.permGraph.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("HAS_PRIMARY_ECONOMIC_SECTOR")
public class RelationHasPrimaryEcomonicSector implements IRel {
	@Id
	private Long id;

	@Property
	private String title = null;
	@StartNode
	private IMapper start;
	@EndNode
	private IMapper end;

	public String getType() {
		return "HAS_PRIMARY_ECONOMIC_SECTOR";
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

	public RelationHasPrimaryEcomonicSector() {

	}

	@Override
	public String toString() {
		return "RelationHasPrimaryEcomonicSector [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end
				+ "]";
	}

}
