package june14;

import java.util.Scanner;

public class WaveDisplayColumnWise {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter no of rows");
		int rows = scn.nextInt();
		
		System.out.println("enter no of columns");
		int cols = scn.nextInt();
		
		int[][] arr = new int[rows][cols];
		
		int row,col;
		for(row=0;row<arr.length;row++){
			for(col=0;col<arr[0].length;col++){
				arr[row][col] = scn.nextInt();
			}
		}
		
		for(col=0;col<arr[0].length;col++){
			if (col%2==0){
				for(row=0;row<arr.length;row++){
					System.out.print(arr[row][col]+" ");
				}
			}
			else{
				for(row=arr.length-1;row>=0;row--){
					System.out.print(arr[row][col]+" ");
				}
			}
		}
		System.out.print("END");


	}

}
