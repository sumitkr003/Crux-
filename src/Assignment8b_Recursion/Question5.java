package Assignment8b_Recursion;

import java.util.Scanner;
import java.util.ArrayList;

public class Question5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		
		System.out.println(count(arr,0,0));
		
		System.out.println(positions(arr,0));
		
		printpositions(arr,0,"");
		
	}
	
	public static boolean isqueensafe(int[][] arr,int row,int col){
		int r = row,c=col;
		//vertical test
		while(r>=0){
			if(arr[r][c]==1){
				return false;
			}
			r--;
		}
		r = row;
		c=col;
		//positive diagonal test
		while(r>=0 && c<arr.length){
			if(arr[r][c]==1){
				return false;
			}
			r--;
			c++;
		}
		r = row;
		c=col;
		//negative diagonal
		while(r>=0 && c>=0){
			if(arr[r][c]==1){
				return false;
			}
			r--;
			c--;
		}
		
		return true;
	}

	public static int count(int[][] arr,int q,int count){
		if(q==arr.length){
			count++;
			return count;
		}
		for(int i=0;i<arr[0].length;i++){
			if(isqueensafe(arr,q,i) == true){
				arr[q][i]=1;
				count = count(arr,q+1,count);
				arr[q][i]=0;
			}
		}
		
		return count;
		
	}

	public static ArrayList<String> positions(int[][] arr,int q){
		if(q==arr.length){
			ArrayList<String> n = new ArrayList<>();
			for(int i=0;i<arr.length;i++){
				for(int j=0;j<arr.length;j++){
					if(arr[i][j]==1){
						n.add("{"+i+"-"+j+"}");
					}
				}
			}
			return n;
		}
		
		ArrayList<String> rv = new ArrayList<>();
		ArrayList<String> rr = new ArrayList<>();
		for(int i=0;i<arr[0].length;i++){
			if(isqueensafe(arr,q,i) == true){
				arr[q][i]=1;
			    rr = positions(arr,q+1);
			    for(String val:rr){
			    rv.add(val);	
			    }
				arr[q][i]=0;
			}
		}
		
		return rv;
		
	}

	public static void printpositions(int[][] arr,int q,String ans){
		if(q==arr.length){
			System.out.println(ans);
			return;
		}
		for(int i=0;i<arr[0].length;i++){
			if(isqueensafe(arr,q,i)==true){
				arr[q][i]=1;
				printpositions(arr,q+1,ans+"{"+q+"-"+i+"}");
				arr[q][i]=0;
			}
		}
	}
}
