package june12;

import java.util.Scanner;

public class arrays {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter length of array");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("enter " + i + "th element of the array");
			arr[i] = scn.nextInt();
		}
		int max=max(arr);
		System.out.println(max);
		
		int j=search(arr,10);
		System.out.println(j);
		
		reverse(arr);
		
		
		int[] x=inverse(arr);
		for(int i=0;i<arr.length-1;i++){
			System.out.print(x[i]+" ");
		}
	}

	public static int max(int[] arr) {
		int temp=arr[0];
		for(int i=0;i<arr.length;i++){
			if(temp<arr[i]){
				temp=arr[i];
			}
			
		}
		return temp;

	}

	public static int search(int[] arr,int x){
		int i;
		for (i=0;i<arr.length;i++){
			if (arr[i]==x){
				break;
			}
		}
		return i;
	}
	
	public static void reverse(int[] arr){
		int j=arr.length-1;
		int i=0;
		while (i<=j){
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
		for (i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	public static int[] inverse(int[] arr){
		int[] temp=new int[arr.length];
		int i;
		for(i=0;i<arr.length;i++){
			
			temp[arr[i]]=i;
		}
		
		for(i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
		return temp;
	}
}