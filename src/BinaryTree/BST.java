package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BST {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;
	int size;

	// public BST(int[] post, int[] in) {
	// root = constructor(post, in, 0, post.length - 1, 0, in.length - 1);
	// }

	public BST(int[] sa) {
		root = SAconstructor(sa, 0, sa.length - 1);
	}

	private Node constructor(int[] post, int[] in, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei) {
			return null;
		}

		Node node = new Node();
		node.data = post[pei];
		this.size++;

		int idx = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}

		int clse = idx - isi;

		node.left = constructor(post, in, psi, psi + clse - 1, isi, idx - 1);
		node.right = constructor(post, in, psi + clse, pei - 1, idx + 1, iei);

		return node;

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		if (node.left != null) {
			str += node.left.data + "";
		} else {
			str += ".";
		}

		str += "=>" + node.data + "<=";

		if (node.right != null) {
			str += node.right.data + "";
		} else {
			str += ".";
		}

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int left = size2(node.left);
		int right = size2(node.right);

		return left + right + 1;
	}

	public int height() {
		return height(root) - 1;
	}

	private int height(Node node) {
		int h = -1;

		int left = 0, right = 0;
		if (node.left != null) {
			left = height(node.left);
		}

		if (node.right != null) {
			right = height(node.right);
		}

		if (left > right) {
			h = left;
		} else {
			h = right;
		}

		return h + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		} else {
			return max(node.right);
		}
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node.left == null) {
			return node.data;
		} else {
			return min(node.left);
		}
	}

	public boolean isfound(int data) {
		return isfound(root, data);
	}

	private boolean isfound(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (data > node.data) {
			return isfound(node.right, data);
		} else if (data < node.data) {
			return isfound(node.left, data);
		} else {
			return true;
		}

	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int left = diameter(node.left);
		int right = diameter(node.right);
		int lefth = height(node.left);
		int righth = height(node.right);

		return Math.max(left + right + 2, Math.max(lefth, righth));

	}

	public int diameter2() {
		return diameter2(root).diameter;

	}

	public class diapair {
		int diameter;
		int height;
	}

	private diapair diameter2(Node node) {
		if (node == null) {
			diapair bp = new diapair();
			bp.height = -1;
			bp.diameter = 0;
			return bp;
		}

		diapair mp = new diapair();

		diapair left = diameter2(node.left);
		diapair right = diameter2(node.right);

		mp.diameter = (Math.max(left.height + right.height + 2, (Math.max(left.diameter, right.diameter))));
		mp.height = Math.max(left.height, right.height) + 1;

		return mp;
	}

	public boolean isbalanced() {
		return isbalanced(root).bal;
	}

	private isbalance isbalanced(Node node) {
		if (node == null) {
			isbalance bc = new isbalance();
			bc.bal = true;
			bc.height = -1;
			return bc;
		}
		isbalance mp = new isbalance();

		isbalance left = isbalanced(node.left);
		isbalance right = isbalanced(node.right);

		if (left.bal == false || right.bal == false) {
			return mp;
		}

		int dif = left.height - right.height;

		if (dif <= 1 && dif >= -1) {
			mp.bal = true;
		}

		mp.height = Math.max(left.height, right.height) + 1;

		if (mp.bal == false) {
			return mp;
		}

		return mp;
	}

	private class isbalance {
		boolean bal = true;
		int height;
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	public void preorderiterative() {
		LinkedList<Transversalpair> stack = new LinkedList<>();

		Transversalpair rp = new Transversalpair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {

			Transversalpair temp = stack.getFirst();

			if (temp.selfdone == false) {
				System.out.print(temp.node.data + " ");
				temp.selfdone = true;
			} else if (temp.leftdone == false) {
				if (temp.node.left == null) {
					temp.leftdone = true;
				} else {
					temp.leftdone = true;
					Transversalpair tempnew = new Transversalpair();
					tempnew.node = temp.node.left;
					stack.addFirst(tempnew);
				}

			} else if (temp.rightdone == false) {
				if (temp.node.right == null) {
					temp.rightdone = true;
				} else {
					temp.rightdone = true;
					Transversalpair tempnew = new Transversalpair();
					tempnew.node = temp.node.right;
					stack.addFirst(tempnew);
				}
			} else {
				stack.removeFirst();
			}
		}
	}

	public void postorderI() {
		LinkedList<Transversalpair> stack = new LinkedList<>();

		Transversalpair rp = new Transversalpair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {

			Transversalpair temp = stack.getFirst();

			if (temp.leftdone == false) {
				if (temp.node.left == null) {
					temp.leftdone = true;
				} else {
					temp.leftdone = true;
					Transversalpair tempnew = new Transversalpair();
					tempnew.node = temp.node.left;
					stack.addFirst(tempnew);
				}

			} else if (temp.rightdone == false) {
				if (temp.node.right == null) {
					temp.rightdone = true;
				} else {
					temp.rightdone = true;
					Transversalpair tempnew = new Transversalpair();
					tempnew.node = temp.node.right;
					stack.addFirst(tempnew);
				}
			} else if (temp.selfdone == false) {
				System.out.print(temp.node.data + " ");
				temp.selfdone = true;
			} else {
				stack.removeFirst();
			}
		}
	}

	public void inorderI() {
		LinkedList<Transversalpair> stack = new LinkedList<>();

		Transversalpair rp = new Transversalpair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {

			Transversalpair temp = stack.getFirst();

			if (temp.leftdone == false) {
				if (temp.node.left == null) {
					temp.leftdone = true;
				} else {
					temp.leftdone = true;
					Transversalpair tempnew = new Transversalpair();
					tempnew.node = temp.node.left;
					stack.addFirst(tempnew);
				}

			} else if (temp.selfdone == false) {
				System.out.print(temp.node.data + " ");
				temp.selfdone = true;
			} else if (temp.rightdone == false) {
				if (temp.node.right == null) {
					temp.rightdone = true;
				} else {
					temp.rightdone = true;
					Transversalpair tempnew = new Transversalpair();
					tempnew.node = temp.node.right;
					stack.addFirst(tempnew);
				}
			} else {
				stack.removeFirst();
			}
		}
	}

	public void levelorderI() {
		LinkedList<Node> stack = new LinkedList<>();

		stack.addLast(root);

		while (stack.size() != 0) {
			Node temp = stack.getFirst();

			if (temp.left != null) {
				stack.addLast(temp.left);

			}

			if (temp.right != null) {
				stack.addLast(temp.right);
			}

			System.out.print(temp.data + " ");
			stack.removeFirst();

		}
	}

	private class Transversalpair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
	}

	public void add(int data) {
		if (this.size == 0) {
			root = new Node();
			root.data = data;
			this.size++;
		} else {
			add(root, data);
		}
	}

	private void add(Node node, int data) {
		if (node.left == null && data < node.data) {
			Node temp = new Node();
			temp.data = data;
			node.left = temp;
			this.size++;
			return;
		} else if (node.right == null && data > node.data) {
			Node temp = new Node();
			temp.data = data;
			node.right = temp;
			this.size++;
			return;
		}

		if (data > node.data) {
			add(node.right, data);
		} else if (data < node.data) {
			add(node.left, data);
		}
	}

	public void SAconstructor(int[] sa) {
		root = SAconstructor(sa, 0, sa.length - 1);
	}

	private Node SAconstructor(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		Node child = new Node();
		int mid = (lo + hi) / 2;
		int data = sa[mid];
		child.data = data;

		child.left = SAconstructor(sa, lo, mid - 1);
		child.right = SAconstructor(sa, mid + 1, hi);

		return child;
	}

	public void removeoneleaf(int data) {
		removeoneleaf(root, data);
	}

	private void removeoneleaf(Node node, int data) {
		if (node == null) {
			return;
		}

		if (data == node.left.data) {
			node.left = null;
			this.size--;
		} else if (data == node.right.data) {
			node.right = null;
			this.size--;
		}

		if (data > node.data) {
			removeoneleaf(node.right, data);
		} else if (data < node.data) {
			removeoneleaf(node.left, data);
		}
	}

	public void remove(int data) {
		remove(root, data, null, false);
	}

	private void remove(Node node, int data, Node parent, boolean b) {
		if (node == null) {
			return;
		}

		if (data > node.data) {
			remove(node.right, data, node, false);
		} else if (data < node.data) {
			remove(node.left, data, node, true);
		} else {
			this.size--;
			if (node.left != null && node.right != null) {
				int num = this.max(node.left);
				node.data = num;
				remove(node.left, num, node, true);

			} else {
				Node remove = (node.left != null ? node.left : node.right);
				if (b) {
					parent.left = remove;
				} else {
					parent.right = remove;
				}
			}
		}
	}

	private class HeapMover{
		int sum = 0;
	}
	
	public void repleaceSWL(){
		HeapMover mover = new HeapMover();
		repleaceSWL(root,mover);
	}
	
	public void repleaceSWL(Node node,HeapMover mover){
		if(node == null){
			return;
		}
		
		repleaceSWL(node.right,mover);
		
		int temp = node.data;
		node.data = mover.sum;
		mover.sum+=temp;
		
		repleaceSWL(node.left,mover);
	}
	
	public void pir(int lo,int hi){
		pir(root,lo,hi);
	}
	
	private void pir(Node node,int lo,int hi){
		if(node == null){
		   return;
		}
		
		if(node.data>hi){
			pir(node.left,lo,hi);
		}
		else if(node.data<lo){
			pir(node.right,lo,hi);
		}
		else{
			System.out.println(node.data+" ");
			pir(node.left,lo,hi);
			pir(node.right,lo,hi);
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
