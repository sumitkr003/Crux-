package june14;

import java.util.Scanner;

public class InverseofARRAY {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int[] invarr = new int[arr.length];
		 invarr=inverse(arr);
		for(int val:invarr){
			System.out.print(val+" ");
		}

	}
	public static int[] inverse(int[] arr){
		int[] invarr = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			
			invarr[(arr[i])]=i;
		}
		return invarr;
	}
}
