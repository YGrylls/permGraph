package com.warehouse.permGraph.dao;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.permGraph.model.Relation;

@Repository
public interface QueryDao extends Neo4jRepository<Relation, Long> {

	@Query("MATCH (o)-[r]-(n) WHERE id(o)={0} RETURN (o)-[r]-(n)")
	public List<Relation> getEntity(Long id);

	@Query("MATCH (o)-[r*1..2]-(n) WHERE id(o)={0} AND id(n)={1} RETURN (o)-[r*1..2]-(n)")
	public List<Relation> getPathTwo(Long id0, Long id1);

}
