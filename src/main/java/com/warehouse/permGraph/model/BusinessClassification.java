package com.warehouse.permGraph.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class BusinessClassification implements IMapper {
	@Id
	private Long id;

	@Property
	private String permID;

	@Property
	private String comment;

	@Property
	private String prefLabel;

	public String getName() {
		return prefLabel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermID() {
		return permID;
	}

	public void setPermID(String permID) {
		this.permID = permID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPrefLabel() {
		return prefLabel;
	}

	public void setPrefLabel(String prefLabel) {
		this.prefLabel = prefLabel;
	}

	public BusinessClassification() {

	}

}
