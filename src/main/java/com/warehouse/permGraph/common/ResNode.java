package com.warehouse.permGraph.common;

import java.util.HashMap;
import java.util.Map;

import com.warehouse.permGraph.model.AssetClass;
import com.warehouse.permGraph.model.BusinessClassification;
import com.warehouse.permGraph.model.IMapper;
import com.warehouse.permGraph.model.Instrument;
import com.warehouse.permGraph.model.Organization;
import com.warehouse.permGraph.model.Person;
import com.warehouse.permGraph.model.Quote;

public class ResNode {

	private String name;
	private Long dbID;
	private String permID;
	private String label;
	private Map<String, String> property;

	public Long getDbID() {
		return dbID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDbID(Long dbID) {
		this.dbID = dbID;
	}

	public String getPermID() {
		return permID;
	}

	public void setPermID(String permID) {
		this.permID = permID;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Map<String, String> getProperty() {
		return property;
	}

	public void setProperty(Map<String, String> property) {
		this.property = property;
	}

	public static ResNode ctor(IMapper o) {
		try {
			if (o instanceof Organization) {
				return new ResNode((Organization) o);
			}
			if (o instanceof Person) {
				return new ResNode((Person) o);
			}
			if (o instanceof Instrument) {
				return new ResNode((Instrument) o);
			}
			if (o instanceof Quote) {
				return new ResNode((Quote) o);
			}
			if (o instanceof AssetClass) {
				return new ResNode((AssetClass) o);
			}
			if (o instanceof BusinessClassification) {
				return new ResNode((BusinessClassification) o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ResNode(Organization o) {
		this.property = new HashMap<String, String>();
		this.name = o.getName();
		this.dbID = o.getId();
		this.permID = o.getPermID();
		this.label = "Organization";
		this.property.put("organizationName", o.getOrganizationName());
		this.property.put("activityStatus", o.getActivityStatus());
	}

	public ResNode(Person o) {
		this.property = new HashMap<String, String>();
		this.name = o.getName();

		this.dbID = o.getId();
		this.permID = o.getPermID();
		this.label = "Person";
		this.property.put("givenName", o.getGivenName());
		this.property.put("preferredName", o.getPreferredName());
		this.property.put("familyName", o.getFamilyName());
	}

	public ResNode(Quote o) {
		this.property = new HashMap<String, String>();
		this.name = o.getName();

		this.dbID = o.getId();
		this.permID = o.getPermID();
		this.label = "Quote";
		this.property.put("quoteName", o.getQuoteName());
		this.property.put("exchangeCode", o.getExchangeCode());

	}

	public ResNode(Instrument o) {
		this.property = new HashMap<String, String>();
		this.name = o.getName();

		this.dbID = o.getId();
		this.permID = o.getPermID();
		this.label = "Instrument";
		this.property.put("instrumentName", o.getInstrumentName());
	}

	public ResNode(AssetClass o) {

		this.property = new HashMap<String, String>();
		this.name = o.getName();

		this.dbID = o.getId();
		this.permID = o.getPermID();
		this.label = "AssetClass";
		this.property.put("assetLabel", o.getAssetLabel());
		this.property.put("comment", o.getComment());
	}

	public ResNode(BusinessClassification o) {
		this.property = new HashMap<String, String>();
		this.name = o.getName();

		this.dbID = o.getId();
		this.permID = o.getPermID();
		this.label = "BusinessClassification";
		this.property.put("prefLabel", o.getPrefLabel());
		this.property.put("comment", o.getComment());
	}

	@Override
	public int hashCode() {
		return this.dbID.intValue();
	}

	@Override
	public boolean equals(Object o) {
		return this.dbID == ((ResNode) o).getDbID();
	}

	@Override
	public String toString() {
		return "ResNode [dbID=" + dbID + ", permID=" + permID + ", label=" + label + ", property=" + property + "]";
	}

}
