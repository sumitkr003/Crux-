package GenericTree;

public class Client {

	public static void main(String[] args) {
		GenericTree gt = new GenericTree();
		gt.display();
		
		System.out.println("-----------------------------");
		
//		10 3 20 2 50 0 60 0 30 3 70 2 110 0 120 0 80 0 90 2 140 0 150 0 40 1 100 0 

//		System.out.println(gt.size());
//		
//		System.out.println(gt.max());
//		
//		System.out.println(gt.height());
//		
//		System.out.println(gt.find(140));
		
//		gt.mirror();
//		gt.display();
		
//		gt.preorder();
//		gt.postorder();
		
//		System.out.println("---------------------------------------------");
//		gt.levelorder();
//		
//		System.out.println("---------------------------------------------");
//		gt.levelorderlw();
//		
//		gt.multisolver(80);
		
//		gt.ques(80);

//		System.out.println(gt.kthsmallest(3));
		
//		gt.removeleaf();
//		gt.display();
		
		gt.linearize2();
		gt.display();
		
		
		
		
		
	}

}
