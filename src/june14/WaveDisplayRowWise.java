package june14;

import java.util.Scanner;

public class WaveDisplayRowWise {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter no of rows");
		int rows = scn.nextInt();

		System.out.println("enter no of columns");
		int cols = scn.nextInt();

		int[][] arr = new int[rows][cols];

		int row, col;
		for (row = 0; row < arr.length; row++) {
			for (col = 0; col < arr[0].length; col++) {
				arr[row][col] = scn.nextInt();
			}
		}
		for(row=0;row<arr.length;row++){
			if(row%2==0){
				for(col=0;col<arr[0].length;col++){
					System.out.println(arr[row][col]+", ");
				}
			}
			else{
				for(col=arr[0].length-1;col>=0;col--){
					System.out.println(arr[row][col]+", ");
				}
			}
		}
		System.out.println("END");

	}

}
