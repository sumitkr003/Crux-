package june14;

import java.util.Scanner;

public class selectionSort {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
//			System.out.println("enter " + i + "th element of the array");
			arr[i] = scn.nextInt();
		}

		int counter = 1, i;
		while (counter <= arr.length - 1) {
			for (i = counter; i <= arr.length - 1; i++) {
				if (arr[counter - 1] > arr[i]) {
					int temp = arr[counter - 1];
					arr[counter - 1] = arr[i];
					arr[i] = temp;
				}
			}
			counter++;
		}
		for (i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);

		}

	}

}
