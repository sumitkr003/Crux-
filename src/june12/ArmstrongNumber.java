package june12;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		armstrongnumber(n1,n2);

	}
	public static void armstrongnumber(int n1,int n2){
		for(int i=n1;i<=n2;i++){
			int temp=i,j=0,num=0;
			while(temp!=0){
				j++;
				temp=temp/10;
			}
			temp=i;
			while(temp!=0){
				num+=(int)Math.pow(temp%10,j);
				temp=temp/10;
			}
			if (num==i){
				System.out.println(num);
			}
		}
	}

}
