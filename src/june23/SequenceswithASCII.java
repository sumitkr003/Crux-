package june23;
import java.util.*;

public class SequenceswithASCII {

	public static void main(String[] args) {
		String str = "abc";
		System.out.println(printsequence(str));

	}
	
	public static ArrayList<String> printsequence(String str){
		if (str.length()==0){
			ArrayList<String> rr = new ArrayList<>();
			rr.add("");
			return rr;
		}
		
		char ch = str.charAt(0);
		int i =ch;
		String ros = str.substring(1);
		
		ArrayList<String> rr = printsequence(ros);
		ArrayList<String> mr = new ArrayList<>();
		
		for(String rs:rr){
			mr.add(rs);
			mr.add(ch + rs);
			mr.add(i+rs);
			
		}
		return mr;
	}

}
