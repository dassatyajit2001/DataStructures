package com.ds.tree.binarytree;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * generic Binary Search Tree implementation
 * 
 * @author satyajitdas
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {

	 BinaryNode root;
	private int size;

	/**
	 * returns the number of elements present;
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	public BinaryNode findLowestCommonAncestor(T value1, T value2) {
		// return findLowestCommonAncestor(value1, value2, root);
		return findLowestCommonAncestor(root, value1, value2);
	}

	private BinaryNode findLowestCommonAncestor(BinaryNode tempRoot, T value1, T value2) {
		while (tempRoot != null) {
			if (tempRoot.value.compareTo(value1) > 0 && tempRoot.value.compareTo(value2) > 0) {
				tempRoot = tempRoot.left;
			}
			if (tempRoot.value.compareTo(value1) < 0 && tempRoot.value.compareTo(value2) < 0) {
				tempRoot = tempRoot.right;
			} else
				break;
		}
		return tempRoot;
	}

	/**
	 * 
	 * @param value1
	 * @param value2
	 * @param tempRoot
	 * @return
	 */
	private BinaryNode findLowestCommonAncestor(T value1, T value2, BinaryNode tempRoot) {
		Set<BinaryNode> set = new HashSet<BinarySearchTree<T>.BinaryNode>();
		BinaryNode temp = new BinaryNode();
		if (contains(value1) && contains(value2)) {
			derivePath(value1, tempRoot, set, temp);
			derivePath(value2, tempRoot, set, temp);
		}
		return temp;
	}

	/**
	 * this method check whether a value is present in the BST
	 * 
	 * @param value
	 * @param tempRoot
	 * @return
	 */
	private BinaryNode derivePath(T value, BinaryNode tempRoot, Set<BinaryNode> nodePath, BinaryNode ancestor) {
		// if the value is present then return true
		if (tempRoot.value.compareTo(value) == 0) {
			return tempRoot;
		}
		// if value is either less than or greater than the root value
		// have recursive calls accordingly.
		else if (tempRoot.value.compareTo(value) > 0) {
			BinaryNode temp = derivePath(value, tempRoot.left, nodePath, ancestor);
			if (nodePath.add(temp) == false)
				ancestor.value = temp.value;
		} else if (tempRoot.value.compareTo(value) < 0) {
			BinaryNode temp = derivePath(value, tempRoot.right, nodePath, ancestor);
			if (nodePath.add(temp) == false) {
				ancestor.value = temp.value;
				System.out.println("Common Ancestor->" + ancestor);
			}
		}
		return tempRoot;
	}

	public int findMaxWidth() {
		return findMaxWidth(root);
	}

	/**
	 * Given a binary tree, write a function to get the maximum width of the given
	 * tree. The width of a tree is the maximum width among all levels. The binary
	 * tree has the same structure as a full binary tree, but some nodes are null.
	 * 
	 * The width of one level is defined as the length between the end-nodes (the
	 * leftmost and right most non-null nodes in the level, where the null nodes
	 * between the end-nodes are not counted into the length calculation.
	 * 
	 * @param tempRoot
	 * @return
	 */
	private int findMaxWidth(BinaryNode tempRoot) {
		if (tempRoot == null) {
			return 0;
		}
		int maxSize = 0;
		Stack<BinaryNode> stack1 = new Stack<>();
		Stack<BinaryNode> stack2 = new Stack<>();
		stack1.add(tempRoot);
		while (stack1.size() != 0 || stack2.size() != 0) {
			maxSize = Math.max(maxSize, Math.max(stack1.size(), stack2.size()));
			extractParentAndPopulateChildNodes(stack1, stack2);
			maxSize = Math.max(maxSize, Math.max(stack1.size(), stack2.size()));
			extractParentAndPopulateChildNodes(stack2, stack1);
		}
		return maxSize;

	}

	/**
	 * wrapper method to print the nodes from root to leaf
	 */
	public void printPathFromRootToLeaf() {
		printPathFromRootToLeaf(root, new Stack<>());
	}

	/**
	 * prints all the nodes from root to leaf. this is done using inorder traversal
	 * 
	 * @param tempRoot
	 * @param stack
	 */
	private void printPathFromRootToLeaf(BinaryNode tempRoot, Stack<T> stack) {
		if (tempRoot == null) {
			return;
		}
		stack.push(tempRoot.value);
		printPathFromRootToLeaf(tempRoot.left, stack);
		if (tempRoot.left == null && tempRoot.right == null) {
			System.out.println();
			System.out.print(stack);
		}
		printPathFromRootToLeaf(tempRoot.right, stack);
		stack.pop();
	}

	/**
	 * Util method to extract parent Nodes and populates the child nodes in another
	 * stack
	 * 
	 * @param stack1
	 * @param stack2
	 */
	private void extractParentAndPopulateChildNodes(Stack<BinaryNode> stack1, Stack<BinaryNode> stack2) {
		while (stack1.size() != 0) {
			BinaryNode temp = stack1.pop();
			if (temp.left != null) {
				stack2.add(temp.left);
			}
			if (temp.right != null) {
				stack2.add(temp.right);
			}
		}
	}

	/**
	 * wrapper method to add a value to the BST
	 * 
	 * @param value
	 * @return
	 */
	public boolean add(T value) {
		add(value, root);
		return true;
	}

	/**
	 * program to find if 2 trees are mirror or not
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	private boolean isMirror(BinaryNode node1, BinaryNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 != null && node2 != null && node1.value.compareTo(node2.value) == 0) {
			return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
		} else
			return false;
	}

	/**
	 * wrapper method to print the leaf nodes
	 */
	public void printLeafNodes() {
		printLeafNodes(root);
	}

	/**
	 * prints the leafs in the BST
	 * 
	 * @param tempRoot
	 */
	private void printLeafNodes(BinaryNode tempRoot) {
		if (tempRoot == null) {
			return;
		} else {
			if (tempRoot.left == null && tempRoot.right == null) {
				System.out.print(tempRoot.value + " ");
			} else {
				printLeafNodes(tempRoot.left);
				printLeafNodes(tempRoot.right);
			}
		}
	}

	/**
	 * wrapper method to find the height of the tree
	 * 
	 * @return
	 */
	public int getHeight() {
		return getHeight(root);
	}

	/**
	 * this method calculates the height of a Binary Tree
	 * 
	 * @param tempRoot
	 * @return
	 */
	private int getHeight(BinaryNode tempRoot) {
		int height = 0;
		// exit condition when tempRoot is null
		if (tempRoot == null) {
			return 0;
		}
		// have recursive call to left and right subtree and get the max of the height
		height += Math.max(getHeight(tempRoot.left) + 1, getHeight(tempRoot.right) + 1);
		return height;
	}

	/**
	 * This is a wrapper method to see whether a value is present in the BST
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(T value) {
		return contains(value, root);
	}

	/**
	 * wrapper method to print the values present in BST in preOrder
	 */
	public void printPreOrder() {
		printPreOrder(root);
	}

	/**
	 * prints values in pre order
	 * 
	 * @param tempRoot
	 */
	private void printPreOrder(BinaryNode tempRoot) {
		if (tempRoot == null) {
			return;
		}
		System.out.print(tempRoot.value + " ");
		printPreOrder(tempRoot.left);
		printPreOrder(tempRoot.right);
	}

	/**
	 * wrapper method to print the values present in BST in InOrder
	 */
	public void printInOrder() {
		printInOrder(root);
	}

	/**
	 * prints values in In order
	 * 
	 * @param tempRoot
	 */
	private void printInOrder(BinaryNode tempRoot) {
		if (tempRoot == null) {
			return;
		}
		printPreOrder(tempRoot.left);
		System.out.print(tempRoot.value + " ");
		printPreOrder(tempRoot.right);
	}

	/**
	 * wrapper method to print the values present in BST in PostOrder
	 */
	public void printPostOrder() {
		printPostOrder(root);
	}

	/**
	 * prints values in post order
	 * 
	 * @param tempRoot
	 */
	private void printPostOrder(BinaryNode tempRoot) {
		if (tempRoot == null) {
			return;
		}
		printPreOrder(tempRoot.left);
		printPreOrder(tempRoot.right);
		System.out.print(tempRoot.value + " ");
	}

	public void printLevelOrder() {
		printLevelOrdr();
	}

	/**
	 * This prints the nodes in values in level order present in the BST
	 * 
	 */
	private void printLevelOrdr() {
		Queue<BinaryNode> queue = new LinkedList<>();
		BinaryNode tempRoot = root;
		queue.add(tempRoot);
		while (queue.size() != 0) {
			BinaryNode temp = queue.poll();
			System.out.print(temp.value + " ");
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}

	/**
	 * this method check whether a value is present in the BST
	 * 
	 * @param value
	 * @param tempRoot
	 * @return
	 */
	private boolean contains(T value, BinaryNode tempRoot) {
		boolean isPresent = false;
		// if temproot is null it means the value is not found after the recursive calls
		// hence return false
		if (tempRoot == null) {
			return false;
		}
		// if the value is present then return true
		if (tempRoot.value.compareTo(value) == 0) {
			return true;
		}
		// if value is either less than or greater than the root value
		// have recursive calls accordingly.
		else if (tempRoot.value.compareTo(value) > 0) {
			isPresent = contains(value, tempRoot.left);
		} else if (tempRoot.value.compareTo(value) < 0) {
			isPresent = contains(value, tempRoot.right);
		}
		return isPresent;
	}

	/**
	 * method to add a node to a tree
	 * 
	 * @param value
	 * @return
	 */
	private BinaryNode add(T value, BinaryNode tempRoot) {
		// if root is null then its the 1st element being added
		if (root == null) {
			++size;
			root = new BinaryNode(value);
			return root;
		}
		// if the tempRoot is empty then create a node along with the value and return
		if (tempRoot == null) {
			++size;
			tempRoot = new BinaryNode(value);
		}
		// if root is not null then traverse to left or right
		else {
			tempRoot = compareNodes(value, tempRoot);
		}
		return tempRoot;
	}

	/**
	 * This method compares the nodes if the param value is less than the node value
	 * then traverse left else if value is greater than node value then traverse
	 * right
	 * 
	 * @param value
	 * @param tempRoot
	 * @return
	 */
	private BinaryNode compareNodes(T value, BinaryNode tempRoot) {
		// if value is less than the root value then traverse left
		if (tempRoot.value.compareTo(value) > 0) {
			tempRoot.left = add(value, tempRoot.left);
		}
		// if value is less than the root value then traverse right
		else if (tempRoot.value.compareTo(value) < 0) {
			tempRoot.right = add(value, tempRoot.right);
		}
		return tempRoot;
	}

	/**
	 * check if a given tree is symmetric
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(BinaryNode root) {

		return isSymmetric(root, root);
	}

	/**
	 * Given two binary trees original and cloned and given a reference to a node
	 * target in the original tree.
	 * 
	 * The cloned tree is a copy of the original tree.
	 * 
	 * Return a reference to the same node in the cloned tree.
	 * 
	 * Note that you are not allowed to change any of the two trees or the target
	 * node and the answer must be a reference to a node in the cloned tree.
	 * 
	 * Follow up: Solve the problem if repeated values on the tree are allowed.
	 */
	public final BinaryNode getTargetCopy(final BinaryNode original, final BinaryNode cloned, final BinaryNode target) {

		return getTargetFromClone(cloned, target);

	}

	public BinaryNode getTargetFromClone(BinaryNode cloned, BinaryNode target) {
		if (cloned == null) {
			return null;
		}
		if (cloned != null && cloned.value == target.value) {
			return cloned;
		}

		BinaryNode n1 = getTargetFromClone(cloned.left, target);
		if (n1 == null) {
			n1 = getTargetFromClone(cloned.right, target);
		}

		return n1;
	}

	/**
	 * check if a given tree is symmetric
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public boolean isSymmetric(BinaryNode node1, BinaryNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 != null && node2 != null && node1.value == node2.value) {
			return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
		}
		return false;

	}

	private boolean ifBST(BinaryNode node) {
		if (node == null) {
			return true;
		}

		if ((node.left != null && node.value.compareTo(node.left.value) > 0)
				|| (node.right != null && node.value.compareTo(node.right.value) < 0)) {
			return ifBST(node.left) && ifBST(node.right);
		}
		return false;

	}

	/**
	 * private class Binary Node which has a data and left and right Nodes as
	 * Attributes
	 * 
	 * @author satyajitdas
	 *
	 */
	 class BinaryNode {
		T value;

		public BinaryNode() {
			super();
		}

		BinaryNode left, right;

		public BinaryNode(T value) {
			super();
			this.value = value;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return "BinaryNode [value=" + value + "]";
		}
	}
}