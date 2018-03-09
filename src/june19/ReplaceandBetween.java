package june19;

import java.util.Scanner;

public class ReplaceandBetween {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		System.out.println(replace(s));
//		System.out.println(asciidifference(s));

	}
	public static String replace(String s){
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<s.length();i++){
			if(i%2==0){
				sb.append((char)(s.charAt(i)+1));
			}
			else{
				sb.append((char)(s.charAt(i)-1));
			}
		}
		return sb.toString();
	}
	
	public static String asciidifference(String s){
		StringBuilder sb = new StringBuilder("");
		  sb.append(s.charAt(0));
		for(int i=1;i<s.length();i++){
			int j= s.charAt(i)-s.charAt(i-1);
			sb.append(j);
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
