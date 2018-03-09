package june26;

import java.util.Scanner;

public class RemovingRepetitiveCharacter {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(repetitive(str,""));

	}
	public static String repetitive(String str,String s){
		StringBuilder sb = new StringBuilder(s);
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(1);
		if( sb.length()==0 || s.charAt(s.length()-1)!=ch1){
			sb.append(ch1);
		}
		else if(str.length()==1){
			sb.append(str.charAt(0));
			return sb.toString();
		}
		String ros;
		if(ch1==ch2){
			 ros = str.substring(2);
		}
		else{
			 ros = str.substring(1);
		}
		if(ros.equals("")){
			return sb.toString();
		}
	    String p= repetitive(ros,sb.toString());
	    return p;
	}

}
