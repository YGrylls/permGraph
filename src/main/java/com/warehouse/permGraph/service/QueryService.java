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
		return ConvertUtils.convertToResult(query);
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
}
