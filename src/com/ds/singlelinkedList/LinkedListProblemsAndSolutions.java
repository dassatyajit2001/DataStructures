package com.ds.singlelinkedList;

public class LinkedListProblemsAndSolutions {

	public static void main(String[] args) {
		SingleLinkList linkedList = new SingleLinkList();
//		linkedList.addNodeAtHead(20);
//		linkedList.printList();
//		linkedList.findMiddleNode2();
//		linkedList.addNodeAtHead(19);
//		linkedList.printList();
//		linkedList.findMiddleNode2();
//		linkedList.addNodeAtHead(18);
//		linkedList.printList();
//		linkedList.findMiddleNode2();
//		linkedList.findMiddleNode2();
//		linkedList.addNodeAtHead(17);
//		linkedList.findMiddleNode2();
//		linkedList.addNodeAtHead(16);
//		linkedList.addNodeAtHead(15);
//		linkedList.addNodeAtHead(14);
//		linkedList.addNodeAtHead(13);
//		linkedList.addNodeAtHead(12);
//		linkedList.addNodeAtHead(11);
//		linkedList.addNodeAtHead(10);
//		linkedList.addNodeAtTail(9);
//		linkedList.addNodeAtTail(8);
//		linkedList.addNodeAtTail(7);
//		linkedList.addNodeAtTail(6);
//		linkedList.addNodeAtTail(5);
//		linkedList.addNodeAtTail(4);
//		linkedList.addNodeAtTail(3);
//		linkedList.addNodeAtTail(2);
//		linkedList.addNodeAtTail(1);
		for(int i=11;i>0;i--)
		{
			linkedList.addNodeAtHead(i);
		}
		linkedList.printList();
//		linkedList.size();
//		linkedList.findMiddleNode();
//		linkedList.findMiddleNode2();
		System.out.println();
//		linkedList.printFromHeadToTailWithRecurssion(linkedList.getHead());
//		linkedList.swapNodes();
//		linkedList.printList();
	//	linkedList.printFromTailToHeadWithRecurssion(linkedList.getHead());
		linkedList.reverseLinkedList();
		linkedList.printList();
	}
}

class SingleLinkList extends SingleLinkedList {
	// Question 1: Find the middle element of a link List
	/**
	 * Solution 1: Type 1 where we need to find the count and then divide by 2 to
	 * find the mid number of node
	 * 
	 * @return
	 */
	public SingleLinkedNode findMiddleNode() {
		SingleLinkedNode temp = head;
		int count = size() / 2 - 1;
		if (count == 0) {
			return null;
		}
		while (count-- != 0) {
			temp = temp.next;
		}
		System.out.println(temp.data);
		return temp;
	}

	// Question 1: Find the middle element of a link List
	/**
	 * Solution 2: Slow and fast pointers solution
	 * 
	 * @return
	 */
	public SingleLinkedNode findMiddleNode2() {
		SingleLinkedNode tempSlow = head;
		SingleLinkedNode tempFast = head;
		// when list is empty
		if (tempSlow == null) {
			System.out.println(tempSlow);
			return null;
		}
		// when list has 1 element
		if (tempSlow.next == null) {
			System.out.println(tempSlow.data);
			return tempSlow;
		}
		// when list has 2 elements
		if (tempSlow.next.next == null) {
			return tempSlow;
		}
		// for more than 2 elements
		while (tempFast.next != null && tempFast.next.next != null) {
			tempSlow = tempSlow.next;
			tempFast = tempFast.next.next;
		}
		System.out.println(tempSlow.data);
		return tempSlow;
	}

	// Question 2: Find the size of a linkList
	/**
	 * Solution:
	 * 
	 * @return
	 */
	public int size() {
		SingleLinkedNode temp = head;
		int count = 0;
		while (temp != null) {
			++count;
			temp = temp.next;
		}
		System.out.println("Count->" + count);
		return count;
	}

	// Question 3: Print the data in Nodes from Head to tail using recursion
	/**
	 * Solution: prints all the node data in forward manner using recursion
	 */
	public void printFromHeadToTailWithRecurssion(SingleLinkedNode temp) {
		if (temp == null) {
			return;
		}
		System.out.print(temp.data + " -> ");
		printFromHeadToTailWithRecurssion(temp.next);
	}

	// Question 4: Print the data in Nodes in reverse order using recursion
	/**
	 * Solution: prints all the node data in backward manner using recursion
	 */
	public void printFromTailToHeadWithRecurssion(SingleLinkedNode temp) {
		if (temp == null) {
			return;
		}
		printFromHeadToTailWithRecurssion(temp.next);
		System.out.print(temp.data + " -> ");
	}
	

	//Question 5: Reverse a single Link List non recursive way
	/**
	 * Solution
	 * Reverses a LinkedList iterative
	 * 
	 * @return
	 */
	public void reverseLinkedList() {
		SingleLinkedNode prev = null;
		SingleLinkedNode curr = head;
		SingleLinkedNode next = null;
		if (head != null) {
			next = head.next;
		}
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}
		head = prev;
	}

	//Question 6: Reverse a single Link List  recursive way
	/**
	 * Solution:
	 * Reverses a LinkedList using recursion
	 * 
	 * @return
	 */
	public void reverseLinkedListRecurssion(SingleLinkedNode curr) {
		if (curr.next != null) {
			reverseLinkedListRecurssion(curr.next);
			SingleLinkedNode next = curr.next;
			next.next = curr;
			curr.next = null;

		} else {
			head = curr;
			return;
		}
	}
	
	/**
	 * input a1->a1->a3->a4->a5->a6->a7->b1->b1->b3->b4->b5->b6->b7->null
	 * output a1->b1->a2->b2->a3->b3->a4->b4->a5->b5->a6->b6->a7->b7->null
	 */
	public void swapNodes()
	{
		SingleLinkedNode middle=findMiddleNode2();
		breakListInMiddle(middle);
		
		SingleLinkedNode middleT=middle.next;
		SingleLinkedNode tempHead=head;
		while(middle!=null && tempHead!=null) {
			SingleLinkedNode temp=tempHead.next;
			SingleLinkedNode tempMiddle=middle.next;
			tempHead.next=new SingleLinkedNode(middle.data);
			tempHead.next.next=temp;
			middle=middle.next;
			tempHead=temp;
		}
		
		
		
	}

	private void breakListInMiddle(SingleLinkedNode middle) {
		if(head==null) {
			return;
		}
		SingleLinkedNode temp2=head;
		while( temp2.next!=middle)
		{
			temp2=temp2.next;
		}
		temp2.next=null;
	}
}
