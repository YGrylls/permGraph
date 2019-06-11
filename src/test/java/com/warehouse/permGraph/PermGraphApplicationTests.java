package com.warehouse.permGraph;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.warehouse.permGraph.dao.QueryDao;
import com.warehouse.permGraph.model.Relation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermGraphApplicationTests {

	@Autowired
	private QueryDao dao;

	@Test
	public void testReturn() {
		List<Relation> res = dao.getEntity((long) 2072872);
		System.out.println("-----------------\n" + res);
	}

}
