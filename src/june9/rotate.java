package june9;

import java.util.Scanner;

public class rotate {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int n = scn.nextInt();
		int temp=num;
		int digits=0;
		while(num!=0){
			digits++;
			num=num/10;
		}
		while(n<0){
			n=n+digits;
		}
		int rem;
		int pow=(int)Math.pow(10, (digits-1));
		int rot=n%digits;
		
		num=temp;
		int i=0;
		while(i<rot){
			rem=num%10;
			num=num/10;
			num=pow*rem+num;
			
			i++;
		}
		System.out.println(num);

	}

}
