package june26;

public class Permutatiion {

	public static void main(String[] args) {
		String str ="abc";
		 permutations(str,"");
		 System.out.println();
		 System.out.println("---------------------------------------------------------");
		combination("abab","");

	}
	public static void permutations(String str,String ans){
		if(str.length()==0){
			System.out.print(ans+" ");
			return;
		}
	    for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			String roq = str.substring(0,i)+str.substring(i+1);
			permutations(roq,ans+ch);
		}
		return ;
	}

	public static void combination(String str,String ans){
		if(str.length()==0){
			System.out.print(ans+" ");
			return;
		}
		boolean[] dup = new boolean[256];
		
	    for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			String roq = str.substring(0,i)+str.substring(i+1);
			if(dup[ch]==false){
				combination(roq,ans+ch);
				dup[ch]=true;
			}
			}
		return ;
	}

}
