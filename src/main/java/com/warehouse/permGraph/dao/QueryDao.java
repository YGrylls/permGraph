package com.warehouse.permGraph.dao;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.permGraph.model.IRel;

@Repository
public interface QueryDao extends Neo4jRepository<IRel, Long> {

	@Query("MATCH (o)-[r]-(n) WHERE id(o)={0} RETURN (o)-[r]-(n)")
	public List<IRel> getEntity(Long id);

	@Query("MATCH data=(o)-[r*1..2]-(n) WHERE id(o)={0} AND id(n)={1} RETURN data")
	public List<IRel> getPathTwo(Long id0, Long id1);

	@Query("MATCH data=(o)-[r*1..3]-(n) WHERE id(o)={0} AND id(n)={1} RETURN data")
	public List<IRel> getPathThree(Long id0, Long id1);

}
