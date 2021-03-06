package june14;

import java.util.Scanner;

public class SumOf2Arrays {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int m = scn.nextInt();
		int[] arr1 = new int[m];

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = scn.nextInt();
		}
		System.out.println("enter length of another array");
		int n = scn.nextInt();
		int[] arr2 = new int[n];

		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = scn.nextInt();
		}
		int[] sum;
		int p,i;
		if(arr1.length>=arr2.length){
			p=arr2.length;
			sum = new int[arr1.length+1];
		}
		else{
			 p= arr1.length;
			 sum = new int[arr2.length+1];
		}

		 sum(arr1, arr2,sum,p);
		for(i=0;i<sum.length-1;i++){
			if(sum[i]!=0){
				break;
			}
		}
		while(i<sum.length){
			System.out.print(sum[i]+", ");
			i++;
		}
		System.out.print("END");
	}

	public static void sum(int[] arr1,int[] arr2,int[] sum,int p){
		
		int carry=0,i;
		
		
		for(i=0;i<sum.length;i++){
			if(i<p){
				sum[sum.length-1-i]=(carry+arr1[arr1.length-1-i]+arr2[arr2.length-1-i])%10;
				carry=(arr1[arr1.length-1-i]+arr2[arr2.length-1-i])/10;
				continue;
			}
			
			if(i>=p && i<=sum.length-2){
			    if(p==arr2.length){
			    	sum[sum.length-1-i]=(carry+arr1[arr1.length-1-i])%10;
			    	carry=(arr1[arr1.length-1-i]+carry)/10;
			    }
			    else{
			    	sum[sum.length-1-i]=(carry+arr2[arr2.length-1-i])%10;
			    	carry=(carry+arr2[arr2.length-1-i])/10;
			    }
			    continue;
			}
			else{
				sum[sum.length-1-i]=carry;
			}
				
			}
	}
}
