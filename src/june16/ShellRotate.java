package june16;

import java.util.Scanner;

public class ShellRotate {

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
		int k = scn.nextInt();
		int r = scn.nextInt();
		int rmin=0,cmin=0,rmax=arr.length-1,cmax=arr[0].length-1,j=0;
		for(int i=0;i<k;i++){
			rmin++;
			cmin++;
			rmax--;
			cmax--;
		}
	   
	    row=rmin;
	    col=cmin;
	    int temp=arr[row][col],i;
		
			while(j<r){
				
				for(i=0;i<r;i++){
					arr[row][col]=arr[row][col+1];
					col++;
					if(i==r-1){
						col--;
						arr[row][col]=arr[row+1][col];
						}
			
			
			row++;
			for(i=0;i<r-1;i++){
				arr[row][col]=arr[row+1][col];
				row++;
				if(i==r-2){
					row-=1;
					arr[row][col]=arr[row][col-1];
				}
				}
				
			
				col--;
				for(i=0;i<r-1;i++){
					arr[row][col]=arr[row][col-1];
					col--;
					if(i==r-2){
						col++;
						arr[row][col]=arr[row-1][col];
					}
				}
				row--;
				for(i=0;i<r-2;i++){
					arr[row][col]=arr[row-1][col];
					row--;
					if(i==r-3){
						row++;
						arr[row][col]=temp;
					}
				}

			}
						
			for(i=0;i<arr.length;i++){
				for(j=0;j<arr[0].length;j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}

	}
}


