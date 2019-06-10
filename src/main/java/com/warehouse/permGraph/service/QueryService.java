package com.warehouse.permGraph.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.permGraph.dao.QueryDao;
import com.warehouse.permGraph.model.Organization;

@Service
public class QueryService {

	@Autowired
	private QueryDao dao;

	public void getOrganization(String permid) {
		Organization res = dao.getOrganization(permid);

	}
}
