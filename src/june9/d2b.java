package june9;

import java.util.Scanner;

public class d2b {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("enter number of rows");
		int d = scn.nextInt();
		int rem,ans=0;
		int i=0;
		int pow = 1;
		while(d!=0){
			rem=d%2;
			ans=ans+rem * pow;
			d=d/2;
			pow = pow * 10;
		}
		System.out.println(ans);

	}

}
