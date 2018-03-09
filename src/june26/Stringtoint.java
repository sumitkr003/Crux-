package june26;

import java.util.Scanner;

public class Stringtoint {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
	    System.out.println(stringtoint(str));

	}
	public static int stringtoint(String str){
		if(str.length()==0){
			return 0;
		}
		char ch = str.charAt(0);
		int unit = Character.getNumericValue(ch);
		String ros = str.substring(1);
		int num= stringtoint(ros);
		num = (unit*(int)Math.pow(10,str.length()-1)) + num;
		return num;
	}

}
