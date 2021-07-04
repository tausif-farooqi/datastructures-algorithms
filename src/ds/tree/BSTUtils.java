package ds.tree;

public class BSTUtils {
	public static void printTree(Node node) {
		printTree("", node, false);
	}
	
    public static void printTree(String prefix, Node node, boolean isLeft) {
        if (node != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "--- ") + node.getValue());
            printTree(prefix + (isLeft ? "|   " : "    "), node.getLeft(), true);
            printTree(prefix + (isLeft ? "|   " : "    "), node.getRight(), false);
        }
    }
	
	private static Node buildTree() {
		Node tree = new Node(12);
		
		tree.addLeft(8);
		tree.addRight(14);
		
		tree.getLeft().addLeft(6);
		tree.getLeft().addRight(10);
		
		tree.getRight().addRight(16);
		
		tree.getRight().getRight().addRight(20);
		
		return tree;
	}

	public static void main(String[] args) {
		printTree(buildTree());
	}

}
