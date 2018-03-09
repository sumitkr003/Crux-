package june12;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		
		int sqroot;
		sqroot = (int)(Math.pow(num,0.5));
		System.out.println(sqroot);

	}

}
