package HashMap2;

public class Client {

	public static void main(String[] args) throws Exception {
		HashMap <String,Integer> hm= new HashMap<>();
		hm.put("India",120);
		hm.put("pak",80);
		hm.put("china",180);
		hm.put("aus",20);
		hm.put("us",70);
		hm.put("us", 60);
		
		hm.display();
		System.out.println(hm.keyset());
		
		hm.put("srilanka", 20);
		hm.put("bangladesh", 10);
		hm.put("iran", 30);
		
		hm.display();
		System.out.println(hm.keyset());
		
		
		hm.put("uk", 50);
		hm.display();
		System.out.println(hm.keyset());
		
    }
}
