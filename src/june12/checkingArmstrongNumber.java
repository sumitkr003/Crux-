package june12;

import java.util.Scanner;

public class checkingArmstrongNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		boolean b=armstrongnumber(n1);
		System.out.println(b);

	}
	public static boolean armstrongnumber(int n1){
		int temp=n1,num=0,i=0;
		boolean b;
		while(temp!=0){
			i++;
			temp=temp/10;
		}
		while(temp!=0){
			num+=(int)Math.pow(temp%10, i);
			temp=temp/10;
		}
		if (num==n1){
			b=true;
		}
		else {
			b=false;
		}
		return b;
	}

}
