package june14;

import java.util.Scanner;

public class Permutations {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		print(arr,n);

	}
	public static void print(int[] arr,int n){
		int i;
		int[] b=new int[n-1];
		for(i=1;i<b.length;i++){
			b[1-i]=arr[i];
		}
		i=0;
	    int j=0;
		while(i<n){
			
			while(j<factorial(n-1)){
				System.out.println(arr[0]);
			    
			}
			
		}
	}
	public static int factorial(int m){
		int n=m-1;
		while(n>1){
			m=m*n;
			n--;
		}
		return m;
	}

}
