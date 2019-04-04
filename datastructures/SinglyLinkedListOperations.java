package datastructures;
//Java Codes - Singly Linked List: Insertion, display, count, reverse, palindrome
// SinglyLinkedList.java
class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;
		this.next = null;
	}
}

class SinglyLinkedList {
	Node head;

	SinglyLinkedList() {
		head = null;
	}

	public void insertAtEnd(int value) {
		Node newNode = new Node(value);
		this.head = insertAtEnd(newNode, head, value);
	}

	public Node insertAtEnd(Node newNode, Node head, int value) {
		if (head == null) {
			head = newNode;
		} else if (head.next == null) {
			head.next = newNode;
		} else {
			insertAtEnd(newNode, head.next, value);
		}
		return head;
	}

	public void insertAtBeginning(int value) {
		Node newNode = new Node(value);
		this.head = insertAtBeginning(newNode, head, value);
	}

	public Node insertAtBeginning(Node newNode, Node head, int value) {
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		return head;
	}

	public Node reverseList(int startIndex) {
		Node temp = head;
		Node mid = null;
		for (int i = 0; i < startIndex; i++) {
			mid = temp;
			temp = temp.next;
		}
		Node curr = null;
		Node next = null;
		while (temp != null) {
			next = temp.next;
			temp.next = curr;
			curr = temp;
			temp = next;
		}
		mid.next = curr;
		return head;

	}

	public void reverseList() {
		Node temp = head;
		Node next = null;
		Node curr = null;
		while (temp != null) {
			next = temp.next;
			temp.next = curr;
			curr = temp;
			temp = next;
		}
		head = curr;
	}

	public Boolean isPalindrome() {
		int length = length();
		int mid = length / 2;
		head = reverseList(mid);
		Node temp = head;
		Node firstHalfStart = head;
		Node secondHalfStart = null;
		for (int i = 0; i <= mid; i++) {
			secondHalfStart = temp;
			temp = temp.next;
		}
		for (int i = 0; i < mid; i++) {
			if (firstHalfStart.value == secondHalfStart.value) {
				firstHalfStart = firstHalfStart.next;
				secondHalfStart = secondHalfStart.next;
				continue;
			} else {
				return false;
			}

		}
		return true;
	}

	public int length() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public void display() {
		display(head);
	}

	public void display(Node temp) {
		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}
}

class Main {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.insertAtBeginning(1);
		sll.insertAtBeginning(2);
		sll.insertAtBeginning(3);
		sll.insertAtBeginning(1);
		// sll.reverseList();
		System.out.println(sll.isPalindrome());
	}
}


