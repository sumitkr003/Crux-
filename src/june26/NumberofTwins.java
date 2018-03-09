package june26;

public class NumberofTwins {

	public static void main(String[] args) {
		String str ="axaxa";
		System.out.println(twins(str,0));

	}
	public static int twins(String str,int count){
		if(str.length()==2){
			return count;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		if(ch == str.charAt(2)){
			count++;
		}
		return (twins(ros,count));
	}

}
