package com.warehouse.permGraph.dao;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.permGraph.model.IMapper;
import com.warehouse.permGraph.model.Organization;

@Repository
public interface QueryDao extends Neo4jRepository<IMapper, Long> {

	@Query("MATCH (o:Organization{permID:{0}})-[r]-(n) RETURN (o)-[r]-(n)")
	public Organization getOrganization(String permid);

}
