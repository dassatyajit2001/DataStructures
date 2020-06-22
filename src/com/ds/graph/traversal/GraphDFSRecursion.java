package com.ds.graph.traversal;

import java.util.List;
import java.util.Map;

public class GraphDFSRecursion extends Graph{

	public void dfsTraversal(int node, Map<Integer, List<Integer>> graph) {
		if (nodeVisitedCache.containsKey(node)) {
			return;
		}
		nodeVisitedCache.put(node, true);
		System.out.print(node+" ");
		List<Integer> edgeList = graph.get(node);
		if (edgeList != null) {
			for (int currNode = 0; currNode < edgeList.size(); currNode++) {
				dfsTraversal(edgeList.get(currNode), graph);
			}
		}
	}

}
