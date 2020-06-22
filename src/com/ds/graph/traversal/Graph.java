package com.ds.graph.traversal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graph {

	protected Map<Integer,List<Integer>> adjList=new HashMap<Integer, List<Integer>>();
	protected Map<Integer, Boolean> nodeVisitedCache=new HashMap<>();
	protected TreeMap<Integer, List<Integer>> islands = new TreeMap<>();
}
