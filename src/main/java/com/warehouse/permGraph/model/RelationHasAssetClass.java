package com.warehouse.permGraph.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("HAS_ASSET_CLASS")
public class RelationHasAssetClass implements IRel {
	@Id
	private Long id;

	@Property
	private String title = null;
	@StartNode
	private IMapper start;
	@EndNode
	private IMapper end;

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

	public RelationHasAssetClass() {

	}

	@Override
	public String toString() {
		return "RelationHasAssetClass [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end + "]";
	}

}
