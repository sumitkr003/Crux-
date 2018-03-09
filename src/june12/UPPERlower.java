package june12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UPPERlower {

	public static void main(String[] args) 
			throws IOException
	{
		char ch;
	    BufferedReader br = new
	    BufferedReader(new InputStreamReader(System.in));
	    ch = (char) br.read();
		if(ch>64 && ch<91){
            System.out.println("UPPERCASE");
        }
        else if(ch>96 && ch<123){
           System.out.println("lowercase"); 
        }
        else{
            System.out.println("invalid");
        }

	}

}
