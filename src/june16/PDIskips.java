package june16;

public class PDIskips {

	public static void main(String[] args) {
		pdiskips(5);

	}
	public static void pdiskips(int n){
		if(n==0){
			return;
		}
		if(n%2!=0){
			System.out.println("hi"+ n);
		}
		pdiskips(n-1);
	  if(n%2==0){
		  System.out.println("bye"+ n);
	  }
	}

}
