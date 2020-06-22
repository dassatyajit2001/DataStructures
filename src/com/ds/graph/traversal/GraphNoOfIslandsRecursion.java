package com.ds.graph.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNoOfIslandsRecursion extends Graph {

	public void dfsTraversal(int node, Map<Integer, Boolean> nodeVisitedCache, Map<Integer, List<Integer>> graph) {
		if (nodeVisitedCache.containsKey(node))
			return;
		nodeVisitedCache.put(node, true);
		islands.get(islands.lastKey()).add(node);
		System.out.print(node + " ");
		List<Integer> edgeList = graph.get(node);
		if (edgeList != null) {
			for (int i = 0; i < edgeList.size(); i++) {
				dfsTraversal(edgeList.get(i), nodeVisitedCache, graph);
			}
		}
	}

	public int findNoOfIslands(Map<Integer, List<Integer>> graph) {
		Map<Integer, Boolean> nodeVisitedCache = new HashMap<>();
		int count = 0;
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			if (!nodeVisitedCache.containsKey(entry.getKey())) {
				islands.put(count++, new ArrayList<>());
				dfsTraversal(entry.getKey(), nodeVisitedCache, graph);
				System.out.println();
			}
		}
		return islands.size();
	}

}
