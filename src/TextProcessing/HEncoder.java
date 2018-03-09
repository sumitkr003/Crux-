package TextProcessing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import org.w3c.dom.Node;

import BinaryTree.BinaryTree;
import GenericTree.GenericHeap;
import Generics.Generic;
import Generics.Generic.speedcomparator;

public class HEncoder {
	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	private static class node {
		char data;
		int freq;
		node left;
		node right;

		private static final Comparator<node> cptor = new nodecomparator();

		private static class nodecomparator implements Comparator<node> {

			@Override
			public int compare(node o1, node o2) {
				// TODO Auto-generated method stub
				return o2.freq - o1.freq;
			}

		}
	}

	public HEncoder(String feeder) {
		HashMap<Character, Integer> frequency = new HashMap<>();

		for (int i = 0; i < feeder.length(); i++) {
			char ch = feeder.charAt(i);

			if (frequency.containsKey(ch)) {
				frequency.put(ch, frequency.get(ch) + 1);
			} else {
				frequency.put(ch, 1);
			}
		}

		ArrayList<Character> keys = new ArrayList<>(frequency.keySet());
		GenericHeap<node> heap = new GenericHeap<>(node.cptor);

		for (Character ch : keys) {
			node n = new node();
			n.data = ch;
			n.freq = frequency.get(ch);

			heap.add(n);
		}

		while (heap.size() != 1) {
			node one = heap.removeHP();
			node two = heap.removeHP();

			node three = new node();
			three.data = one.data;
			three.freq = one.freq + two.freq;

			three.left = one;
			three.right = two;
			heap.add(three);
		}

		this.traverse(heap.removeHP(), "");

	}

	public void traverse(node node, String osf) {
		if (node.left == null && node.right == null) {
			encoder.put(node.data, osf);
			decoder.put(osf, node.data);
			return;
		}

		if (node.left != null) {
			traverse(node.left, osf + 0);
		}

		if (node.right != null) {
			traverse(node.right, osf + 1);
		}

	}

	public String compress(String str) {
		String rv = "";
		for (int i = 0; i < str.length(); i++) {
			rv += encoder.get(str.charAt(i));
		}

		return rv;
	}

	public String decompress(String str) {
		String rv = "";
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			s += str.charAt(i);
			if (decoder.containsKey(s)) {
				rv += decoder.get(s);
				s = "";
			}
		}

		return rv;
	}

}
