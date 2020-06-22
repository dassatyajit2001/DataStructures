package com.ds.graph.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphBFSIterative extends Graph {

	public void bfsTraversal(int begin, Map<Integer, List<Integer>> graph) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(begin);
		nodeVisitedCache.put(begin, true);
		System.out.print(begin);
		while (!queue.isEmpty()) {
			int node = queue.remove();
			List<Integer> edgeList = graph.get(node);
			if (edgeList != null) {
				for (int i = 0; i < edgeList.size(); i++) {
					if (!nodeVisitedCache.containsKey(edgeList.get(i))) {
						queue.add(edgeList.get(i));
						nodeVisitedCache.put(edgeList.get(i), true);
						System.out.print(", "+edgeList.get(i) );
					}
				}
			}
		}
	}
}
