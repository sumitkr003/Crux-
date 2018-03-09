package july18;

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public void handleat0(int value) {
		Node node = new Node();
		node.data = value;
		node.next = null;

		this.head = node;
		this.tail = node;
		this.size++;
	}

	public void addlast(int value) {
		if (this.size == 0) {
			this.handleat0(value);
		} else {
			Node node = new Node();
			node.data = value;
			node.next = null;

			this.tail.next = node;
			this.tail = node;
			this.size++;
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	public void display() {
		Node temp = this.head;

		System.out.println("---------------------------------------------------------------------------");

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();
		System.out.println("---------------------------------------------------------------------------");
	}

	public void addfirst(int value) {
		if (this.size == 0) {
			this.handleat0(value);
		} else {
			Node node = new Node();
			node.data = value;
			node.next = this.head;

			this.head = node;
			this.size++;
		}
	}

	public void addatindex(int value, int idx) throws Exception {
		if (this.size == 0) {
			this.handleat0(value);
		} else if (idx < 0 || idx > this.size) {
			throw new Exception("out of bound");
		} else if (idx == this.size) {
			this.addlast(value);
		} else {
			Node temp = new Node();
			temp.data = value;

			Node prev = nodeatindex(idx - 1);
			Node nex = nodeatindex(idx);

			temp.next = nex;
			prev.next = temp;
			this.size++;
		}

	}

	public int getfirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is Empty");
		} else {
			return this.head.data;
		}
	}

	public int getlast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is Empty");
		} else {
			return this.tail.data;
		}
	}

	public int getatindex(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("out of bound");
		} else {
			int sidx = 0;
			Node temp = this.head;
			while (sidx != idx) {
				temp = temp.next;
				sidx++;
			}

			return temp.data;
		}
	}

	public Node nodeatindex(int idx) throws Exception {
		if (idx < 0 || idx >= this.size) {
			throw new Exception("out of bound");
		} else {
			int sidx = 0;
			Node temp = this.head;
			while (sidx != idx) {
				temp = temp.next;
				sidx++;
			}

			return temp;
		}
	}

	public int handleremove1() {
		int rv = this.head.data;

		this.head = null;
		this.tail = null;
		this.size = 0;

		return rv;
	}

	public int removefirst() throws Exception {
		int rv = 0;
		if (this.size == 0) {
			throw new Exception("Linked List is Empty");
		}
		if (this.size == 1) {
			this.handleremove1();
		} else {
			rv = this.head.data;
			this.head = this.head.next;
			this.size--;
		}
		return rv;
	}

	public int removelast() throws Exception {
		int rv = 0;
		if (this.size == 0) {
			throw new Exception("Linked List is Empty");
		} else if (this.size == 1) {
			this.handleremove1();
		} else {
			rv = this.tail.data;
			this.tail = nodeatindex(size - 2);
			this.tail.next = null;
			this.size--;
		}
		return rv;
	}

	public int removeat(int idx) throws Exception {
		if (size == 0) {
			throw new Exception("Linked List is Empty");
		}
		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("out of bound");
		} else {
			if (idx == 0) {
				return removefirst();
			} else if (idx == this.size - 1) {
				return removelast();
			} else {
				Node m1 = nodeatindex(idx - 1);
				int rv = m1.next.data;
				Node p1 = nodeatindex(idx + 1);

				m1.next = p1;
				this.size--;
				return rv;
			}
		}
	}

	public void reversedataiterative() throws Exception {
		int sidx = 0, lidx = size - 1;
		while (sidx <= lidx) {
			Node start = nodeatindex(sidx);
			Node end = nodeatindex(lidx);

			int temp = start.data;
			start.data = end.data;
			end.data = temp;

			sidx++;
			lidx--;
		}

	}

	public void reversepointeriterative() throws Exception {

		Node prev = this.head;
		Node curr = this.head.next;
		while (curr != null) {
			Node temp = prev;
			prev = curr;
			curr = curr.next;
			prev.next = temp;
		}
		this.tail = this.head.next;
		this.head.next = null;
		this.head = prev;

	}

	public void reversepointerrecursive() {
		this.reversepointerrecursive(this.head, this.head.next);
	}

	private void reversepointerrecursive(Node prev, Node curr) {
		if (curr == null) {
			Node temp = this.head;
			this.head = prev;
			this.tail = temp;
			this.tail.next = null;
			return;
		}
		Node temp = curr.next;
		curr.next = prev;
		reversepointerrecursive(curr, temp);

	}

	public void displayreverse() {
		this.displayreverse(this.head);
	}

	private void displayreverse(Node start) {
		if (start == null) {
			return;
		}
		int data = start.data;
		displayreverse(start.next);
		System.out.print(data + " ");
	}

	private class HeapMover {
		Node node;
	}

	public void datarecursive() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		this.datarecursive(left, this.head, 0);
	}

	private void datarecursive(HeapMover left, Node right, float floor) {
		if (right == null) {
			return;
		}
		datarecursive(left, right.next, floor + 1);

		if (floor >= this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
		}

		left.node = left.node.next;

	}

	public boolean ispalindrome() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		return this.ispalindrome(left, this.head);
	}

	private boolean ispalindrome(HeapMover left, Node right) {
		if (right == null) {
			return true;
		}

		boolean b = ispalindrome(left, right.next);
		int temp = left.node.data;
		int temp1 = right.data;
		left.node = left.node.next;
		if (temp != temp1) {
			b = false;
		}
		return b;
	}

	public void fold() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		this.fold(left, this.head, 0);
	}

	private void fold(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}

		fold(left, right.next, floor + 1);
		if (floor > this.size / 2) {
			Node temp = left.node.next;
			left.node.next = right;
			right.next = temp;
			left.node = temp;
		} else if (floor == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	// public int kfromlast(int k){
	// HeapMover last = new HeapMover();
	// last.node.data = k;
	// last.node.next = null;
	// return kfromlast(last,this.head);
	// }
	//
	private int kfromlast(HeapMover last, Node left) {
		if (left == null) {
			return 0;
		}
		int rv = kfromlast(last, left.next);
		last.node.data = last.node.data - 1;
		if (last.node.data == 0) {
			rv = left.data;
		}
		return rv;
	}

	public int mid() {
		Node fast = this.head;
		Node slow = this.head;

		while (true) {
			if (fast.next == null || fast.next.next == null) {
				break;
			}

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public int kthfromlast(int k) {
		Node slow = this.head;
		Node fast = this.head;
		for (int i = 0; i < k; k++) {
			fast = fast.next;
		}
		while (fast == null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow.data;
	}

	public void removeduplicate() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		removeduplicates(left, this.head.next);
	}

	private void removeduplicates(HeapMover left, Node right) {
		if (right == null) {
			return;
		}
		if (left.node.data == right.data) {
			left.node = left.node.next;
			right = right.next;
		}
		left.node = left.node.next;
		removeduplicates(left, right.next);
	}

	public Node midnode() {
		Node fast = this.head;
		Node slow = this.head;

		while (true) {
			if (fast.next == null || fast.next.next == null) {
				break;
			}

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public LinkedList mergesortedlinkedlist(LinkedList other) {
		LinkedList merged = new LinkedList();
		Node fh = this.head;
		Node oh = other.head;

		while (fh != null && oh != null) {
			if (fh.data < oh.data) {
				merged.addlast(fh.data);
				fh = fh.next;
			} else {
				merged.addlast(oh.data);
				oh = oh.next;
			}
		}

		while (fh != null) {
			merged.addlast(fh.data);
			fh = fh.next;
		}

		while (oh != null) {
			merged.addlast(oh.data);
			oh = oh.next;
		}

		return merged;
	}

	public LinkedList mergesort() {
		if (this.size == 1) {
			return this;
		}
		Node mid = midnode();
		LinkedList fhalf = new LinkedList();
		LinkedList shalf = new LinkedList();
		Node midn = mid.next;

		fhalf.head = this.head;
		fhalf.tail = mid;
		fhalf.tail.next = null;
		fhalf.size = (this.size + 1) / 2;

		shalf.head = midn;
		shalf.tail = this.tail;
		shalf.size = this.size / 2;

		fhalf = fhalf.mergesort();
		shalf = shalf.mergesort();

		LinkedList sorted = fhalf.mergesortedlinkedlist(shalf);

		return sorted;
	}
	
	public void kreverse(int k) throws Exception {
		LinkedList prev = null, curr = new LinkedList();
		
		while(!this.isempty()){
			for(int i = 0; i < k; i++){
				curr.addfirst(this.removefirst());
			}
			
			if(prev == null){
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}
			
			curr = new LinkedList();
		}
		
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}

}
