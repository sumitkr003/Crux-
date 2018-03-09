package june12;

import java.util.Scanner;

public class rotate {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		
		System.out.println("enter no of rotations");
		int r=scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		r=r%n;
		int[] x=rot(arr,r);
		for (int i=0;i<x.length;i++){
			System.out.println(x[i]);
		}

	}
	public static int[] rot(int[] arr,int j){
		int[] temp=new int[arr.length];
		int i,k=arr.length-1,x=0,y=j-1;
		for(i=0;i<arr.length;i++){
			if(i<j){
				temp[y]=arr[k];
				k--;
				y--;
				}
			else{
				
				temp[i]=arr[x];
				x++;
			}
		}
		return temp;
	}

}
