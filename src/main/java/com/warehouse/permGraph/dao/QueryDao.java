package com.warehouse.permGraph.dao;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.permGraph.model.IMapper;
import com.warehouse.permGraph.model.IRel;

@Repository
public interface QueryDao extends Neo4jRepository<IRel, Long> {

	@Query("MATCH (o)-[r]-(n) WHERE id(o)={0} RETURN (o)-[r]-(n)")
	public List<IRel> getEntity(Long id);

	@Query("MATCH data=(o)-[r*1..2]-(n) WHERE id(o)={0} AND id(n)={1} RETURN data")
	public List<IRel> getPathTwo(Long id0, Long id1);

	@Query("MATCH data=(o)-[r*1..3]-(n) WHERE id(o)={0} AND id(n)={1} RETURN data")
	public List<IRel> getPathThree(Long id0, Long id1);

	@Query("MATCH (n:Organization)-[r]-() WHERE n.organizationName CONTAINS {0} RETURN n, count(r) AS c ORDER BY c DESC LIMIT 20")
	public List<IMapper> getOrganization(String name);

//
	@Query("MATCH (n:Person)-[r]-() WHERE n.givenName IN {0} AND n.familyName IN {0} OR n.preferredName IN {0} RETURN n, count(r) AS c ORDER BY c DESC LIMIT 20")
	public List<IMapper> getPerson(List<String> name);

//
	@Query("MATCH (n:Instrument) WHERE n.instrumentName CONTAINS {0} RETURN n LIMIT 20")
	public List<IMapper> getInstrument(String name);

	@Query("MATCH (n:AssetClass) WHERE n.label CONTAINS {0} RETURN n LIMIT 20")
	public List<IMapper> getAssetClass(String name);

	@Query("MATCH (n:BusinessClassification) WHERE n.prefLabel CONTAINS {0} RETURN n LIMIT 20")
	public List<IMapper> getBC(String name);

	@Query("MATCH (n:Quote) WHERE n.quoteName CONTAINS {0} RETURN n LIMIT 20")
	public List<IMapper> getQuote(String name);

}
