package june19;

import java.util.Scanner;

public class RemovingDuplicates {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		System.out.println(removeduplicates(s));
		System.out.println(compression(s));
		System.out.println(toggle(s));

	}
	public static String removeduplicates(String s){
		StringBuilder sb = new StringBuilder("");
		sb.append(s.charAt(0));
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==s.charAt(i-1)){
				continue;
			}
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	public static String compression(String s){
		StringBuilder sb = new StringBuilder("");
		sb.append(s.charAt(0));
		int i,count;
		for(i=1,count = 1;i<s.length();i++){
			
			if(s.charAt(i)!=s.charAt(i-1)){
				
				
				if(count!=1){
					sb.append(count);	
				}
				sb.append(s.charAt(i));
				count =1;
			}
			else if(s.charAt(i)==s.charAt(i-1)){
				count ++;
			}
		}
		if(count!=1){
			sb.append(count);
		}
		return sb.toString();
	}
	
	public static String toggle(String s){
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch>='a' && ch<='z'){
				sb.append((char)('A'-'a'+ch));
			}
			else if (ch>='A' && ch<='Z'){
				sb.append((char)('a'-'A'+ch));
			}
			
		}
		return sb.toString();
	}

}
