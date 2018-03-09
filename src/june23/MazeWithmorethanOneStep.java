package june23;

import java.util.ArrayList;

public class MazeWithmorethanOneStep {

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

		for (int i = 1; i <= 2; i++) {
			
			//for vertical path
			ArrayList<String> rh = new ArrayList<>();
			rh = mazepath(cr + i, cc, er, ec);
			for (String rc : rh) {
				mr.add("v" + "" + i + rc);
			}
		    
			//for horizontal path
            ArrayList<String> rv = new ArrayList<>();
			rv = mazepath(cr, cc + i, er, ec);
			for (String rc : rv) {
				mr.add("h" + "" + i + rc);
			}
			
			//for diagonal path
			ArrayList<String> rd = new ArrayList<>();
			rd = mazepath(cr + i, cc + i, er, ec);
			for (String rc : rd) {
				mr.add("d" + "" + i + rc);
			}
		}

		return mr;
	}

}
