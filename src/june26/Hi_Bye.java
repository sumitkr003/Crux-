package june26;

import java.util.Scanner;

public class Hi_Bye {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(hibye(str));
		
		System.out.println(removehi(str,""));
		
		System.out.println(addbye(str,""));

	}
	
    public static int hibye(String str){
		if(str.length()==1){
			return 0;
		}
		String x = str.substring(0,2);
		String ros = str.substring(1);
		int count = hibye(ros);
		if(x.equals("hi")){
			count++;
		}
		return count;
	}

    public static String removehi(String str,String s){
    	StringBuilder sb = new StringBuilder(s);
    	if(str.length()<=1){
    		sb.append(str.charAt(0));
    		return sb.toString();
    	}
    	
    	String sub = str.substring(0, 2);
    	String ros;
    	if(sub.equals("hi")){
    		ros = str.substring(2);
    		sb.append("");
    	}
    	else{
    		ros = str.substring(1);
    		sb.append(str.charAt(0));
    	}
    	if(ros.equals("")){
    		return sb.toString();
    	}
    	return removehi(ros,sb.toString());
    }

    public static String addbye(String str,String s){
    	StringBuilder sb = new StringBuilder(s);
    	if(str.length()==1){
    		sb.append(str.charAt(0));
    		return sb.toString();
    	}
    	String sub = str.substring(0, 2);
    	String ros;
    	if (sub.equals("hi")){
    		ros = str.substring(2);
    		sb.append("bye");
    	}else{
    		ros = str.substring(1);
    		sb.append(str.charAt(0));
    	}
    	
    	if(ros.length()==0){
    		return sb.toString();
    	}
    	return addbye(ros,sb.toString());
    }
}
