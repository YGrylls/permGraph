package com.warehouse.permGraph.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		String label = req.getLabel();
		List<String> names = null;
		if (req.getName() == null)
			return null;
		else {
			names = new ArrayList<String>(Arrays.asList(req.getName().split(" ")));
			System.out.println(names);
		}
		if (label == null) {
			return null;
		} else if ("Person".equals(label)) {
			return queryService.getPerson(names);

		} else if ("Organization".equals(label)) {
			return queryService.getOrganization(names.get(0));

		} else if ("AssetClass".equals(label)) {
			return queryService.getAssetClass(names.get(0));

		} else if ("Quote".equals(label)) {
			return queryService.getQuote(names.get(0));

		} else if ("Instrument".equals(label)) {
			return queryService.getInstrument(names.get(0));

		} else if ("BusinessClassification".equals(label)) {
			return queryService.getBC(names.get(0));
		} else
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
