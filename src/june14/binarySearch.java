package june14;

import java.util.Scanner;

public class binarySearch {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println("enter number to be searched");
		int search = scn.nextInt();

		//for sorted array
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (search == arr[mid]) {
				System.out.println(mid);
				return;
			} else if (arr[mid] <  search) {
				low = mid + 1;
			} else  {
				high = mid-1;
			}
		}
		System.out.println("match not found");

	}

}
