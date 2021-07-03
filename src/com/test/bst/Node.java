package com.test.bst;

public class Node {
	private int value;
	private Node left;
	private Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node addLeft(int value) {
		Node node = new Node(value);
		this.setLeft(node);
		return node;
	}
	
	public Node addRight(int value) {
		Node node = new Node(value);
		this.setRight(node);
		return node;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
}