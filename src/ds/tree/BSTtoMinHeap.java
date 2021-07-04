package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTtoMinHeap {
	private Queue<Integer> inOrder;
	private Node root;
	
	public BSTtoMinHeap() {
		inOrder = new LinkedList<Integer>();
		buildTree();
		populateInOrderList(root);
	}
	
	private void populateInOrderList(Node node) {
		if (node.getLeft() != null) {
			populateInOrderList(node.getLeft());
		}

		inOrder.add(node.getValue());
		
		if (node.getRight() != null) {
			populateInOrderList(node.getRight());
		}
	}
	
	public void convertMinHeap() {
		convertMinHeapPreOrder(root);
	}
	
	private void convertMinHeapPreOrder(Node node) {
		if (inOrder.isEmpty()) {
			return;
		}
		
		node.setValue(inOrder.poll());
		
		if (node.getLeft() != null) {
			convertMinHeapPreOrder(node.getLeft());
		}
		
		if (node.getRight() != null) {
			convertMinHeapPreOrder(node.getRight());
		}
	}
	
	private void buildTree() {
		root = new Node(4);
		root.addLeft(2);
		root.addRight(6);
		root.getLeft().addLeft(1);
		root.getLeft().addRight(3);
		root.getRight().addRight(7);
		root.getRight().addLeft(5);
	}
	
	public Node getRoot() {
		return this.root;
	}

	public static void main(String[] args) {
		BSTtoMinHeap bstToMinHeap = new BSTtoMinHeap();
		System.out.println("\nBST:");
		BSTUtils.printTree(bstToMinHeap.getRoot());
		System.out.println("\nIn-order list: " + bstToMinHeap.inOrder);
		bstToMinHeap.convertMinHeap();
		System.out.println("\nMin Heap:");
		BSTUtils.printTree(bstToMinHeap.getRoot());
	}

}
