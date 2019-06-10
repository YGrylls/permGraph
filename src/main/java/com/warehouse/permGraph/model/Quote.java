package com.warehouse.permGraph.model;

import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Quote implements IMapper {
	@Id
	private Long id;

	@Property
	private String permID;

	@Property
	private String quoteName;

	@Property
	private String exchangeCode;

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

	public String getQuoteName() {
		return quoteName;
	}

	public void setQuoteName(String quoteName) {
		this.quoteName = quoteName;
	}

	public String getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	public Quote() {

	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", permID=" + permID + ", quoteName=" + quoteName + ", exchangeCode=" + exchangeCode
				+ ", rel=" + rel + "]";
	}

}
