package june14;

import java.util.Scanner;

public class ReverseofArray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		reverse(arr);
		for(int val:arr){
			System.out.print(val+ " ");
		}

	}
	public static void reverse(int[] arr){
		int temp;
		for(int i=0;i<arr.length/2;i++){
			temp=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-1-i]=temp;
		}
	}

}
