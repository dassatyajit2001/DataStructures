package com.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeImplementation {

	public static void main(String[] args) {
		BinaryTreeImpl binaryTreeImpl=new BinaryTreeImpl();
		binaryTreeImpl.add(100);
		binaryTreeImpl.add(50);
		binaryTreeImpl.add(150);
		binaryTreeImpl.add(25);
		binaryTreeImpl.add(55);
		binaryTreeImpl.add(20);
		binaryTreeImpl.add(10);
		binaryTreeImpl.add(24);
		binaryTreeImpl.add(28);
		binaryTreeImpl.add(110);
		binaryTreeImpl.add(250);
		binaryTreeImpl.add(500);
		binaryTreeImpl.add(220);
		binaryTreeImpl.add(109);
		binaryTreeImpl.add(140);
		binaryTreeImpl.add(26);
		binaryTreeImpl.add(30);
	
//		System.out.println(binaryTreeImpl.search(109));
//		System.out.println(binaryTreeImpl.search(220));
//		System.out.println(binaryTreeImpl.search(251));
//		System.out.println(binaryTreeImpl.findMin());
//		System.out.println(binaryTreeImpl.findMax());
//		System.out.println(binaryTreeImpl.findHeightOfTheBSTree());
//		binaryTreeImpl.printDataBreadthFirstLToR();
//		System.out.println();
//		binaryTreeImpl.printDataBreadthFirstRtoL();
//		System.out.println();
//		binaryTreeImpl.printDataBreadthFirstSpiral();
//		System.out.println();
//		binaryTreeImpl.preOrderTraversal(binaryTreeImpl.root);
//		System.out.println();
//		binaryTreeImpl.inOrderTraversal(binaryTreeImpl.root);
//		System.out.println();
//		binaryTreeImpl.postOrderTraversal(binaryTreeImpl.root);
//		
//		binaryTreeImpl.printLeftViewOfATree();
//		
		System.out.println(binaryTreeImpl.countNoOfLeafNodes());
		System.out.println(binaryTreeImpl.countNoOfNodes());
		
		System.out.println(binaryTreeImpl.countNoOfNonLeafNodes());
		
		
	}
}



class BinaryTreeImpl {

	BinaryTreeNode root;

	/**
	 * Add the data to a binary tree
	 * 
	 * @param data
	 * @param node
	 * @return
	 */
	private BinaryTreeNode addNode(int data, BinaryTreeNode node) {
		if (root == null) {
			root = new BinaryTreeNode(data);
			return root;
		}
		if (node == null) {
			node = new BinaryTreeNode(data);
		}

		else if (node.data >= data) {
			node.left = addNode(data, node.left);
		} else if (node.data < data) {
			node.right = addNode(data, node.right);
		}
		return node;

	}

	/**
	 * Searches whether an element is present in BST
	 * 
	 * @param data
	 * @param node
	 * @return
	 */
	private boolean search(int data, BinaryTreeNode node) {

		if (node == null) {
			return false;
		}

		else if (node.data == data) {
			return true;
		} else if (node.data > data) {
			return search(data, node.left);
		} else {
			return search(data, node.right);
		}

	}

	/**
	 * client method to call the search function
	 * 
	 * @param data
	 * @return
	 */
	public boolean search(int data) {
		BinaryTreeNode node = root;
		return search(data, node);
	}

	/**
	 * Find the min element of a BinarySearch tree
	 * 
	 * @param node
	 * @return
	 */
	private BinaryTreeNode findMin(BinaryTreeNode node) {
		while (node.left != null) {
			return findMin(node.left);
		}
		return node;

	}

	/**
	 * Client method to find the min element the binary tree
	 * 
	 * @return
	 */
	public int findMin() {
		BinaryTreeNode node = root;
		BinaryTreeNode temp = findMin(node);
		if (temp != null) {
			return temp.data;
		} else
			return Integer.MIN_VALUE;
	}

	/**
	 * Find the max element of a BinarySearch tree
	 * 
	 * @param node
	 * @return
	 */
	private BinaryTreeNode findMax(BinaryTreeNode node) {
		while (node.right != null) {
			return findMax(node.right);
		}
		return node;

	}

	/**
	 * Client method to find the max element the binary tree
	 * 
	 * @return
	 */
	public int findMax() {
		BinaryTreeNode node = root;
		BinaryTreeNode temp = findMax(node);
		if (temp != null) {
			return temp.data;
		} else
			return Integer.MAX_VALUE;
	}

	/**
	 * client method to add a data to BST
	 * 
	 * @param data
	 */
	public void add(int data) {
		BinaryTreeNode node = root;
		node = (addNode(data, node));
	}

	/**
	 * method to find the height of a Tree
	 * 
	 * @param node
	 * @return
	 */
	private int findHeightOfTheBSTree(BinaryTreeNode node) {
		if (node == null) {
			return -1;
		}

		return Math.max(findHeightOfTheBSTree(node.left), findHeightOfTheBSTree(node.right)) + 1;
	}

	/**
	 * client method to find the height of a Tree
	 * 
	 * @param node
	 * @return
	 */
	public int findHeightOfTheBSTree() {
		BinaryTreeNode node = root;
		return (findHeightOfTheBSTree(node));
	}

