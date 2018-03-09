package june26;

public class KPCusingBacktracking {

	public static void main(String[] args) {
		String str ="169";
		kpw(str,"");

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

	public static void kpw(String str,String ans){
		if(str.length()==0){
			System.out.print(ans+" ");
			return;
		}
		char ques = str.charAt(0);
		String ros = str.substring(1);
		String p = getcode(ques);
		for(int i=0;i<p.length();i++){
			kpw(ros,ans+p.charAt(i));
		}
		return;
	}
}
