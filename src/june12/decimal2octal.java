package june12;

import java.util.Scanner;

public class decimal2octal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int octal;
		octal=octal(num);
		System.out.println(octal);

	}
	public static int octal(int num){
		int p=8;
		int rem,octal=0,i=0;
		while(num!=0){
			rem=num%p;
			octal+=rem*(int)(Math.pow(10, i));
			num/=p;
			i++;
		}
		return octal;
		
	}
}
