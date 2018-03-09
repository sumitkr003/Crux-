package TextProcessing;

import java.util.HashMap;

public class Client {

	public static void main(String[] args) {
		HEncoder hp = new HEncoder("aaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccddddddddddd");
		System.out.println(hp.compress("aabbcd"));
		
		String str = hp.compress("aabbcd");
				
		System.out.println(hp.decompress(str));

	}

}
