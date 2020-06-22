package com.ds.graph.traversal;

import java.util.List;

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

		System.out.println("-------DFS-Recursion------");
		GraphDFSRecursion graphRecur = new GraphDFSRecursion();
		graphDfs.buildGraph(graphRecur);
		graphRecur.dfsTraversal(1, graphRecur.adjList);
		System.out.println();

		System.out.println("-------DFS- Iterative------");
		GraphDFSIterative graphIter = new GraphDFSIterative();
		graphDfs.buildGraph(graphIter);
		graphIter.dfsTraversal(1, graphIter.adjList);
		System.out.println();

		System.out.println("-------No Of Islands or Connected Components------");
		GraphNoOfIslandsRecursion graphIsland = new GraphNoOfIslandsRecursion();
		graphDfs.buildGraph(graphIsland);
		System.out.println("No Of Islands-> " + graphIsland.findNoOfIslands(graphIsland.adjList));

		System.out.println("-------BFS------");
		GraphBFSIterative bfs = new GraphBFSIterative();
		graphDfs.buildGraph(bfs);
		bfs.bfsTraversal(1, bfs.adjList);
		
	}
	
}
