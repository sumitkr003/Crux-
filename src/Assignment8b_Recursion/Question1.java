package Assignment8b_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();  //number of boards
		int m = scn.nextInt();  //number of faces of a dice
		
		System.out.println(count(n,m,0,0));
		
		System.out.println(path(n,m,0));
		
		printdicevalue(n,m,0,"");
		}
	
	public static int count(int target,int m,int n,int count){
		 if(n==target){
			count++;
			return count;
		 }
		if(n>target){
			return count;
		}
		for(int i=1;i<=m;i++){
			count = count(target,m,n+i,count);
		}
		
		return count;
	}

	public static ArrayList<String> path(int target,int m,int n){
		if(n == target){
			ArrayList<String> rv = new ArrayList<>();
			rv.add("");
			return rv;
		}
		if(n>target){
			ArrayList<String> rv = new ArrayList<>();
			return rv;
		}
		ArrayList<String> result = new ArrayList<>();
	
		
		for(int i=1;i<=m;i++){
			ArrayList<String> rr = path(target,m,n+i);
			for(String val:rr){
				result.add(i+val);
			}
		}
		
		return result;
	}
  
	public static void printdicevalue(int target,int m,int n,String ans){
		if(n==target){
			System.out.println(ans);
			return;
		}
		else if(n>target){
			return;
		}
		
		for(int i=1;i<=m;i++){
			printdicevalue(target,m,n+i,ans+""+i);
		}
	}
}
