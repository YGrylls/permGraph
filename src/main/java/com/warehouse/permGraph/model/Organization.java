package com.warehouse.permGraph.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class Organization implements IMapper {
	@Id
	private Long id;

	@Property
	private String organizationName;

	@Property
	private String permID;

	@Property
	private String activityStatus;

//	@Relationship(direction = Relationship.UNDIRECTED, type = "DIRECT_IN")
//	private List<IRel> relDIRECT_IN;
//
//	@Relationship(direction = Relationship.UNDIRECTED, type = "OFFICE_IN")
//	private List<IRel> relOFFICE_IN;
//
//	@Relationship(direction = Relationship.UNDIRECTED, type = "HAS_ORGANIZATION_PRIMARY_QUOTE")
//	private List<IRel> relHAS_ORGANIZATION_PRIMARY_QUOTE;
//
//	@Relationship(direction = Relationship.UNDIRECTED, type = "HAS_PRIMARY_ECONOMIC_SECTOR")
//	private List<IRel> relHAS_PRIMARY_ECONOMIC_SECTOR;
//
//	@Relationship(direction = Relationship.UNDIRECTED, type = "HAS_PRIMARY_INDUSTRY_GROUP")
//	private List<IRel> relHAS_PRIMARY_INDUSTRY_GROUP;
//
//	@Relationship(direction = Relationship.UNDIRECTED, type = "HAS_PRIMARY_BUSINESS_SECTOR")
//	private List<IRel> relHAS_PRIMARY_BUSINESS_SECTOR;
//
//	@Relationship(direction = Relationship.UNDIRECTED, type = "HAS_PRIMARY_INSTRUMENT")
//	private List<IRel> relHAS_PRIMARY_INSTRUMENT;
//
//	@Relationship(direction = Relationship.UNDIRECTED, type = "IS_ISSUED_BY")
//	private List<IRel> relIS_ISSUED_BY;

//	public List<IRel> getRelDIRECT_IN() {
//		return relDIRECT_IN;
//	}
//
//	public void setRelDIRECT_IN(List<IRel> relDIRECT_IN) {
//		this.relDIRECT_IN = relDIRECT_IN;
//	}
//
//	public List<IRel> getRelOFFICE_IN() {
//		return relOFFICE_IN;
//	}
//
//	public void setRelOFFICE_IN(List<IRel> relOFFICE_IN) {
//		this.relOFFICE_IN = relOFFICE_IN;
//	}
//
//	public List<IRel> getRelHAS_ORGANIZATION_PRIMARY_QUOTE() {
//		return relHAS_ORGANIZATION_PRIMARY_QUOTE;
//	}
//
//	public void setRelHAS_ORGANIZATION_PRIMARY_QUOTE(List<IRel> relHAS_ORGANIZATION_PRIMARY_QUOTE) {
//		this.relHAS_ORGANIZATION_PRIMARY_QUOTE = relHAS_ORGANIZATION_PRIMARY_QUOTE;
//	}
//
//	public List<IRel> getRelHAS_PRIMARY_ECONOMIC_SECTOR() {
//		return relHAS_PRIMARY_ECONOMIC_SECTOR;
//	}
//
//	public void setRelHAS_PRIMARY_ECONOMIC_SECTOR(List<IRel> relHAS_PRIMARY_ECONOMIC_SECTOR) {
//		this.relHAS_PRIMARY_ECONOMIC_SECTOR = relHAS_PRIMARY_ECONOMIC_SECTOR;
//	}
//
//	public List<IRel> getRelHAS_PRIMARY_INDUSTRY_GROUP() {
//		return relHAS_PRIMARY_INDUSTRY_GROUP;
//	}
//
//	public void setRelHAS_PRIMARY_INDUSTRY_GROUP(List<IRel> relHAS_PRIMARY_INDUSTRY_GROUP) {
//		this.relHAS_PRIMARY_INDUSTRY_GROUP = relHAS_PRIMARY_INDUSTRY_GROUP;
//	}
//
//	public List<IRel> getRelHAS_PRIMARY_BUSINESS_SECTOR() {
//		return relHAS_PRIMARY_BUSINESS_SECTOR;
//	}
//
//	public void setRelHAS_PRIMARY_BUSINESS_SECTOR(List<IRel> relHAS_PRIMARY_BUSINESS_SECTOR) {
//		this.relHAS_PRIMARY_BUSINESS_SECTOR = relHAS_PRIMARY_BUSINESS_SECTOR;
//	}
//
//	public List<IRel> getRelHAS_PRIMARY_INSTRUMENT() {
//		return relHAS_PRIMARY_INSTRUMENT;
//	}
//
//	public void setRelHAS_PRIMARY_INSTRUMENT(List<IRel> relHAS_PRIMARY_INSTRUMENT) {
//		this.relHAS_PRIMARY_INSTRUMENT = relHAS_PRIMARY_INSTRUMENT;
//	}
//
//	public List<IRel> getRelIS_ISSUED_BY() {
//		return relIS_ISSUED_BY;
//	}
//
//	public void setRelIS_ISSUED_BY(List<IRel> relIS_ISSUED_BY) {
//		this.relIS_ISSUED_BY = relIS_ISSUED_BY;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getPermID() {
		return permID;
	}

	public void setPermID(String permID) {
		this.permID = permID;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	public Organization() {

	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", organizationName=" + organizationName + ", permID=" + permID
				+ ", activityStatus=" + activityStatus + "]";
	}

}
