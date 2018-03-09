package june19;
import java.util.Scanner;

public class PrintingPermutation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		permutation("",str);

	}
	public static void permutation(String prefix,String str){
		int n = str.length();
	    if (n == 0) 
	    	System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

}
