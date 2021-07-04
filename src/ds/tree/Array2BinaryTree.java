package ds.tree;

public class Array2BinaryTree {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		Node tree = insert(array, 0);
		BSTUtils.printTree(tree);
	}
	
	private static Node insert(int[] array, int index) {
		if (index >= array.length) {
			return null;
		}
		
		Node node = new Node(array[index]);
		node.setLeft(insert(array, (index * 2) + 1));
		node.setRight(insert(array, (index * 2) + 2));
		
		return node;
	}
}
