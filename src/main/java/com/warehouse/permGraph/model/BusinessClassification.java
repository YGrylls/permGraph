package com.warehouse.permGraph.model;

import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

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

	@Relationship(direction = Relationship.UNDIRECTED)
	private List<Relation> rel;

	public List<Relation> getRel() {
		return rel;
	}

	public void setRel(List<Relation> rel) {
		this.rel = rel;
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

	@Override
	public String toString() {
		return "BusinessClassification [id=" + id + ", permID=" + permID + ", comment=" + comment + ", prefLabel="
				+ prefLabel + ", rel=" + rel + "]";
	}

}
