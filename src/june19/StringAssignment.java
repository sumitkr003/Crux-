package june19;

import java.util.Scanner;

public class StringAssignment {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		if(s.equals("   ")){
			char ch =' ';
			System.out.print(ch+"a");
		}
			
		frequency(s);

	}
	
	public static void frequency(String s){
		StringBuilder sb = new StringBuilder("");
		int max=0,temp;
		char k=s.charAt(0);
		for(int i=0;i<s.length();i++){
			temp=0;
			for(int j=i+1;j<s.length();j++){
				if(s.charAt(i)==s.charAt(j)){
					temp++;
					k=s.charAt(j);
				}
				
				if(temp>max){
					max=temp;
					sb.append(k);
				}
			}
		}
		 max++;
		 if(sb.length()==0){
		     String a =" ";
		     k =32;
		   System.out.print(k);  
		 }
		 else{
		      String a=sb.substring(sb.length()-1,sb.length());
		      System.out.print(a);

		 }
	}

}
