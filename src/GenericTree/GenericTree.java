package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		root = takeinput(null, -1, scn);
	}

	private Node takeinput(Node parent, int childidx, Scanner scn) {
		// promt
		if (parent == null) {
			System.out.println("Enter parent data");
		} else {
			System.out.println("enter" + parent.data + " " + childidx + "th data");
		}

		// collect data
		int data = scn.nextInt();

		// create new child,store data and increase size
		Node child = new Node();
		child.data = data;
		this.size++;

		// collect number of child's children
		System.out.println("enter" + child.data + " total childrens");

		int gc = scn.nextInt();

		// add children and their child and also connect it to tree
		for (int i = 0; i < gc; i++) {
			Node childgc = takeinput(child, i, scn);
			child.children.add(childgc);
		}

		// return child
		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	public void display() {
		this.display(root);
	}

	private void display(Node node) {
		String str = node.data + "==>";
		for (Node child : node.children) {
			str += child.data + ",";
		}

		System.out.println(str + ".");

		for (Node child : node.children) {
			display(child);
		}
	}

	public int size2() {
		return this.size2(root);
	}

	private int size2(Node node) {
		int sz = 0;

		for (Node child : node.children) {
			int rv = size2(child);
			sz += rv;
		}

		sz++;
		return sz;
	}

	public int max() {
		return this.max(root);
	}

	private int max(Node node) {
		int max = Integer.MIN_VALUE;
		for (Node child : node.children) {
			int cmax = max(child);
			if (cmax > max) {
				max = cmax;
			}
		}

		if (node.data > max) {
			max = node.data;
		}

		return max;
	}

	public int height() {
		return this.height(root);
	}

	private int height(Node node) {
		int h = -1;
		for (Node child : node.children) {
			int s = height(child);
			if (s > h) {
				h = s;
			}
		}

		return h + 1;
	}

	public boolean find(int data) {
		return this.find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

		for (Node child : node.children) {
			boolean rv = find(child, data);
			if (rv == true) {
				return true;
			}
		}

		return false;
	}

	public void mirror() {
		this.mirror(root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}

		for (int i = 0; i < node.children.size() / 2; i++) {
			Node left = node.children.get(i);
			Node right = node.children.get(node.children.size() - 1 - i);

			node.children.set(i, right);
			node.children.set(node.children.size() - 1 - i, left);
		}
	}

	public void preorder() {
		this.preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {
		System.out.print(node.data + ",");
		for (Node child : node.children) {
			preorder(child);
		}
	}

	public void postorder() {
		this.postorder(root);
		System.out.println();
	}

	private void postorder(Node node) {
		for (Node child : node.children) {
			postorder(child);
		}
		System.out.print(node.data + ",");
	}

	public void levelorder() {
		LinkedList<Node> q = new LinkedList<>();
		q.addLast(root);

		while (q.size() != 0) {
			Node node = q.removeFirst();
			System.out.print(node.data + ",");
			for (Node child : node.children) {
				q.addLast(child);
			}
		}

		System.out.println(".");
	}

	public void levelorderlw() {
		LinkedList<Node> q = new LinkedList<>();
		LinkedList<Node> h = new LinkedList<>();
		q.addLast(root);

		while (q.size() != 0) {
			Node node = q.removeFirst();
			System.out.print(node.data + " ");
			for (Node child : node.children) {
				h.addLast(child);
			}
			if (q.size() == 0) {
				System.out.println();
				q = h;
				h = new LinkedList<>();
			}

		}
	}

	public void multisolver(int data) {
		HeapMover mover = new HeapMover();
		this.multisolver(root, mover, data, 0);
		System.out.println("max = " + mover.max);
		System.out.println("min = " + mover.min);
		System.out.println("found = " + mover.found);
		System.out.println("size = " + mover.size);
		System.out.println("height = " + mover.height);

	}

	private void multisolver(Node node, HeapMover mover, int data, int depth) {
		mover.size++;
		if (node.data > mover.max) {
			mover.max = node.data;
		}
		if (node.data < mover.min) {
			mover.min = node.data;
		}
		if (depth > mover.height) {
			mover.height = depth;
		}
		if (node.data == data) {
			mover.found = true;
		}

		for (Node child : node.children) {
			multisolver(child, mover, data, depth + 1);
		}

	}

	public void ques(int data) {
		HeapMover mover = new HeapMover();
		ques(root, mover, data);

		if (mover.pred == 0) {
			System.out.println("null");
		} else {
			System.out.println("pred = " + mover.pred);
		}

		if (mover.succ == 0) {
			System.out.println("null");
		} else {
			System.out.println("succ = " + mover.succ);
		}

		System.out.println("just greater" + mover.jg);
	}

	private void ques(Node node, HeapMover mover, int data) {
		if (node.data > data && node.data < mover.jg) {
			mover.jg = node.data;
			mover.found = true;
		}
		if (mover.suc == true) {
			mover.succ = node.data;
			mover.suc = false;
		}
		if (node.data == data) {
			mover.pre = true;
			mover.suc = true;
		}
		if (mover.pre == false) {
			mover.pred = node.data;
		}

		for (Node child : node.children) {
			ques(child, mover, data);
		}
	}

	private class HeapMover {
		int size;
		int height;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean found;
		int pred;
		int succ;
		int jg = Integer.MAX_VALUE;
		boolean pre;
		boolean suc;
		Node head;
		Node tail;
		
		Node prev = null;
		Node curr = null;
	}

	public int kthsmallest(int k) {
		int data = Integer.MIN_VALUE;
		for (int i = 0; i <= k; i++) {
			HeapMover mover = new HeapMover();
			kthsmallest(root, mover, data);
			data = mover.jg;
		}

		return data;
	}

	private void kthsmallest(Node node, HeapMover mover, int data) {
		if (node.data > data) {
			if (mover.jg == 0) {
				mover.jg = node.data;
			} else {
				if (node.data < mover.jg) {
					mover.jg = node.data;
				}
			}

		}

		for (Node child : node.children) {
			kthsmallest(child, mover, data);
		}
	}

	public void removeleaf(){
		removeleaf(root,null);
	}
	
	private void removeleaf(Node node,Node prev){
		if(node.children.size() == 0){
			 prev.children.remove(node);
		}
		
		for(int j = node.children.size()-1;j>=0;j--){
			Node child = node.children.get(j);
			removeleaf(child,node);
		}
	}

	public void linearize(){
		HeapMover mover = new HeapMover();
		linearize(root);
	}
	
	private Node gettail(Node node){
		if(node.children.size()==0){
			return node;
		}
		Node rv = new Node();
		for(Node child:node.children){
			rv = gettail(child);
		}
		return rv;
		
//		Node rv = node;
//		for(Node child:node.children){
//			rv = child;
//		}
//		return rv;
	}
	
	private void linearize(Node node){
		for(Node child:node.children){
			linearize(child);
		}
		
		for(int i = node.children.size()-1;i>0;i--){
			Node temp = node.children.remove(i);
			Node temp1 = node.children.get(i-1);
			Node tail = gettail(temp1);
			tail.children.add(temp);
		}
	}
	
	public void linearize2(){
		HeapMover mover = new HeapMover();
		this.linearize2(root,mover);
	}
	
	private void linearize2(Node node,HeapMover mover){
		
		if(mover.head == null){
			mover.head = mover.tail = new Node();
			mover.head.data = node.data;
			mover.head = node;
			mover.tail = node;
		}else{
			Node n = new Node();
				n.data = node.data;
				
				mover.tail.children.add(n);
				mover.tail = n;
		}
		
		for(Node child:node.children){
			linearize2(child,mover);
		}
	}
	
	public void flatten(){
		HeapMover mover = new HeapMover();
		this.flatten(root,mover);
	}
	
	private void flatten(Node node,HeapMover mover){
		
		if(mover.head == null){
			mover.head = mover.tail = new Node();
			mover.head.data = node.data;
			mover.head = node;
			mover.tail = node;
		}else{
			Node n = new Node();
			n.data = node.data;
				
			mover.tail.children.add(n);
		}
		
		for(Node child:node.children){
			linearize2(child,mover);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
