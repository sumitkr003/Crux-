package june12;

import java.util.Scanner;

public class far2cal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int minf = scn.nextInt();
		int maxf = scn.nextInt();
		int stepf = scn.nextInt();

		int tempf = minf;
		while (tempf <= maxf) {
			int cal = (int) ((9.0 / 5) * (tempf - 32));
			tempf = tempf + stepf;
			System.out.println(tempf + " " + cal);
		}

	}

}
