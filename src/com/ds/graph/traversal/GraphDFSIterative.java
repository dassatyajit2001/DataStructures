package com.ds.graph.traversal;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphDFSIterative extends Graph{

	public void dfsTraversal(int begin,  Map<Integer, List<Integer>> graph) {
		
		Stack<Integer> stack=new Stack<>();
		stack.add(begin);
		
		while(!stack.isEmpty()) {
			int currNode=stack.pop();
			if(nodeVisitedCache.containsKey(currNode))
				continue;
			nodeVisitedCache.put(currNode, true);			
			System.out.print(currNode+" ");
			List<Integer> edgeList = graph.get(currNode);
						if (edgeList != null) {
				for (int i = 0; i < edgeList.size(); i++) {
					if(!nodeVisitedCache.containsKey(edgeList.get(i)))
						stack.push(edgeList.get(i));
				}
			}
		}
	}



}
