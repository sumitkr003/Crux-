package june26;
import java.util.*;

public class KPC {

	public static void main(String[] args) {
		String str ="169";
		System.out.print(getkpw(str));

	}
	public static String getcode(char ch){
		if(ch=='1'){
			return "abc";
		}
		else if(ch=='2'){
			return "def";
		}
		else if(ch=='3'){
			return "ghi";
		}
		else if(ch=='4'){
			return "jkl";
		}
		else if(ch=='5'){
			return "mno";
		}
		else if(ch=='6'){
			return "pqrs";
		}
		else if(ch=='7'){
			return "tuv";
		}
		else if(ch=='8'){
			return "wx";
		}
		else if(ch=='9'){
			return "yz";
		}
		else {
			return ".;_";
		}
	}

	public static ArrayList<String> getkpw(String str){
		if(str.length()==0){
			ArrayList<String> rr = new ArrayList<>();
			rr.add("");
			return rr;
		}
		
		ArrayList<String> ar = new ArrayList<>();
		ArrayList<String> mr = new ArrayList<>();
		char ch = str.charAt(0);
		
		ar = getkpw(str.substring(1));
		
		for(String rs:ar){
			String s = getcode(ch);
			for(int i=0;i<s.length();i++){
				mr.add(rs+""+s.charAt(i));
			}
		}
		return mr;
		
		
		
	}
}
