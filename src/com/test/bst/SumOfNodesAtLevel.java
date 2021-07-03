package com.test.bst;

import java.util.ArrayList;
import java.util.List;

public class SumOfNodesAtLevel {
	public static void main(String[] args) {
		Node tree = buildTree();
		BSTUtils.printTree(tree);
		List<Integer> list = new ArrayList<>();
		traverse(tree, list, 1, 4);
		System.out.println(list);
	}
	
	private static void traverse(Node node, List<Integer> list, int level, int targetLevel) {
		if (node == null) {
			return;
		}
		
		if (level == targetLevel) {
			list.add(node.getValue());
		} else if (level > targetLevel) {
			return;
		} 
		
		traverse(node.getLeft(), list, level + 1, targetLevel);
		traverse(node.getRight(), list, level + 1, targetLevel);
	}
	
	private static Node buildTree() {
		Node root = new Node(12);
		root.addLeft(8);
		root.addRight(14);
		root.getLeft().addLeft(6);
		root.getLeft().addRight(10);
		root.getRight().addRight(16);
		root.getRight().getRight().addRight(20);
		
		return root;
	}
}
