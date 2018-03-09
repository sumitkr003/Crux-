package june16;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = scn.nextInt();
		}
		
		selectionsort(arr,0,0);
		
		for(int val:arr){
			System.out.println(val);
		}

	}
	public static int[] selectionsort(int[] arr,int idx,int i){
		if(idx == arr.length){
			return arr;
		}
		if(idx==0){
			for(i=0;i<arr.length-1;i++){
				idx=i+1;
				if(arr[i]>arr[idx]){
					int temp = arr[idx];
					arr[idx] = arr[i];
					arr[i] = temp;
				}
				selectionsort(arr,idx,i);
			}
		}
		else{
			if(arr[i]>arr[idx]){
				int temp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = temp;
			}
			arr=selectionsort(arr,idx+1,i);
		}
		return arr;
	}

}
