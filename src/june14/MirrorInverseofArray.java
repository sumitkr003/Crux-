package june14;

import java.util.Scanner;

public class MirrorInverseofArray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		boolean b=mirrorinverse(arr);
		System.out.println(b);

	}
	public static boolean mirrorinverse(int[] arr){
		int[] invarr = new int[arr.length];
		boolean b;
		for(int i=0;i<=arr.length-1;i++){
			
			invarr[(arr[i])]=i;
		}
		for(int i=0;i<arr.length;i++){
			if (arr[i]!=invarr[i]){
				b=false;
				return b;
			}
		}
		return b=true;
	}

}
