package com.warehouse.permGraph;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.warehouse.permGraph.dao.QueryDao;
import com.warehouse.permGraph.model.IRel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermGraphApplicationTests {

	@Autowired
	private QueryDao dao;

	// 4295865078 tencent 2042357
	// 5000066483 alibaba 2072872

	@Test
	public void testReturn() {
		List<IRel> res = dao.getPathTwo((long) 2042357, (long) 2072872);
		System.out.println("-----------------\n" + res);
	}

}
