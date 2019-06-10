package com.warehouse.permGraph.model;

import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Instrument implements IMapper {
	@Id
	private Long id;

	@Property
	private String permID;

	@Property
	private String instrumentName;

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

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public Instrument() {

	}

	@Override
	public String toString() {
		return "Instrument [id=" + id + ", permID=" + permID + ", instrumentName=" + instrumentName + ", rel=" + rel
				+ "]";
	}

}
