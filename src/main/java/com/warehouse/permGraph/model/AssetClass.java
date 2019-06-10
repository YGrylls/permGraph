package com.warehouse.permGraph.model;

import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class AssetClass implements IMapper {
	@Id
	private Long id;

	@Property
	private String permID;

	@Property
	private String comment;

	@Property("label")
	private String assetLabel;

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

	public String getAssetLabel() {
		return assetLabel;
	}

	public void setAssetLabel(String assetLabel) {
		this.assetLabel = assetLabel;
	}

	public AssetClass() {

	}

	@Override
	public String toString() {
		return "AssetClass [id=" + id + ", permID=" + permID + ", comment=" + comment + ", assetLabel=" + assetLabel
				+ ", rel=" + rel + "]";
	}

}
