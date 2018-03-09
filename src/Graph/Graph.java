package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

import GenericTree.GenericHeap;

public class Graph {
	private class vertex {
		HashMap<String, Integer> neighbours = new HashMap<>();
	}

	private HashMap<String, vertex> vces = new HashMap<>();

	public int nymvertices() {
		return vces.size();
	}

	public boolean containsvertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addvertex(String vname) {
		if (vces.containsKey(vname)) {
			return;
		}
		vertex vtx = new vertex();

		vces.put(vname, vtx);
	}

	public int numedges() {
		int rv = 0;

		ArrayList<String> vtx = new ArrayList<>(vces.keySet());

		for (String val : vtx) {
			vertex n = vces.get(val);
			rv += n.neighbours.size();
		}

		return rv / 2;
	}

	public boolean containsedge(String vname1, String vname2) {
		vertex vtx1 = vces.get(vname1);
		vertex vtx2 = vces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.neighbours.containsKey(vname2) == false) {
			return false;
		}

		return true;
	}

	public void addedge(String vname1, String vname2, int weight) {
		vertex vtx1 = vces.get(vname1);
		vertex vtx2 = vces.get(vname2);

		if (vtx1 == null || vtx2 == null) {
			return;
		}

		vtx1.neighbours.put(vname2, weight);
		vtx2.neighbours.put(vname1, weight);

	}

	public void removeedge(String vname1, String vname2) {
		vertex vtx1 = vces.get(vname1);
		vertex vtx2 = vces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.neighbours.containsKey(vname2) == false) {
			return;
		}

		vtx1.neighbours.remove(vname2);
		vtx2.neighbours.remove(vname1);
	}

	public void display() {
		ArrayList<String> vtx = new ArrayList<>(vces.keySet());

		for (String val : vtx) {
			vertex n = vces.get(val);
			ArrayList<String> nebrs = new ArrayList<>(n.neighbours.keySet());

			String ans = val + "=>";

			for (String val2 : nebrs) {
				ans += val2;
				ans += "[" + n.neighbours.get(val2) + "] ";
			}

			System.out.println(ans);
		}
	}

	public void removevertex(String vname) {
		vertex vtx = vces.get(vname);

		ArrayList<String> nebrs = new ArrayList<>(vtx.neighbours.keySet());

		for (String nebrsname : nebrs) {
			vertex vtx2 = vces.get(nebrsname);
			vtx2.neighbours.remove(vname);
		}

		vces.remove(vname);
	}

	public boolean haspath(String vname1, String vname2) {
		HashMap<String, Boolean> hp = new HashMap<>();
		return Haspath(vname1, vname2, hp);
	}

	private boolean Haspath(String vname1, String vname2, HashMap<String, Boolean> hp) {
		if (hp.containsKey(vname1)) {
			return false;
		}
		hp.put(vname1, true);

		if (this.containsedge(vname1, vname2)) {
			return true;
		}
		vertex vtx = vces.get(vname1);

		ArrayList<String> al = new ArrayList<>(vtx.neighbours.keySet());
		for (String val : al) {
			if (Haspath(val, vname2, hp)) {
				return true;
			}
		}
		return false;
	}

	public void printallpath(String vname1, String vname2) {
		HashMap<String, Boolean> hp = new HashMap<>();
		printallpath(vname1, vname2, hp, vname1);
	}

	public void printallpath(String vname1, String vname2, HashMap<String, Boolean> hp, String ans) {
		if (hp.containsKey(vname1)) {
			return;
		}
		hp.put(vname1, true);

		if (this.containsedge(vname1, vname2)) {
			ans += vname2;
			System.out.print(ans + vname2);

		}
		vertex vtx = vces.get(vname1);

		ArrayList<String> al = new ArrayList<>(vtx.neighbours.keySet());
		for (String val : al) {
			printallpath(val, vname2, hp, ans + val);
			hp.put(val, false);
		}

		return;
	}

	public boolean bfs(String vname1, String vname2) {
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<String, Boolean> hp = new HashMap<>();

		pair pair = new pair(vname1, vname1);
		queue.add(pair);
		hp.put(vname1, true);

		while (!queue.isEmpty()) {
			pair p = queue.removeFirst();

			if (hp.containsKey(p.vname)) {
				return false;
			}
			hp.put(p.vname, true);

			if (this.containsedge(p.vname, vname2)) {
				System.out.println(p.psf + vname2);
				return true;
			}

			ArrayList<String> al = new ArrayList<>(vces.get(p.vname).neighbours.keySet());

			for (String val : al) {
				if (!hp.containsKey(val)) {
					pair q = new pair(val, p.psf + val);
					queue.addFirst(q);
				}
			}
		}
		return false;
	}

	public class pair {
		String vname;
		String psf;

		public pair(String b, String c) {
			this.vname = b;
			this.psf = c;
		}
	}

	public boolean dfs(String vname1, String vname2) {
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> hp = new HashMap<>();

		pair pair = new pair(vname1, vname1);
		stack.addLast(pair);
		// hp.put(vname1, true);

		while (!stack.isEmpty()) {
			pair p = stack.removeFirst();

			if (hp.containsKey(p.vname)) {
				return false;
			}
			hp.put(p.vname, true);

			if (this.containsedge(p.vname, vname2)) {
				System.out.println(p.psf + vname2);
				return true;
			}

			ArrayList<String> al = new ArrayList<>(vces.get(p.vname).neighbours.keySet());

			for (String val : al) {
				if (!hp.containsKey(val)) {
					pair q = new pair(val, p.psf + val);
					stack.addLast(q);
				}
			}
		}
		return false;
	}

	public void bft() {
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> hp = new HashMap<>();

		ArrayList<String> nebrsname = new ArrayList<>(vces.keySet());

		for (String nebrs : nebrsname) {

			if (hp.containsKey(nebrs)) {
				continue;
			}

			pair pair = new pair(nebrs, nebrs);
			stack.add(pair);
			// hp.put(nebrs, true);

			while (!stack.isEmpty()) {
				pair p = stack.removeFirst();

				if (hp.containsKey(p.vname)) {
					continue;
				}
				hp.put(p.vname, true);
				System.out.println(p.vname + " via " + p.psf);

				ArrayList<String> al = new ArrayList<>(vces.get(p.vname).neighbours.keySet());

				for (String val : al) {
					if (!hp.containsKey(val)) {
						pair q = new pair(val, p.psf + val);
						stack.addLast(q);
					}
				}
			}
		}
	}

	public void dft() {
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<String, Boolean> hp = new HashMap<>();

		ArrayList<String> nebrsname = new ArrayList<>(vces.keySet());

		for (String nebrs : nebrsname) {
			pair pair = new pair(nebrs, nebrs);
			queue.addFirst(pair);
			// hp.put(nebrs, true);

			while (!queue.isEmpty()) {
				pair p = queue.removeFirst();

				if (hp.containsKey(p.vname)) {
					continue;
				}
				System.out.println(p.vname + " via " + p.psf);
				hp.put(p.vname, true);

				ArrayList<String> al = new ArrayList<>(vces.get(p.vname).neighbours.keySet());

				for (String val : al) {
					if (!hp.containsKey(val)) {
						pair q = new pair(val, p.psf + val);
						queue.addFirst(q);
					}
				}
			}
		}
	}

	public boolean isconnected() {
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> hp = new HashMap<>();

		ArrayList<String> nebrsname = new ArrayList<>(vces.keySet());

		int count = 0;
		for (String nebrs : nebrsname) {

			if (hp.containsKey(nebrs)) {
				continue;
			}
			count++;

			if (count == 2) {
				return false;
			}

			pair pair = new pair(nebrs, nebrs);
			stack.add(pair);
			// hp.put(nebrs, true);

			while (!stack.isEmpty()) {
				pair p = stack.removeFirst();

				if (hp.containsKey(p.vname)) {
					continue;
				}
				hp.put(p.vname, true);
				System.out.println(p.vname + " via " + p.psf);

				ArrayList<String> al = new ArrayList<>(vces.get(p.vname).neighbours.keySet());

				for (String val : al) {
					if (!hp.containsKey(val)) {
						pair q = new pair(val, p.psf + val);
						stack.addLast(q);
					}
				}
			}
		}

		return true;
	}

	public boolean iscyclic() {
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> hp = new HashMap<>();

		ArrayList<String> nebrsname = new ArrayList<>(vces.keySet());

		for (String nebrs : nebrsname) {

			if (hp.containsKey(nebrs)) {
				continue;
			}

			pair pair = new pair(nebrs, nebrs);
			stack.add(pair);
			// hp.put(nebrs, true);

			while (!stack.isEmpty()) {
				pair p = stack.removeFirst();

				if (hp.containsKey(p.vname)) {
					return true;
				}
				hp.put(p.vname, true);
				System.out.println(p.vname + " via " + p.psf);

				ArrayList<String> al = new ArrayList<>(vces.get(p.vname).neighbours.keySet());

				for (String val : al) {
					if (!hp.containsKey(val)) {
						pair q = new pair(val, p.psf + val);
						stack.addLast(q);
					}
				}
			}
		}
		return true;
	}

	public boolean istree() {
		return isconnected() && iscyclic() == false;
	}

	public ArrayList<String> gcc() {
		ArrayList<String> str = new ArrayList<>();

		LinkedList<pair> queue = new LinkedList<>();
		HashMap<String, Boolean> hp = new HashMap<>();

		ArrayList<String> nebrsname = new ArrayList<>(vces.keySet());

		String s = "";
		for (String nebrs : nebrsname) {
			str.add(s);

			s = "";

			pair pair = new pair(nebrs, nebrs);
			queue.addFirst(pair);
			// hp.put(nebrs, true);

			while (!queue.isEmpty()) {
				pair p = queue.removeFirst();

				if (hp.containsKey(p.vname)) {
					continue;
				}
				s += p.vname;

				System.out.println(p.vname + " via " + p.psf);
				hp.put(p.vname, true);

				ArrayList<String> al = new ArrayList<>(vces.get(p.vname).neighbours.keySet());

				for (String val : al) {
					if (!hp.containsKey(val)) {
						pair q = new pair(val, p.psf + val);
						queue.addFirst(q);
					}
				}
			}
		}

		return str;
	}

	public static class djikstra {
		String vname;
		String psf;
		int csf;
		public static final Comparator<djikstra> ctor = new djikstraComparator();

		public djikstra(String vname, String psf, int csf) {
			this.vname = vname;
			this.psf = psf;
			this.csf = csf;

		}

		public static class djikstraComparator implements Comparator<djikstra> {

			@Override
			public int compare(djikstra o1, djikstra o2) {
				return o2.csf - o1.csf;
			}

		}

		@Override
		public String toString() {
			return this.psf + "@" + this.csf;
		}
	}

	public HashMap<String, djikstra> djikstra(String src) {
		HashMap<String, djikstra> map = new HashMap<>();
		GenericHeap<djikstra> heap = new GenericHeap<>(djikstra.ctor);

		ArrayList<String> al = new ArrayList<>(vces.keySet());

		for (String str : al) {
			djikstra pair = new djikstra(str, "", Integer.MAX_VALUE);

			if (str.equals(src)) {
				pair.csf = 0;
				pair.psf = str;
			}

			heap.add(pair);
			map.put(str, pair);
		}

		while (heap.size() != 0) {
			djikstra rp = heap.removeHP();

			ArrayList<String> nbrnames = new ArrayList<>(vces.get(rp.vname).neighbours.keySet());

			for (String nbrname : nbrnames) {
				djikstra np = map.get(nbrname);

				int ocsf = np.csf;
				int ncsf = rp.csf + vces.get(rp.vname).neighbours.get(nbrname);

				if (ncsf < ocsf) {
					np.csf = ncsf;
					np.psf = rp.psf + np.vname;

					heap.updatepriority(np);
				}
			}
		}

		return map;
	}

	public Graph primises() {
		Graph g = new Graph();

		HashMap<String, primises> map = new HashMap<>();
		GenericHeap<primises> hp = new GenericHeap<>(primises.ctor);

		ArrayList<String> al = new ArrayList<>(vces.keySet());

		for (String str : al) {
			primises p = new primises(str, null, Integer.MAX_VALUE);

			map.put(str, p);
			hp.add(p);
		}

		while (hp.size() != 0) {
			primises rp = hp.removeHP();

			if (rp.aq == null) {
				g.addvertex(rp.vname);
			} else {
				g.addvertex(rp.vname);
				g.addedge(rp.vname, rp.aq, rp.aqcost);
			}

			ArrayList<String> nbrnames = new ArrayList<>(vces.get(rp.vname).neighbours.keySet());

			for (String nebrname : nbrnames) {
				primises np = map.get(nebrname);

				int oaqcost = np.aqcost;
				int naqcost = vces.get(rp.vname).neighbours.get(nebrname);

				if (naqcost < oaqcost) {
					np.aqcost = naqcost;
					np.aq = rp.vname;

					hp.updatepriority(np);
				}

			}
		}

		return g;
	}

	private static class primises {
		String vname;
		String aq;
		int aqcost;

		public static final primisesComparator ctor = new primisesComparator();

		public primises(String vname, String aq, int aqcost) {
			this.vname = vname;
			this.aq = aq;
			this.aqcost = aqcost;
		}

		public static class primisesComparator implements Comparator<primises> {

			@Override
			public int compare(primises o1, primises o2) {
				return o2.aqcost - o1.aqcost;
			}

		}
	}

}
