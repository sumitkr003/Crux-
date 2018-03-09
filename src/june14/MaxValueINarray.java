package june14;

import java.util.Scanner;

public class MaxValueINarray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("enter " + i + "th element of the array");
			arr[i] = scn.nextInt();
		}
		int max=Max(arr);
		System.out.println(max);

	}
	public static int Max(int[] arr){
		int temp=arr[0];
		for(int i=1;i<arr.length;i++){
			if(temp<arr[i]){
				temp=arr[i];
			}
		}
		return temp;
	}

}
