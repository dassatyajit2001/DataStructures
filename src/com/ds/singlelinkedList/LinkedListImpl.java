package com.ds.singlelinkedList;

public class LinkedListImpl {

	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.addNodeAtHead(20);
		linkedList.addNodeAtHead(19);
		linkedList.addNodeAtHead(18);
		linkedList.addNodeAtHead(17);
		linkedList.addNodeAtHead(16);
		linkedList.addNodeAtHead(15);
		linkedList.addNodeAtHead(14);
		linkedList.addNodeAtHead(13);
		linkedList.addNodeAtHead(12);
		linkedList.addNodeAtHead(11);
		linkedList.addNodeAtHead(10);
		linkedList.addNodeAtTail(9);
		linkedList.addNodeAtTail(8);
		linkedList.addNodeAtTail(7);
		linkedList.addNodeAtTail(6);
		linkedList.addNodeAtTail(5);
		linkedList.addNodeAtTail(4);
		linkedList.addNodeAtTail(3);
		linkedList.addNodeAtTail(2);
		linkedList.addNodeAtTail(1);
		linkedList.printList();
		
//		linkedList.deleteNodeFromTail();
//		linkedList.deleteNodeFromTail();
//		linkedList.printList();
//		linkedList.deleteNodeFromHead();
//		linkedList.deleteNodeFromHead();
//		linkedList.printList();

		// SingleLinkedNode node = linkedList.getHead();
//		linkedList.printListForwardRecurssion(node);
//		node=linkedList.getHead();
//		linkedList.printListBackwardRecurssion(node);
//		linkedList.printList();
//		node=linkedList.getHead();
//		linkedList.reverseLinkedListRecurssion(node);
//		linkedList.reverseLinkedList();
//		linkedList.printList();
		// linkedList.deleteNode();
		// linkedList.printList();
		// linkedList.deleteNode(2);
		// linkedList.printList();
		// linkedList.deleteNode(4);
		// linkedList.printList();
		// linkedList.deleteNode(10);
		// linkedList.printList();
		// linkedList.deleteNode(9);
		// linkedList.printList();
		// linkedList.deleteNode(7);
		// linkedList.printList();

	}

}

/**
 * Single LinkNode class
 * 
 * @author satyajitdas
 *
 */
class SingleLinkedNode {

	int data;
	SingleLinkedNode next;

	public SingleLinkedNode(int data) {
		this.data = data;
		next = null;
	}
}

/**
 * Implementation Of linkList
 * 
 * @author satyajitdas
 *
 */
class SingleLinkedList {

	protected SingleLinkedNode head;
	protected SingleLinkedNode tail;

	/**
	 * @return the tail
	 */
	public SingleLinkedNode getTail() {
		return tail;
	}

	/**
	 * @param tail the tail to set
	 */
	public void setTail(SingleLinkedNode tail) {
		this.tail = tail;
	}

	/**
	 * @return the head
	 */
	public SingleLinkedNode getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(SingleLinkedNode head) {
		this.head = head;
	}

	/**
	 * This method adds a node with the data given to the linked list and returns
	 * the head.
	 * 
	 * @param data
	 * @return
	 */
	public SingleLinkedNode addNodeAtHead(int data) {
		SingleLinkedNode newNode = new SingleLinkedNode(data);
		newNode.next = head;
		head = newNode;
		return head;
	}

	/**
	 * This method adds a node with the data given to the linked list and returns
	 * the head.
	 * 
	 * @param data
	 * @return
	 */
	public SingleLinkedNode addNodeAtTail(int data) {
		SingleLinkedNode newNode = new SingleLinkedNode(data);
		SingleLinkedNode tempNode = head;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}
		tempNode.next = newNode;
		return head;
	}

	/**
	 * This method deletes a node with the data given to the linked list the head.
	 * 
	 * @param data
	 * @return
	 */
	public SingleLinkedNode deleteNode(int data) {
		SingleLinkedNode current = head;
		SingleLinkedNode prev = null;

		while (current != null) {
			if (current.data == data) {
				if (current == head) {
					head = head.next;
					return head;

				}

				prev.next = current.next;
				current.next = null;
				current = null;
				return head;
			}
			prev = current;
			current = current.next;

		}
		return head;
	}

	/**
	 * Delete 1st node of the linkedList
	 * 
	 * @return
	 */
	public SingleLinkedNode deleteNodeFromHead() {
		SingleLinkedNode linkedNode = head;
		if (head == null) {
			return head;
		} else {
			head = head.next;
			linkedNode.next = null;
			linkedNode = null;
			return head;
		}
	}

	/**
	 * Delete last node of the linkedList
	 * 
	 * @return
	 */
	public SingleLinkedNode deleteNodeFromTail() {
		SingleLinkedNode tempNode = head;
		// if head is null or no data present
		if (tempNode == null)
			return head;
		// if there is only 1 node present
		else if (tempNode.next == null) {
			head = null;
			return head;
		}
		// for rest of the nodes iterate and unlink the last node
		while (tempNode.next.next != null) {
			tempNode = tempNode.next;
		}
		tempNode.next = null;
		return head;
	}

	/**
	 * prints all the node data in the linkedList
	 */
	public void printList() {
		if (head == null) {
			System.out.println("No Data Present");
		}
		SingleLinkedNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}	

}
