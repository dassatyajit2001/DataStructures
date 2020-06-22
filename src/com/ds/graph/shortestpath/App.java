package com.ds.graph.shortestpath;

import java.util.List;

import com.ds.graph.Graph;

public class App {

	public Graph buildGraph(Graph graph) {

		graph.adjList.put(0, List.of(1));
		graph.adjList.put(1, List.of(2, 4));
		graph.adjList.put(2, List.of(3, 5, 4));
		graph.adjList.put(3, null);
		graph.adjList.put(4, List.of(1, 2, 5, 6));
		graph.adjList.put(5, List.of(2, 4, 8));
		graph.adjList.put(6, List.of(4, 7));
		graph.adjList.put(7, List.of(6, 8));
		graph.adjList.put(8, List.of(5, 7));
		graph.adjList.put(9, null);
		
		graph.adjList.put(10, List.of(11));
		return graph;

	}

	public static void main(String[] args) {
		App graphDfs = new App();
		
		System.out.println("-------BFS Shortest Path------");
		GraphShortestPathUsingBFS bfsShort = new GraphShortestPathUsingBFS();
		graphDfs.buildGraph(bfsShort);
		System.out.println(bfsShort.findShortestPath(0, 8));
	}
	
}
