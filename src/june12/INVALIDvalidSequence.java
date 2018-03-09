package june12;

import java.util.Scanner;

public class INVALIDvalidSequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++){
			arr[i] = scn.nextInt();
		}
		int temp,i=1;
		temp=arr[0];
		while(temp>arr[i]){
			temp=arr[i];
			i++;
			if(i==n){
				System.out.println("true");
				return;
			}
		}
		temp=arr[i];
		i++;
		while(temp<arr[i]){
			temp=arr[i];
			i++;
			if(i==n){
				System.out.println("true");
				return;
			}
		}
		
		System.out.println("false");
		

	}

}
