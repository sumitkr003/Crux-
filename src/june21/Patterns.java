package june21;

import java.util.Scanner;

public class Patterns {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		increasingtriangle(1,1,n);
		
		decreasingtriangle(1,1,n);

	}
	public static void increasingtriangle(int row,int col,int n){
		if(row>n)
			return;
		
		if(col>row){
			System.out.println();
			increasingtriangle(row+1,1,n);
			return;
		}
		
		System.out.print("*");
		increasingtriangle(row,col+1,n);
		return;
	}
	
	public static void decreasingtriangle(int row,int col,int n){
		if(row>n)
			return;
		
		if(col>row){
			decreasingtriangle(row+1,1,n);
			System.out.println();
			return;
		}
		
		decreasingtriangle(row,col+1,n);
		System.out.print("*");
		return;
	}

}
