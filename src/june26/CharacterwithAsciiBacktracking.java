package june26;

public class CharacterwithAsciiBacktracking {

	public static void main(String[] args) {
		String str = "abc";
		ascii(str,"");

	}
	public static void ascii(String ques,String ans){
		if(ques.length()==0){
			System.out.print(ans+" ");
			return;
		}
		char ch= ques.charAt(0);
		String roq=ques.substring(1);
		ascii(roq,ans+"");
		ascii(roq,ans+ch);
		ascii(roq,ans+(int)ch);
		return ;
	}

}
