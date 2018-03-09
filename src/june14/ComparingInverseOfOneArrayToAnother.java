package june14;

import java.util.Scanner;

public class ComparingInverseOfOneArrayToAnother {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];
		int[] invarr = new int [arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			invarr[i] = scn.nextInt();
		}
		
		boolean b;
		b = ComparingInverseOfOneArrayToAnother(arr,invarr);
		System.out.println(b);


	}
	public static boolean ComparingInverseOfOneArrayToAnother(int[] arr,int [] invarr){
		
		int[] temp=new int[invarr.length];
		for(int i=0;i<=arr.length-1;i++){
			
			temp[(invarr[i])]=i;
		}
		for(int i=0;i<arr.length;i++){
			if(temp[i]!=arr[i]){
				return false;
			}
		}
		return true;
	}

}
