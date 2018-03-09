package Generics;

import java.util.Comparator;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Generic car[] = new Generic[5];
		car[0] = new Generic("Audi",100,1000);
		car[1] = new Generic("Bmw",180,1200);
		car[2] = new Generic("Aventador",300,2000);
		car[3] = new Generic("porsche",80,1800);
		car[4] = new Generic("merc",150,1400);
		
		Scanner scn = new Scanner(System.in);
		System.out.println("enter 1 for name comparison,2 for speed comparison,3 for price comparison");
		int d = scn.nextInt();
		
		System.out.println("Enter true or false");
		boolean b = scn.nextBoolean();
		
		if(d == 1 && b){
			bubblesort(car,car.speedcpt);
		}
		else if(d == 1 && !b){
			
		}
		display(car);
	}
	
	public static <T> void display(T[] arr){
		for(T val:arr){
			System.out.println(val + " ");
		}
	}
	
	public static <T extends Comparator<T>> void bubblesort(T[] arr,Comparator<T> speedcomparator){
		int count = 0;
		
		while(count<arr.length){
			for(int i =0;i<arr.length - count - 1;i++){
				if(compare(arr[i],arr[i+1])>0){
					T temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			count++;
		}
	}

}
