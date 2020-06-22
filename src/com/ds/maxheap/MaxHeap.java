package com.ds.maxheap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

	public MaxHeap(int size) {
		heap = new ArrayList<>(size);
	}

	private List<Integer> heap;

	public void print() {
		heap.forEach(val->System.out.print(val+" "));
	}
	
	public void add(int value) {
		heap.add(value);
		
	}
	
	public void bubbleUp() {
		
		int lastIndex=heap.size()-1;
		int parentIndex=Math.floorDiv(lastIndex,2);
		while(heap.get(lastIndex)>=heap.get(parentIndex)) {
			
		}
//		for(int lastIndex=heap.size()-1, parentIndex=Math.floorDiv(lastIndex,2);
//		if(heap.get(endIndex))
	}

}
