package BinaryTree;

public class Client {

	public static void main(String[] args) {
//		50 true 25 true 12 false false true 37 true 30 false false true 40 false false true 75 true 62 true 60 false false true 70 false false true 87 false false
		BinaryTree bt = new BinaryTree();
		
//		bt.display();
//		
//        System.out.println(bt.height());
//        
//        System.out.println(bt.max());
 
//        System.out.println(bt.isbalanced());
		
//		System.out.println(bt.bst());
//		
//		bt.preorderiterative();
//		System.out.println();
//		
//		bt.postorderI();
//		System.out.println();
//		
//		bt.inorderI();
//		System.out.println();
//		
//		bt.levelorderI();
//		System.out.println();
		
		
		
        
//        50 true 25 true 12 false false true 137 false true  65 false false true 75 true 65 false false true 100 false true 99 false false

//		50 true 25 true 10 false false true 75
		
//		System.out.println("---------------------------------");
//		bt.removeleaves();
//		bt.display();
		
//		bt.withoutsiblings();
//		bt.display();
//		
		
		BinaryTree bt1 = new BinaryTree();
		// 10 true 5 true 7 false false true 6 false false true 8 true 3 false false true 2 false false
		// 10 true 8 true 2 false false true 3 false false true 5 true 6 false false true 7 false false 
		bt.display();
		bt1.display();
		
		
		bt.ismirror(bt1);
		
	}

}
