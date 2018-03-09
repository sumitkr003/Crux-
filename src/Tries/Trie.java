package Tries;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	public class Node {
		Character data;
		boolean eow;
		HashMap<Character, Node> children = new HashMap<>();
	}

	private Node root = new Node();
	private int numwords;
	private int numnodes;

	public void addword(String word) {
		addword(root, word);
	}

	private void addword(Node node, String str) {
		if (str.length() == 0) {
			node.eow = true;
			this.numwords++;
			return;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		Node child = node.children.get(ch);

		if (child != null) {
			addword(child, ros);
		} else {
			Node c = new Node();
			this.numnodes++;
			c.data = ch;
			node.children.put(ch, c);
			addword(c, ros);
		}
	}

	public boolean searchword(String word) {
		return searchword(root, word);
	}

	private boolean searchword(Node node, String str) {
		if (str.length() == 0) {
			return node.eow;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		Node child = node.children.get(ch);

		if (child != null) {
			return searchword(child, ros);
		} else {
			return false;
		}
	}

	public void removeword(String word) {
		removeword(root, null, word);
	}

	public void removeword(Node node, Node parent, String str) {
		if (str.length() == 0) {
			if (node.children == null) {
				parent.children.remove(node);
			} else {
				node.eow = false;
			}
			return;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		Node child = node.children.get(ch);

		if (node != null) {
			removeword(child, node, ros);
		}
		
		if(node.children == null && node.eow==false){
			parent.children.remove(node);
		}
		
	}
	
	public void display(){
		display(root,"");
	}
	
	private void display(Node node,String ans){
		if(node.eow){
			System.out.println(ans);
		}
		
		ArrayList<Character> al = new ArrayList<>(node.children.keySet());
		for(char ch:al){
			Node child = node.children.get(ch);
			display(child,ans+ch);
		}
		
	}

}
