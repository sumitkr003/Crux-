package june14;

import java.util.Scanner;

public class bubbleSort {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("enter " + i + "th element of the array");
			arr[i] = scn.nextInt();
		}

		int counter = 1, i;
		while (counter <= arr.length - 1) {
			for (i = 0; i < arr.length - counter; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			counter++;
		}
		for (i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);

		}

	}

}
