package june9;

import java.util.Scanner;

public class b2d {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("enter number of rows");
		int b = scn.nextInt();
		int p = 1;
		int d = 0, rem;
		while (b != 0) {
			rem = b % 10;
			d = d + p * rem;
			p = p * 2;
			b = b / 10;
		}
		System.out.println(d);

	}

}
