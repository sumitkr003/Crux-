package june21;

import java.util.Scanner;

public class DecreasingIncreasing {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		di(n-1);
		}
	public static void di(int n){
		if(n==0)
			return;
		
		if (n%2!=0)
			System.out.println(n);
		
		di(n-1);
		
		if (n%2==0)
		    System.out.println(n);
	}

}
