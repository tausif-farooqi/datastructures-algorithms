package ds.tree;

public class BSTPrintAscendingDescending {

	public static void main(String[] args) {
		System.out.println("Descending");
		printDescending(buildTreeA());
		System.out.println("\nAscending");
		printAscending(buildTreeA());
	}
	
	private static void printDescending(Node node) {
		if (node == null) {
			return;
		}
		
		if (node.getRight() != null) {
			printDescending(node.getRight());
		}
		
		System.out.print(node.getValue() + " ");
		
		if (node.getLeft() != null) {
			printDescending(node.getLeft());
		}
		
	}
	
	private static void printAscending(Node node) {
		if (node == null) {
			return;
		}
				
		if (node.getLeft() != null) {
			printAscending(node.getLeft());
		}
		
		System.out.print(node.getValue() + " ");
		
		if (node.getRight() != null) {
			printAscending(node.getRight());
		}
	}
	
	private static Node buildTreeA() {
		Node tree = new Node(12);
		
		tree.addLeft(8);
		tree.addRight(14);
		
		tree.getLeft().addLeft(6);
		tree.getLeft().addRight(10);
		
		tree.getRight().addRight(16);
		
		return tree;
	}
}
