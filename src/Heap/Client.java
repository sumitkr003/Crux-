package Heap;

public class Client {

	public static void main(String[] args) {
//		Heap rank = new Heap(true);
		
		int[] arr = {100,50,200,10,40,70,90};
		
		Heap rank = new Heap(true,arr);
		
//		rank.add(100);
//		rank.add(50);
//		rank.add(200);
//		rank.add(10);
//		rank.add(40);
//		rank.add(70);
//		rank.add(90);
//		
		rank.display();
		
		System.out.println(rank.removeHP());
		System.out.println(rank.removeHP());
		System.out.println(rank.removeHP());
		System.out.println(rank.removeHP());
		System.out.println(rank.removeHP());
		System.out.println(rank.removeHP());
		System.out.println(rank.removeHP());

	}

}
