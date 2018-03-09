package june14;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		//taking input
		for (int i = 0; i < arr.length; i++) {
//			System.out.println("enter " + i + "th element of the array");
			arr[i] = scn.nextInt();
		}
		
		//insertion sort
		int counter = 1, i;
		while (counter <= arr.length - 1) {
			for (i = counter; i > 0; i--) {
				if (arr[i] < arr[i - 1]) {
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
				}
			}
			counter++;
		}
		
		//printing array
		for (i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);

		}
	}
}
