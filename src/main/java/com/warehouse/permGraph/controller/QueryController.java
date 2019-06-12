package com.warehouse.permGraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.permGraph.common.NameRequest;
import com.warehouse.permGraph.common.PathRequest;
import com.warehouse.permGraph.common.Result;
import com.warehouse.permGraph.service.QueryService;

@CrossOrigin
@RestController
public class QueryController {

	@Autowired
	private QueryService queryService;

	@PostMapping("/api/namequery")
	public Result nameQuery(@RequestBody NameRequest req) {
		return null;
	}

	@PostMapping("/api/entityquery/{dbid}")
	public Result entityQuery(@PathVariable("dbid") Long dbid) {
		Result res = queryService.getEntity(dbid);
		return res;
	}

	@PostMapping("/api/pathquery")
	public Result pathQuery(@RequestBody PathRequest req) {
		if (req.getDepth() >= 4 || req.getDepth() <= 1) {
			return null;
		}
		Result res = queryService.getPath(req.getDbID1(), req.getDbID2(), req.getDepth());
		return res;
	}

}
