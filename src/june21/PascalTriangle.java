package june21;

import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		pascaltriangle(0,0,n,1);

	}
	public static void pascaltriangle(int row,int col,int n,int num){
		if(row==n)
			return;
		
		if(col>row){
			System.out.println();
			pascaltriangle(row+1,0,n,1);
			return;
		}
		
		int r=row+1;
		if(col>0)
			num = num*(r-col)/col;
		System.out.print(num+" ");
		pascaltriangle(row,col+1,n,num);
		return;
	}

}
