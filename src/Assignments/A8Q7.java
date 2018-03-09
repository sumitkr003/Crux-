package Assignments;

import java.util.Arrays;
import java.util.HashMap;

public class A8Q7 {

	public static void main(String[] args) {
		int n = 15;
		
		boolean[] b = prime(n);
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int left = 0,right = b.length-1;
		
		while(left<right){
			while(b[left]!=true){
				left++;
			}
			
			while(b[right]!=true){
				right--;
			}
			
			if(left<right){
				map.put(left, right);
		    }
			
			left++;
			right--;
		}
		
		question8(0,n,"",map);
	}
	
	
	public static boolean[] prime(int n){
		boolean arr[] = new boolean[n+1];
		Arrays.fill(arr,true);
		arr[0] = false;
		arr[1] = false;
		
		
		for(int tbl = 2;tbl * tbl<=n;tbl++){
			if(arr[tbl] == false){
				continue;
			}
			
			for(int i = 2; i * tbl<=n;i++){
				arr[i*tbl] = false;
			}
		}
		
		return arr;
	}
	
	public static void question8(int curr,int end,String ans,HashMap<Integer, Integer> map){
		if(curr == end){
			System.out.println(ans);
			return;
		}
		
		if(curr>end){
			return;
		}
		
		if(map.containsKey(curr)){
			question8(map.get(curr),end,ans+= "L" + "[" + curr +"->" + map.get(curr) + "]",map);
		}else{
			for(int i = 1;i<=6;i++){
				question8(curr + i,end,ans+"D"+i,map);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

