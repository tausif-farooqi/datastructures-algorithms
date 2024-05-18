package ds.linkedlist;

public class RemoveKthElement {

	public static void main(String[] args) {
		ListNode node1 = new ListNode("A");
		ListNode node2 = new ListNode("B");
		ListNode node3 = new ListNode("C");
		
		node1.next = node2;
		node2.next = node3;
		
		removeKth(node1, 1);

	}

	private static void removeKth(ListNode listNode, int k) {
		listNode.printList();
		
		ListNode head = listNode;
		int steps = 0;
		ListNode firstIter = head;
		
		while (steps < k) {
			firstIter = firstIter.next;
			++steps;
		}
		
		ListNode secondIter = head;
		
		while (firstIter != null) {
			firstIter = firstIter.next;
			secondIter = secondIter.next;
		}
		
		secondIter.next = secondIter.next.next;
		
		listNode.printList();
	}
}
