package june21;

import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
		int[] arr = {3,7,4,7,7,6,2,8,7,7}; 
		String s ="nitin";
		
//		int i;
//		for(i=0;i<arr.length;i++){
//			arr[i] = in.nextInt();
//		}
//		displayreverse(arr,0);
//		System.out.println(max(arr,0));
//		System.out.println(find(arr,0,33));
//		System.out.println(firstindex(arr,0,11));
//		System.out.println(lastindex(arr,arr.length-1,11));
//		int[] x=allindices(arr,0,7,0);
//		for(int val:x){
//			System.out.print(val+" ");
//		}
//		System.out.println(palindrome(s,0,s.length()-1));
		invertedtriangle(1,1,5);

	}
	public static void displayreverse(int[] arr,int vidx){
		if(vidx==arr.length){
			return;
		}
		displayreverse(arr,vidx+1);
		System.out.println(arr[vidx]);
	}
	
	public static int max(int[] arr, int vidx){
		if(vidx==arr.length){
			return Integer.MIN_VALUE;
		}
		int m=max(arr,vidx+1);
		if(arr[vidx]>m){
			m=arr[vidx];
		}
		
		return m;
	}
	
	public static boolean find(int[] arr,int vidx,int data){
		if(vidx==arr.length){
			return false;
		}
		
		boolean m = find(arr,vidx+1,data);
		if(arr[vidx]==data){
			return true;
		}
		return m;
	}
	
	public static int firstindex(int[] arr,int vidx,int data){
		if(vidx==arr.length){
			return -1;
		}
		if(arr[vidx]==data){
			return vidx;
		}
		int m = firstindex(arr,vidx+1,data);
		return m;
		
	}
	
	public static int lastindex(int[] arr,int vidx,int data)
	{
		if(vidx==-1){
			return -1;
		 }
		if(arr[vidx]==data){
			return vidx;
		}
		int m = lastindex(arr,vidx-1,data);
		return m;
		
	}
	
	public static int[] allindices(int[] arr,int vidx,int data,int csf){
		if(vidx==arr.length){
			int[] ff = new int[csf];
			return ff;
		}
		if(arr[vidx]==data){
			int[] rr=allindices(arr,vidx+1,data,csf+1);
			rr[csf]=vidx;
			return rr;
		}else{
			int[] rr=allindices(arr,vidx+1,data,csf);
			return rr;
		}
	}
	
	public static boolean palindrome(String s,int sidx,int lidx){
		if(sidx>=lidx){
			return true;
		}
		if(s.charAt(sidx)!=s.charAt(lidx)){
			return false;
		}
		return palindrome(s,sidx+1,lidx-1);
	}
   
	public static void invertedtriangle(int row,int col,int n){
    	if(row>n){
    		return;
    	}
    	if(col>n){
    		invertedtriangle(row+1,col+1,n);
    		System.out.println();
    		return;
    	}
    	System.out.print("*");
    	invertedtriangle(row,col+1,n);
    }
}
