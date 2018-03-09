package june23;

import java.util.ArrayList;

public class Maze {

	public static void main(String[] args) {
		System.out.println(mazepath(0, 0, 2, 2));

	}

	public static ArrayList<String> mazepath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> n = new ArrayList<>();
			n.add("");
			return n;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> n = new ArrayList<>();
			return n;
		}
		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rh = new ArrayList<>();
		rh = mazepath(cr + 1, cc, er, ec);
		for (String rc : rh) {
			mr.add("v" + rc);
		}

		ArrayList<String> rv = new ArrayList<>();
		rv = mazepath(cr, cc + 1, er, ec);
		for (String rc : rv) {
			mr.add("h" + rc);
		}
		
		ArrayList<String> rd = new ArrayList<>();
		rd = mazepath(cr+1, cc + 1, er, ec);
		for (String rc : rd) {
			mr.add("d" + rc);
		}

		return mr;
	}

}
