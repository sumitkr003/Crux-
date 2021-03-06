package HashMap2;

public class LinkedList<T> {

	private class Node {
		T data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public void handleat0(T value) {
		Node node = new Node();
		node.data = value;
		node.next = null;

		this.head = node;
		this.tail = node;
		this.size++;
	}

	public void addlast(T value) {
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

	public void addfirst(T value) {
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

	public void addatindex(T value, int idx) throws Exception {
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

	public T getfirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is Empty");
		} else {
			return this.head.data;
		}
	}

	public T getlast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is Empty");
		} else {
			return this.tail.data;
		}
	}

	public T getatindex(int idx) throws Exception {
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

	public T handleremove1() {
		T rv = this.head.data;

		this.head = null;
		this.tail = null;
		this.size = 0;

		return rv;
	}

	public T removefirst() throws Exception {
		T rv = null;
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

	public T removelast() throws Exception {
		T rv = null;
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

	public T removeat(int idx) throws Exception {
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
				T rv = m1.next.data;
				Node p1 = nodeatindex(idx + 1);

				m1.next = p1;
				this.size--;
				return rv;
			}
		}
     }
}