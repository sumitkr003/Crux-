package june14;

import java.util.Scanner;

public class SpiralDisplayClockwise {

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
		
		int dir=0,count=0,i;
		row=0;
		col=0;
		int rmax=arr.length-1,cmax=arr[0].length-1;
		while(count!=rows*cols){
			//east  
			for(i=0;i<=cmax && count!=(rows*cols);i++){
				System.out.print(arr[row][col]+" ");
				col++;
				count++;
			}
			row++;
			col--;
			rmax--;
			for(i=0;i<=rmax && count!=(rows*cols);i++){
				System.out.print(arr[row][col]+" ");
				row++;
				count++;
			}
			row--;
			col--;
			cmax--;
			for(i=0;i<=cmax && count!=(rows*cols);i++){
				System.out.print(arr[row][col]+", ");
				col--;
				count++;
			}
			col++;
			row--;
			rmax--;
			for(i=0;i<=rmax && count!=(rows*cols);i++){
				System.out.print(arr[row][col]+", ");
				row--;
				count++;
			}
			row++;
			col++;
			cmax--;
		}
		System.out.println("END");
	}

}
