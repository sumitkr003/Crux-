package june14;

import java.util.Scanner;

public class linearSearch {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("enter " + i + "th element of the array");
			arr[i] = scn.nextInt();
		}
		System.out.println("enter number to be searched");
		int search = scn.nextInt();
		
		int index = linearsearch(arr,search);
		System.out.println(index);
		}
	public static int linearsearch(int[] arr,int search){
		
		for(int i=0;i<arr.length;i++){
			if(search==arr[i]){
				return i;
			}
		}
		return -1;
		
	}

}
