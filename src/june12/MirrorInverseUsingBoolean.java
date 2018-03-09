package june12;

import java.util.Scanner;

public class MirrorInverseUsingBoolean {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		
		boolean ans=mirrorinverse(num);
		System.out.println(ans);

	}
	public static boolean mirrorinverse(int num){
		int rem,temp = 0;
		int i=1;
		int q=num;
		boolean ans;
		while (num!=0) {
			rem = num % 10;
			
			temp = temp + i*((int) Math.pow(10, (rem - 1)));
			num = num / 10;
			i++;
		}
		if(temp==q){
			ans=true;
		}
		else{
			ans=false;
		}
		System.out.println(temp);
		return ans;
		
	}

}
