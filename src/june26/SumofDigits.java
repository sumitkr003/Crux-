package june26;

import java.util.Scanner;

public class SumofDigits {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		
		System.out.println(sumofdigits(str));

	}
	public static int sumofdigits(String str){
		if(str.length()==0){
			return 0;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		int sum = sumofdigits(ros);
		sum+=Character.getNumericValue(ch);
		return sum;
	}

}
