package BinaryTree;

public class BstClient {

	public static void main(String[] args) {
		int[] post = {12,30,40,37,25,62,87,75,50};
		int[] in = {12,25,30,37,40,50,62,75,87};
		
//		BST b = new BST(post,in);
//		
//		System.out.println(b.min());
//		
//		System.out.println(b.max());
//		
//		System.out.println(b.isfound(40));
//		
//		b.add(60);
//		b.add(63);
//	    b.display();
	    
		
	    int[] sa ={10,20,30,40,50,60,70,80,90,100,110};
	    BST bs = new BST(sa);
//	    bs.display();
//	    
//	    bs.removeoneleaf(50);
//	    bs.display(); 
	    
	    bs.display();
	    System.out.println("--------------------------------");
	    bs.remove(90);
	    bs.display();
	    
//	    bs.removeoneleaf();
	    
//	    bs.repleaceSWL();
//	    bs.display();
//	    
//	    System.out.println("--------------------------------------");
//	    bs.display();
	    System.out.println("--------------------------------------");
	    bs.pir(40,100);
	    
	    
	    
	    

	}

}
