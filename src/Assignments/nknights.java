package Assignments;

public class nknights {

	public static void main(String[] args) {
		boolean[][] board = new boolean[50][50];
		knights(1, board, "", 0);
	}

	public static boolean issafe(int cr, int cc, boolean[][] board) {
		if (cr - 2 >= 0 && cc - 1 >= 0 && board[cr - 2][cc - 1]) {
			return false;
		} else if (cr - 2>= 0 && cc + 1 < board.length && board[cr - 2][cc + 1]) {
			return false;
		} else if (cr - 1>= 0 && cc - 2 >= 0 && board[cr - 1][cc - 2]) {
			return false;
		} else if (cr -1 >= 0 && cc + 2 < board.length && board[cr - 1][cc + 2]) {
			return false;
		}
		return true;
	}

	static int counter = 0;

	public static void knights(int cellno, boolean[][] board, String psf, int kpsf) {
		if (kpsf == board.length) {
			counter++;
			System.out.println(counter + "." + psf);
			return;
		}

		for (int i = cellno; i <= board.length * board.length; i++) {
			int cr = (i - 1) / board.length;
			int cc = (i - 1) % board.length;

			if (issafe(cr, cc, board)) {
				board[cr][cc] = true;
				knights(i + 1, board, psf + "[" + cr + "-" + cc + "]", kpsf + 1);
				board[cr][cc] = false;
			}
		}
	}

}
