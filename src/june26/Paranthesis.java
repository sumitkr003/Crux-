package june26;

public class Paranthesis {

	public static void main(String[] args) {
		String str ="(xyza)bcdef";
		
		paran(str,"");

	}
	public static void paran(String str,String ans){
		
		if(str.length()==0){
			return;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		if(ch=='(' || ans.length()>0){
			if(ch==')'){
				System.out.println(ans.substring(1));
				return;
			}
			paran(ros,ans+ch);
		}else{
			paran(ros,ans);
		}
	}
}
