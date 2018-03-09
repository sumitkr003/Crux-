package Assignment9;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		System.out.println(duplicates(arr));

	}
	
	public static boolean duplicates(int[] arr){
		return false;
	}

}
