package june26;

public class AllPossibleCodes {
	public static void main(String[] args) {
		String str ="1323";
		
		possiblecode(str,"");
	}
	public static void possiblecode(String str,String ans){
		if(str.length()<=1){
			if(str.length()==1){
				char ch = (char)(str.charAt(0)+'a'-'1');
				System.out.println(ans+ch);
			}
			else{
				System.out.println(ans);
			}
			return;
		}
		
		char ch = (char)(str.charAt(0) + 'a' - '1');
	
		String ros = str.substring(1);
		possiblecode(ros,ans+ch);
		
		int sub = Integer.parseInt(str.substring(0, 2));
		if(sub<=26){
			
			char c = (char)('j' - 10 + sub);
			String other = str.substring(2);
			possiblecode(other,ans+c);
		}
		
		return ;
		
	}

}
