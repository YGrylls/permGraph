package com.warehouse.permGraph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.permGraph.common.ConvertUtils;
import com.warehouse.permGraph.common.Result;
import com.warehouse.permGraph.dao.QueryDao;
import com.warehouse.permGraph.model.IRel;

@Service
public class QueryService {

	@Autowired
	private QueryDao dao;

	public Result getEntity(Long dbid) {

		List<IRel> query = dao.getEntity(dbid);
		System.out.println(query);
		Result res = ConvertUtils.convertToResult(query);
		System.out.println(res);
		return res;
	}

	public Result getPath(Long dbid1, Long dbid2, Integer depth) {
		Result res = null;
		if (depth == 2) {
			res = ConvertUtils.convertToResult(dao.getPathTwo(dbid1, dbid2));
		} else if (depth == 3) {
			res = ConvertUtils.convertToResult(dao.getPathThree(dbid1, dbid2));
		}
		return res;
	}

	public Result getPerson(List<String> name) {
		Result res = null;
		res = ConvertUtils.convertNodes(dao.getPerson(name));
		return res;
	}

	public Result getOrganization(String name) {
		Result res = null;
		res = ConvertUtils.convertNodes(dao.getOrganization(name));
		return res;
	}

	public Result getAssetClass(String name) {
		Result res = null;
		res = ConvertUtils.convertNodes(dao.getAssetClass(name));
		return res;
	}

	public Result getInstrument(String name) {
		Result res = null;
		res = ConvertUtils.convertNodes(dao.getInstrument(name));
		return res;
	}

	public Result getBC(String name) {
		Result res = null;
		res = ConvertUtils.convertNodes(dao.getBC(name));
		return res;
	}

	public Result getQuote(String name) {
		Result res = null;
		res = ConvertUtils.convertNodes(dao.getQuote(name));
		return res;
	}
}
