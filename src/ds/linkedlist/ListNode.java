package ds.linkedlist;

public class ListNode {
	public String value;
	public ListNode next;
	
	public ListNode(String val) {
		this.value = val;
	}
	
	public void printList() {
		StringBuilder builder = new StringBuilder(this.value);
		
		ListNode node = this.next;
		while (node != null) {
			builder.append(" -> ").append(node.value);
			node = node.next;
		}
		
		System.out.println(builder.toString());
	}
}
