package com.warehouse.permGraph.dao;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.permGraph.model.IMapper;

@Repository
public interface QueryDao extends Neo4jRepository<IMapper, Long> {

}
