package june9;

import java.util.Scanner;

public class decimal2db {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("enter number of rows");
		int d = scn.nextInt();
		int db = scn.nextInt();
		int rem,ans=0;
		int i=0;
		while(d!=0){
			rem=d%db;
			ans=10*ans+rem;
			d=d/db;
		}
		System.out.println(ans);

	}

}
