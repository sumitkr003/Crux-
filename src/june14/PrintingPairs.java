package june14;

import java.util.Scanner;

public class PrintingPairs {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println("enter a number");
		int pair = scn.nextInt();

		printingpairs(arr, pair);

	}

	public static void printingpairs(int[] arr, int pair) {
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

		for (i = 0; i < arr.length; i++) {

			if (arr[i] > pair) {
				break;
			}

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == pair) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}
		}
	}

}
