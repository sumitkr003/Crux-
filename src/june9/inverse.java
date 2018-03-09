package june9;

import java.util.Scanner;

public class inverse {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		
		
	    int rem,temp = 0;
		int i=1;
		
		while (num!=0) {
			rem = num % 10;
			
			temp = temp + i*((int) Math.pow(10, (rem - 1)));
			num = num / 10;
			i++;
		}
		System.out.println(temp);

	}

}
