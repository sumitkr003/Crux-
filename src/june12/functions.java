package june12;

import java.util.Scanner;

public class functions {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int pow = scn.nextInt();
		
		int ans=power(num,pow);
		System.out.println(ans);
		
		int log=log(ans,num);
		
		System.out.println(log);
		
		int x=logarithm(num,pow);
		System.out.println(x);

	}
	
	public static int power(int a, int b){
		int c=(int)(Math.pow(a, b));
		return c;
	}
	
	public static int log(int a,int b){
		int  n=1;
		int d=1;
		while(d!=a){
			n++;
			d=d*b;
		}
		n--;
		return n;
	}

	public static int logarithm(int n,int p){
		int result=power(n,p);
		int m=1;
		int d=1;
		while(d!=result){
		   m++;
		   d=d*n;
		}
		m--;
		return m;
																									
	}
}
