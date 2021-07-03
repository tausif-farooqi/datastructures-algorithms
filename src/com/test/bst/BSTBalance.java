package com.test.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTBalance {

	public static void main(String[] args) {
		Node unbalancedTree = buildTree();
		System.out.println("Unbalanced Tree\n");
		BSTUtils.printTree(unbalancedTree);
		System.out.println("Balanced Tree\n");
		BSTUtils.printTree(balance(unbalancedTree));

	}
	
	public static Node balance(Node tree) {
		List<Integer> list = new ArrayList<Integer>();
		getAscendingOrder(tree, list);
		System.out.println("\nAscending order: " + list);
		int start = 0;
		int end = list.size() - 1;
		return createBalancedTree(list, start, end);
	}

	private static Node createBalancedTree(List<Integer> list, int start, int end) {
		if (start > end) {
			return null;
		}
		
		int midPoint = (start + end) / 2;
		Node node = new Node(list.get(midPoint));
		
		Node left = createBalancedTree(list, start, midPoint - 1);			
		node.setLeft(left);
		
		Node right = createBalancedTree(list, midPoint + 1, end);
		node.setRight(right);
		
		return node;
	}
	
	private static void getAscendingOrder(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}
				
		getAscendingOrder(node.getLeft(), list);
		
		list.add(node.getValue());
		
		getAscendingOrder(node.getRight(), list);
	}

	private static Node buildTree() {
		Node root = new Node(12);
		root.addLeft(8);
		root.addRight(14);
		root.getLeft().addLeft(6);
		root.getLeft().addRight(10);
		root.getRight().addRight(16);
		root.getRight().getRight().addRight(20);
	
//		Node root = new Node(4);
//		root.addLeft(3);
//		root.getLeft().addLeft(2);
//		root.getLeft().getLeft().addLeft(1);
		
//		Node root = new Node(4);
//		root.addLeft(3);
//		root.getLeft().addLeft(2);
//		root.getLeft().getLeft().addLeft(1);
//		root.addRight(5);
//		root.getRight().addRight(6);
//		root.getRight().getRight().addRight(7);
		
		return root;
	}
}
