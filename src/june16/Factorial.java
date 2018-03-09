package june16;

public class Factorial {

	public static void main(String[] args) {
		int p=factorial(5);
		System.out.println(p);

	}
	public static int factorial(int n){
		if(n==0){
			return 1;
		}
		int fact=n*factorial(n-1);
		
		return fact;
	}

}
