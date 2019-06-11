package com.warehouse.permGraph.dao;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.warehouse.permGraph.model.IMapper;

@Component
public class QuerySessionDao {

	@Autowired
	private Session session;

	public IMapper getEntity(String permID, String label) {
		Map<String, String> para = new HashMap<String, String>();
		para.put("pid", permID);
		String query = "MATCH (o:" + label + " {permID:{pid}})-[r]-(n) RETURN (o)-[r]-(n)";
		IMapper res = session.queryForObject(IMapper.class, query, para);
		return res;
	}

}
