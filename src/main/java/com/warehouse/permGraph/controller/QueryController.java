package com.warehouse.permGraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.permGraph.model.Result;
import com.warehouse.permGraph.service.QueryService;

@CrossOrigin
@RestController
public class QueryController {

	@Autowired
	private QueryService queryService;

	@PostMapping("/api/namequery")
	public Result nameQuery() {
		return null;
	}

	@PostMapping("/api/entityquery")
	public Result entityQuery() {
		return null;
	}

}
