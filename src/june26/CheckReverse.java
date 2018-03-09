package june26;

import java.util.Scanner;

public class CheckReverse {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str1 = scn.nextLine();
		String str2 = scn.nextLine();
		
		System.out.println(reverse(str1,str2));

	}
	public static boolean reverse(String str1,String str2){
		if(str1.length()!=str2.length()){
			return false;
		}
		if(str1.length()==0){
			return true;
		}
		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(str2.length()-1);
		if(ch1!=ch2){
			return false;
		}
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(0,str2.length()-1);
		boolean b =reverse(ros1,ros2);
		return b;
	}

}
