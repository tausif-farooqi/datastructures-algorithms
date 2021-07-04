package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
	private static List<Integer> visited = new ArrayList<>();
	
	public static void main(String[] args) {
		Node tree = buildTree();
		BSTUtils.printTree(tree);
		
		System.out.println("\nIn order");
		System.out.println("--------");
		inorder(tree);
		
		System.out.println("\nPre order");
		System.out.println("--------");
		preorder(tree);
		
		System.out.println("\nPost order");
		System.out.println("--------");
		postOrder(tree);
		
		System.out.println("\nBreadth first");
		System.out.println("--------");
		breadthFirst(tree);
	}
	
	private static void inorder(Node node) {
		if (node == null) {
			return;
		}
		
		inorder(node.getLeft());
		System.out.println(node.getValue());
		inorder(node.getRight());
	}
	
	private static void preorder(Node node) {
		if (node == null) {
			return;
		}
		
		System.out.println(node.getValue());
		preorder(node.getLeft());
		preorder(node.getRight());
	}
	
	private static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.println(node.getValue());
	}
	
	private static void breadthFirst(Node node) {
		if (node == null) {
			return;
		}
		
		int value = node.getValue();
		if (!visited.contains(value)) {
			System.out.println(value);
			visited.add(value);
		}
		
		if (node.getLeft() != null) {
			int leftValue = node.getLeft().getValue();
			System.out.println(leftValue);
			visited.add(leftValue);
		}
		
		if (node.getRight() != null) {
			int rightValue = node.getRight().getValue();
			System.out.println(rightValue);
			visited.add(rightValue);
		}
		
		breadthFirst(node.getLeft());
		breadthFirst(node.getRight());
	}
	
	private static Node buildTree() {
		Node tree = new Node(1);
		
		tree.addLeft(2);
		tree.addRight(3);
		
		tree.getLeft().addLeft(4);
		tree.getLeft().addRight(5);
		
		return tree;
	}
}
