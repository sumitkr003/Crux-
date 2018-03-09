package Graph;

public class Client {

	public static void main(String[] args) {
		Graph gp = new Graph();
		
		gp.addvertex("A");
		gp.addvertex("B");
		gp.addvertex("C");
		gp.addvertex("D");
		gp.addvertex("E");
		gp.addvertex("F");
		gp.addvertex("G");
		
		gp.addedge("A", "B", 10);
		gp.addedge("A", "D", 40);
		gp.addedge("B", "C", 10);
		gp.addedge("C", "D", 10);
		gp.addedge("D", "E", 2);
		gp.addedge("E", "F", 3);
		gp.addedge("F", "G", 3);
		gp.addedge("E", "G", 8);
		
		gp.display();
		System.out.println("---------------------------------");
		
		System.out.println(gp.djikstra("A"));
		System.out.println("---------------------------------");
		
		gp.primises().display();
		System.out.println("---------------------------------");
		
//		System.out.println(gp.haspath("A", "G"));
//		gp.removevertex("G");
//		System.out.println(gp.haspath("A", "G"));
		
//		gp.printallpath("A", "G");
//		
//		System.out.println(gp.bfs("A", "G"));
//		gp.removevertex("G");
//		System.out.println(gp.bfs("A", "G"));
		
//		System.out.println(gp.containsedge("A", "B"));
		
//		System.out.println(gp.dfs("A", "G"));
//		
//		gp.bft();
//		gp.dft();
		
//		System.out.println(gp.gcc());
		
	}

}
