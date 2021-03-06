package june26;

import java.util.Scanner;

public class SubstitutingXatLast {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(substitution(str,""));

	}
	public static String substitution(String str,String s){
		
		StringBuilder sb = new StringBuilder(s);
		if(str.length()==0){
			int i;
			for(i=0;i<sb.length() && sb.charAt(i)=='x' || sb.charAt(i)=='X';i++){
				sb.append(sb.charAt(i));
				}
			sb.delete(0,i);
			return sb.toString();
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		if(ch== 'x' || ch=='X'){
			sb.insert(0,'x');
		}else{
			sb.append(ch);
		}
		return substitution(ros,sb.toString());
		
	}

}
