package com.ds.tree.binarytree;

public class BinarySearchTreeApp {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst=new BinarySearchTree<>();
		bst.add(100);
		bst.add(50);
		bst.add(200);
		bst.add(40);
		bst.add(60);
		bst.add(150);
		bst.add(300);
		bst.add(400);
		bst.add(30);
		bst.add(45);
		bst.add(250);
		bst.add(61);
		bst.add(44);
		bst.add(47);
		bst.add(220);
		bst.add(270);
		bst.add(290);
		
		System.out.println("Size of the Tree->"+bst.size());
		System.out.println("Leaf Nodes->");
		bst.printLeafNodes();
		
		System.out.println();
		System.out.println();
		System.out.println("LevelOrder->");
		bst.printLevelOrder();
		
		System.out.println();
		System.out.println();
		System.out.println("PreOrder->");
		bst.printPreOrder();
		
		System.out.println();
		System.out.println();
		System.out.println("InOrder->");
		bst.printInOrder();
		
		System.out.println();
		System.out.println();
		System.out.println("PostOrder->");
		bst.printPostOrder();
		
		System.out.println("");
		System.out.println();
		System.out.println("Is 220 Present ?->"+ bst.contains(220));
		System.out.println();
		System.out.println("Height of the Tree->"+ bst.getHeight());
		System.out.println();
		System.out.println("Is 60 Present ?->"+ bst.contains(60));
		System.out.println("Is 150 Present ?->"+ bst.contains(150));
		System.out.println("lowest common ancestor->"+bst.findLowestCommonAncestor(150,400));
		System.out.println();
		System.out.println("Max width->"+bst.findMaxWidth());
		
		System.out.println();
		System.out.println();
		bst.printPathFromRootToLeaf();
		

	}

}
