package june26;

import java.util.Scanner;

public class RepetitiveCharacters {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(repetitive(str,""));

	}
	public static String repetitive(String str,String s){
		StringBuilder sb = new StringBuilder(s);
		if(str.length()==1){
			sb.append(str.charAt(0));
			return sb.toString();
		}
		
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(1);
		sb.append(ch1);
		if(ch1==ch2){
			sb.append("*");
		}
		String ros = str.substring(1);
	    String p= repetitive(ros,sb.toString());
	    return p;
	}

}
