package com.warehouse.permGraph.common;

import java.util.HashMap;
import java.util.List;

import com.warehouse.permGraph.model.IMapper;
import com.warehouse.permGraph.model.IRel;

public class ConvertUtils {
	public static Result convertToResult(List<IRel> rel) {
		if (rel == null)
			return null;
		Result res = new Result();
		HashMap<ResNode, Integer> map = new HashMap<ResNode, Integer>();
		for (IRel r : rel) {
			if (r.getStart() != null && r.getEnd() != null) {
				// add nodes
				ResNode start = ResNode.ctor(r.getStart());
				ResNode end = ResNode.ctor(r.getEnd());

				res.getNodes().add(start);
				if (!map.containsKey(start)) {
					map.put(start, map.size());
				}

				res.getNodes().add(end);
				if (!map.containsKey(end)) {
					map.put(end, map.size());
				}
				// add rel
				res.getLinks().add(new ResRel(map.get(start), map.get(end), r));
			}
		}

		return res;

	}

	public static Result convertNodes(List<IMapper> nodes) {
		if (nodes == null) {
			return null;
		}
		Result res = new Result();
		for (IMapper n : nodes) {
			res.getNodes().add(ResNode.ctor(n));
		}
		return res;
	}

}
