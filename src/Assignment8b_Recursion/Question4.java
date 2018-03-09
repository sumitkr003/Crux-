package Assignment8b_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int row = scn.nextInt();  //number of rows
		int col = scn.nextInt();  //number of columns
		
		System.out.println(count(row,col,0,0,0));
		
		System.out.println(moves(row,col,0,0));
		
		printmoves(row,col,0,0,"");

	}
	public static int count(int row,int col,int cr,int cc,int count){
		if(cr == row && cc == col){
			count++;
			return count;
		}
		else if(cr>row || cc>col){
			return count;
		}
		count = count(row,col,cr+1,cc,count);
		
		count = count(row,col,cr,cc+1,count);
		
		if(cr==cc){
			count = count(row,col,cr+1,cc+1,count);
		}
		
		return count;
	}

	public static ArrayList<String> moves(int row,int col,int cr,int cc){
		if(cr == row && cc == col){
			ArrayList<String> n = new ArrayList<>();
			n.add("");
			return n;
		}
		else if(cr>row || cc>col){
			ArrayList<String> n = new ArrayList<>();
			return n;
		}
		
		ArrayList<String> rv = new ArrayList<>();
		
		ArrayList<String> rr = moves(row,col,cr+1,cc);
		for(String val:rr){
			rv.add("V"+val);
		}
		
	    rr = moves(row,col,cr,cc+1);
	    for(String val:rr){
			rv.add("H"+val);
		}
		
	    if(cr==cc){
	    	rr = moves(row,col,cr+1,cc+1);
	    	for(String val:rr){
	    		rv.add('D'+val);
	    	}
	    }
		return rv;
	}

	public static void printmoves(int row,int col,int cr,int cc,String ans){
		if(cr == row && cc == col){
			System.out.print(ans+" ");
			return;
		}
		else if(cr>row || cc>col){
			return;
		}
		
		printmoves(row,col,cr+1,cc,ans+'V');
		
		printmoves(row,col,cr,cc+1,ans+'H');
		
		if(cr==cc){
			printmoves(row,col,cr+1,cc+1,ans+'D');
		}
	}
}

