package Assignment8b_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Question8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int target = scn.nextInt();
		int m = scn.nextInt();
		int[] arr = new int[m];
		for(int i=0;i<m;i++){
			arr[i] = scn.nextInt();
		}
		int i,j;
		ArrayList ladder = new ArrayList();
		ladder.add(2);
		for(i=3;i<=target;i++){
		for(j=2;j<=i;j++){
			if(i%j==0){
				break;
			}
		  }
		if(j==i){
			ladder.add(i);
		}
		}
		
		System.out.println(snake(arr,0,target,0,ladder));

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
		int j = (int)ladder.get(ladder.size()-1-idx);
		if(idx<=(size-1) && idx%2==0){
			return j;
		}
		size = (ladder.size()+1)/2;
		if(idx>=size){
			if(ladder.size()%2==0 && idx%2==0){
				return j;
			}
			else if(ladder.size()%2==1 && idx%2==1){
				return j;
			}
		}
			
		return n;
     }
	
	public static boolean snake(int[] arr,int idx,int target,int count,ArrayList ladder){
		if(count==target){
			return true;
		}
		else if(idx==arr.length){
			return false;
		}
		
		if(isprime(count,target)==true){
			count = ladder(count,ladder);
		}
		if(count==target){
			return true;
		}
		 return snake(arr,idx+1,target,count+arr[idx],ladder);
	}
}
