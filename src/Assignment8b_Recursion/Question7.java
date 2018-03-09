package Assignment8b_Recursion;

import java.util.Scanner;
import java.util.*;

public class Question7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int i,j;
		
		ArrayList ladder = new ArrayList();
		ladder.add(2);
		for(i=3;i<=n;i++){
		for(j=2;j<=i;j++){
			if(i%j==0){
				break;
			}
		  }
		if(j==i){
			ladder.add(i);
		}
		}
		
		System.out.println(snakes(n,0,0,ladder));
		
//		System.out.println(ways(n,0,ladder));

		printways(n,0,ladder,"");
	}
	
	
	
	public static boolean isprime(int n,int target){
		if(n>=target){
			return false;
		}
		else if(n==2){
			return true;
		}
		else if(n<=1){
			return false;
		}
		else{
			for(int i=2;i<=n/2;i++){
				if(n%i==0){
					return false;
				}
			}
		}
		return true;
	}

	public static int ladder(int n,ArrayList ladder){
		int idx = ladder.indexOf(n);
		int size = (ladder.size())/2;
		if(idx<=(size-1)){
			int j = (int)ladder.get(ladder.size()-1-idx);
			return j;
		}
		else{
			return n;
		}
		
	}
	
	public static int snakes(int target,int count,int n,ArrayList ladder){
		if(n==target){
			count++;
			return count;
		}
		if(n>target){
			return count;
		}
		for(int i=1;i<=6;i++){
			
			if(isprime(n,target)==true){
				n = ladder(n,ladder); 
			}
			
			if(n==target){
				count++;
				return count;
			}
			
			count = snakes(target,count,n+i,ladder);
		}
		
		return count;
	}

	public static ArrayList<String> ways(int target,int n,ArrayList ladder){
		if(n==target){
			ArrayList<String> r = new ArrayList<>();
			r.add("");
			return r;
		}
		else if(n>target){
			ArrayList<String> r = new ArrayList<>();
			return r;
		}
		
		ArrayList<String> rv = new ArrayList<>();
		
		for(int i=1;i<=6;i++){
			if(isprime(n,target)==true){
				n = ladder(n,ladder);
			}
			
			if(n==target){
				ArrayList<String> r = new ArrayList<>();
				r.add("");
				return r;
			}
			
			ArrayList<String> rr = ways(target,n+i,ladder);
			for(String val:rr){
				rv.add(i+val);
			}
		}
		
		return rv;
	}

	public static void printways(int target,int n,ArrayList ladder,String ans){
		if(n==target){
			System.out.print(ans+" ");
			return;
		}
		else if(n>target){
			return;
		}
		
		for(int i=1;i<=6;i++){
			if(isprime(n,target)==true){
				n = ladder(n,ladder);
			}
			if(n==target){
				System.out.print(ans+" ");
				return;
			}
			printways(target,n+i,ladder,ans+""+i);
		}
		
		return;
	}
}
