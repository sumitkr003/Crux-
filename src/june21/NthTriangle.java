package june21;

import java.util.Scanner;

public class NthTriangle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(triangle(n,0));
       }
	public static int triangle(int n,int sum){
		if(n==1)
			return 1;
		
		sum = triangle(n-1,sum);
		sum = sum+n;
		return sum;
	}

}
