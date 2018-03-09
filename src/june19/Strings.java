package june19;

import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		
//		printsubstrings(s);
//		
//		System.out.println(ispalindrome(s));
		
		substringispalindome(s);

	}
	
	public static void printsubstrings(String p){
		int i,j;
		for(i=0;i<p.length();i++){
			for(j=i+1;j<=p.length();j++){
				System.out.println(p.substring(i,j));
			}
		}
	}
	
    public static boolean ispalindrome(String q){
		int i;
		for(i=0;i<q.length();i++){
			if(q.charAt(i)!=q.charAt(q.length()-1-i)){
			 return false;
			}
		}
		return true;
	}
	
    public static void substringispalindome(String r){
		int i,j,count=0,k;
		for(i=0;i<r.length();i++){
			for(j=i+1;j<=r.length();j++){
				String sub=r.substring(i,j);
				if(ispalindrome(sub)==true){
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
