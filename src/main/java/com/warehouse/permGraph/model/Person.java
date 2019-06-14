package com.warehouse.permGraph.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class Person implements IMapper {

	@Id
	private Long id;

	@Property
	private String permID;

	@Property
	private String preferredName;

	@Property
	private String givenName;

	@Property
	private String familyName;

	public String getName() {
		StringBuilder temp = new StringBuilder();
		if (givenName != null && !"".equals(givenName)) {
			temp.append(givenName);
		}
		if (preferredName != null && !"".equals(preferredName)) {
			temp.append("(" + preferredName + ")");
		}
		if (familyName != null && "".equals(familyName)) {
			temp.append(" " + familyName);
		}
		return temp.toString();
	}

//	@Relationship(direction = Relationship.UNDIRECTED, type = "OFFICE_IN")
//	private List<IRel> relOFFICE_IN;
//
//	@Relationship(direction = Relationship.UNDIRECTED, type = "DIRECT_IN")
//	private List<IRel> relDIRECT_IN;
//
//	public List<IRel> getRelOFFICE_IN() {
//		return relOFFICE_IN;
//	}
//
//	public void setRelOFFICE_IN(List<IRel> relOFFICE_IN) {
//		this.relOFFICE_IN = relOFFICE_IN;
//	}
//
//	public List<IRel> getRelDIRECT_IN() {
//		return relDIRECT_IN;
//	}
//
//	public void setRelDIRECT_IN(List<IRel> relDIRECT_IN) {
//		this.relDIRECT_IN = relDIRECT_IN;
//	}

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

	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Person() {

	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", permID=" + permID + ", preferredName=" + preferredName + ", givenName="
				+ givenName + ", familyName=" + familyName + "]";
	}

}
