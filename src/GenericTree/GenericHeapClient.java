package GenericTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import Generics.Generic;

public class GenericHeapClient {

	public static void main(String[] args) {
		// ArrayList<Integer> one = new ArrayList<>(Arrays.asList(10,15,20,25));
		// ArrayList<Integer> two = new ArrayList<>(Arrays.asList(9,18,24,27));
		// ArrayList<Integer> three = new ArrayList<>(Arrays.asList(5,7,28,40));
		// ArrayList<Integer> four = new ArrayList<>(Arrays.asList(17,19,1,28));
		//
		// ArrayList<ArrayList<Integer>> lists = new
		// ArrayList<>(Arrays.asList(one,two,three,four));
		//
		// System.out.println(mergeKlist(lists));

		ArrayList<Integer> o = new ArrayList<>(Arrays.asList(10, 15, 5, 7, 20, 25));

		System.out.println(getKlargest(o, 3));
	}

	public static ArrayList<Integer> mergeKlist(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> list = new ArrayList<>();

		GenericHeap<pair> heap = new GenericHeap<>(pair.comparator);

		// filling
		for (int i = 0; i < lists.size(); i++) {
			pair pair = new pair();
			pair.lno = i;
			pair.ino = 0;
			pair.data = lists.get(i).get(0);
			heap.add(pair);
		}

		while (heap.size() != 0) {
			pair p = heap.removeHP();
			list.add(p.data);

			p.ino++;
			if (p.ino < lists.get(p.lno).size()) {
				pair pi = new pair();

				pi.data = lists.get(p.lno).get(p.ino);
				pi.lno = p.lno;
				pi.ino = p.ino;

				heap.add(pi);
			}

		}

		return list;

	}

	private static class pair {
		int data;
		int lno;
		int ino;

		public static final paircomparator comparator = new paircomparator();

		public static class paircomparator implements Comparator<pair> {

			@Override
			public int compare(pair o1, pair o2) {
				return o2.data - o1.data;
			}
		}
	}

	public static ArrayList<Integer> getKlargest(ArrayList<Integer> lists, int k) {
		ArrayList<Integer> list = new ArrayList<>();

		GenericHeap<pair> heap = new GenericHeap<>(pair.comparator);

		for (int i = 0; i < k; i++) {
			pair p = new pair();
			p.data = lists.get(i);

			heap.add(p);
		}

		for (int i = k; i < lists.size(); i++) {
			pair n = heap.getHP();
			int data = lists.get(i);

			if (data > n.data) {
				heap.removeHP();

				pair pair = new pair();
				pair.data = data;
				heap.add(pair);
			}
		}

		while (heap.size() != 0) {
			list.add(heap.removeHP().data);
		}

		return list;
	}
}
