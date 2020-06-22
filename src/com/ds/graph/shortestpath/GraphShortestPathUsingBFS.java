package com.ds.graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ds.graph.Graph;

public class GraphShortestPathUsingBFS extends Graph {

		
	public List<Integer> findShortestPath(int start,int end) {
		int noOfNodes=adjList.size();
		int[] prev=new int[noOfNodes];
		Arrays.fill(prev,-100);
		bfsTraversal(start,prev);
		for(int i=0;i<prev.length;++i) {
			System.out.println(i+" "+prev[i]);
		}
		List<Integer> path=buildPath(start,end,prev);
		return path;
	}
	
	public List<Integer> buildPath(int start,int end,int[] prev){
		List<Integer> path=new ArrayList<>();
		for(int i=end;i!=-100;i=prev[i]) {
			path.add(i);
		}
		if(path.size()>0 && path.get(path.size()-1)!=start)
			return null;
		return path;
	}
	public void bfsTraversal(int begin,int[] prev) {
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(begin);
			nodeVisitedCache.put(begin, true);
			while (!queue.isEmpty()) {
				int node = queue.remove();
				List<Integer> edgeList = adjList.get(node);
				if (edgeList != null) {
					for (int i = 0; i < edgeList.size(); i++) {
						if (!nodeVisitedCache.containsKey(edgeList.get(i))) {
							queue.add(edgeList.get(i));
							nodeVisitedCache.put(edgeList.get(i), true);
							prev[edgeList.get(i)]= node;
						}
					}
				}
			}
		}
}