	/**
	 * Breadth First Search from left to right
	 */
	public void printDataBreadthFirstLToR() {
		BinaryTreeNode node = root;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			queue.add(node);
		}
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	/**
	 * Breadth First Search from right to left
	 */
	public void printDataBreadthFirstRtoL() {
		BinaryTreeNode node = root;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			queue.add(node);
		}
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			System.out.print(temp.data + " ");
			if (temp.right != null) {
				queue.add(temp.right);
			}
			if (temp.left != null) {
				queue.add(temp.left);
			}
		}
	}

	public void printDataBreadthFirstSpiral() {
		BinaryTreeNode node = root;

		Stack<BinaryTreeNode> stack2 = new Stack<>();
		Stack<BinaryTreeNode> stack = new Stack<>();
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			stack2.add(node);
		}
		while (!stack2.isEmpty() || !stack.isEmpty()) {
			BinaryTreeNode temp = null;

			while (!stack2.isEmpty()) {
				temp = stack2.pop();
				System.out.print(temp.data + " ");

				if (temp.right != null) {
					stack.push(temp.right);
				}
				if (temp.left != null) {
					stack.push(temp.left);
				}

			}
			while (!stack.isEmpty()) {

				temp = stack.pop();
				System.out.print(temp.data + " ");

				if (temp.left != null) {
					stack2.push(temp.left);
				}
				if (temp.right != null) {
					stack2.push(temp.right);
				}
			}

		}
	}

	/**
	 * Pre order Traversal
	 * 
	 * @param node
	 */
	public void preOrderTraversal(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);

	}

	/**
	 * In order Traversal
	 * 
	 * @param node
	 */
	public void inOrderTraversal(BinaryTreeNode node) {
		if (node == null) {
			return;
		}

		preOrderTraversal(node.left);
		System.out.print(node.data + " ");
		preOrderTraversal(node.right);

	}

	/**
	 * post order Traversal
	 * 
	 * @param node
	 */
	public void postOrderTraversal(BinaryTreeNode node) {
		if (node == null) {
			return;
		}

		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
		System.out.print(node.data + " ");

	}
	
	
	/**
	 * This method prints the left view of a tree
	 */
	public void printLeftViewOfATree()
	{
		System.out.println();
		BinaryTreeNode node=root;
		int count=-1;	
		Queue<BinaryTreeNode> queue1 = new LinkedList<>();
		Queue<BinaryTreeNode> queue2= new LinkedList<>();
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			queue1.add(node);
		}
		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			BinaryTreeNode temp = null;
			count=1;
			while(!queue1.isEmpty())
			{
				temp=queue1.remove();
				if(count==1)
				{
					System.out.print(temp.data+" ");
					count--;
				}
				if(temp.left!=null)
				{
					queue2.add(temp.left);
				}
				if(temp.right!=null)
				{
					queue2.add(temp.right);
				}
				
			}
			count=1;
			while(!queue2.isEmpty())
			{
				temp=queue2.remove();
				if(count==1)
				{
					System.out.print(temp.data+" ");
					count--;
				}
				if(temp.left!=null)
				{
					queue1.add(temp.left);
				}
				if(temp.right!=null)
				{
					queue1.add(temp.right);
				}
			}
		}
	}
	
	
	/**
	 * method to count all the leaf nodes
	 * @param node
	 * @return
	 */
	private int countNoOfLeafNodes(BinaryTreeNode node)
	{
		if(node!=null && node.left==null && node.right==null)
		{
			return 1;
		}
		int leftcount=0;
		int rightcount=0;
		if(node.left!=null)
		leftcount=countNoOfLeafNodes(node.left);
		if(node.right!=null)
		rightcount=countNoOfLeafNodes(node.right);
		return leftcount+rightcount;
	}
	
	
	
	/**
	 * client method to count all the leaf nodes
	 * @param node
	 * @return
	 */
	public int countNoOfLeafNodes()
	{
		System.out.println();
		return countNoOfLeafNodes(root);
	}
	
	
	public boolean isleafNode(BinaryTreeNode node)
	{
		if(node==null)
		{
			return true;
		}
		else if(node!=null && node.right==null && node.left==null)
		{
			return true;
		}
		else return false;
		
	}
	/**
	 * method to count all the leaf nodes
	 * @param node
	 * @return
	 */
	private int countNoOfNonLeafNodes(BinaryTreeNode node)
	{
		if(node == null || (node.left==null && node.right==null)) //to work for empty tree
			return 0;
		return 1 + countNoOfNonLeafNodes(node.left) + countNoOfNonLeafNodes(node.right);
	}
	
	
	/**
	 * method to count all the leaf nodes
	 * @param node
	 * @return
	 */
	private int countNoOfNodes(BinaryTreeNode node)
	{
		if (node == null) {
			return 0;
		}
		return (1+(countNoOfNodes(node.left) + countNoOfNodes(node.right)));
		
	}
	
	public int countNoOfNodes()
	{
		return countNoOfNodes(root);
	}
	
	/**
	 * client method to count all the leaf nodes
	 * @param node
	 * @return
	 */
	public int countNoOfNonLeafNodes()
	{
		return  countNoOfNonLeafNodes(root);
	}
}

class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode(int data) {
		super();
		this.data = data;
	}
	
	
	
}

