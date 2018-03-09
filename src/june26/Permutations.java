package june26;

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {
        String str = "abc";
		
		System.out.print(permutations(str));
		

	}
	public static ArrayList<String> permutations(String str){
		if(str.length()==0){
			ArrayList<String> rr = new ArrayList<>();
			rr.add("");
			return rr;
		}
		ArrayList<String> rv = new ArrayList<>();
		ArrayList<String> mr = new ArrayList<>();
		char ch = str.charAt(0);
		rv = permutations(str.substring(1,str.length()));
		
		for(String rs: rv){
			for(int i=0;i<=rs.length();i++){
				if(i==0){
					mr.add(ch+""+rs.substring(0));
				}
				else{
					mr.add(rs.substring(0,i)+ch+rs.substring(i));
				}
			}
		}
		return mr;

	}

}
