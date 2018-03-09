package june14;

import java.util.Scanner;

public class exitPoint {

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
		int dir;
		row=0;
		col=0;
		dir=arr[row][col];
		while(true){
			dir = dir%4;
			while(dir==0){
				col++;
				
				if(col==arr[0].length){
					System.out.println(row+ " "+ (col-1));
					return;
				}
				dir = dir + arr[row][col];
			}
			while(dir==1){
				row++;
				
				if(row==arr.length){
					System.out.println((row-1)+" "+ col);
					return;
				}
				dir = dir + arr[row][col];
			}
			while(dir==2){
				col--;
				
				if(col==-1){
					System.out.println(row+" "+0);
					return;
				}
				dir = dir + arr[row][col];
			}
			while(dir==3){
				row--;
				
				if(row==-1){
					System.out.println(0+" "+col);
					return;
				}
				dir = dir + arr[row][col];
			}
		
		}

	}

}
