package june14;

import java.util.Scanner;
import java.util.*;

public class IntersectionOf2Arrays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter length of array");
		int m = scn.nextInt();
		int[] arr1 = new int[m];
		int i,j;
		ArrayList al = new ArrayList();

		for (i = 0; i < arr1.length; i++) {
			arr1[i] = scn.nextInt();
		}
		
		
		int[] arr2 = new int[m];

		for (i = 0; i < arr2.length; i++) {
			arr2[i] = scn.nextInt();
		}
		
		int counter = 1;
		while (counter <= arr1.length - 1) {
			for (i = counter; i > 0; i--) {
				if (arr1[i] < arr1[i-1]) {
					int temp = arr1[i - 1];
					arr1[i - 1] = arr1[i];
					arr1[i] = temp;
				}
			}
			counter++;
			}
		
		
		for(i=0;i<m;i++){
			for(j=0;j<m;j++){
				if(arr1[i]==arr2[j]){
					al.add(arr2[j]);
					arr2[j]=22222;
					break;
				}
			}
		}
		System.out.print(al);

	}

}
