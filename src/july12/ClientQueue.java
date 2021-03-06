package july12;

public class ClientQueue {

	public static void main(String[] args) throws Exception{
		DynamicQueue q = new DynamicQueue();
		
		q.enq(10);
		q.display();

		q.enq(20);
		q.display();
		
		q.enq(30);
		q.display();
		
		q.enq(40);
		q.display();
		
		q.enq(50);
		q.display();
		
		q.dq();
		q.display();
		
		q.dq();
		q.display();
		
		q.enq(60);
		q.display();
		
		q.enq(70);
		q.display();

		displayreverse(q,0);
		System.out.println();
		q.display();
		

		reverse(q,0);
		System.out.println();
		q.display();
		
	}

	public static void displayreverse(DynamicQueue q,int i) throws Exception{
		if(i==q.size()){
			return;
		}
		int temp = q.dq();
		q.enq(temp);
		displayreverse(q,i+1);
		System.out.print(temp +" ");
		return;
	}
	
	public static void reverse(DynamicQueue q,int i) throws Exception{
		if(q.size()==0){
			return;
		}
	       int temp = q.dq();
	       reverse(q,i+1);
	       q.enq(temp);
	       
	       return;
	       
	}
}
