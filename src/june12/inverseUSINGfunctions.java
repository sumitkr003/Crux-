package june12;

import java.util.Scanner;

public class inverseUSINGfunctions {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int inverse=inverse(num);
		System.out.println(inverse);

	}
	public static int inverse(int num){
		int rem,inverse = 0;
		int i=1;
		
		while (num!=0) {
			rem = num % 10;
			
			 inverse+=i*(int) Math.pow(10, (rem - 1));
			num = num / 10;
			i++;
		}
		return inverse;
	}

}
