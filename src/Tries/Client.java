package Tries;

public class Client {

	public static void main(String[] args) {
		Trie dic = new Trie();
		
		dic.addword("and");
		dic.addword("ant");
		dic.addword("arc");
		dic.addword("art");
		
		dic.addword("bug");
		dic.addword("buy");
		dic.addword("bus");
		
		dic.addword("an");
		dic.addword("sea");
		dic.addword("seen");
		
		System.out.println(dic.searchword("and"));
		System.out.println(dic.searchword("an"));
		System.out.println(dic.searchword("anf"));
		System.out.println(dic.searchword("see"));
		
		dic.removeword("and");
		dic.removeword("an");
		
		System.out.println(dic.searchword("and"));
		System.out.println(dic.searchword("an"));
		
		dic.display();
		
		
		}

}
