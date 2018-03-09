package june16;

public class Exponent {

	public static void main(String[] args) {
		int p=power(3,5);
		System.out.println(p);
		
		long q=superiorpower(3,6);
		System.out.println(q);

	}
	public static int power(int x,int n){
		if(n==0){
			return 1;
		}
		int pow=x*power(x,n-1);
		return pow;
	}
	
	public static int superiorpower(int x,int n){
		int pow;
		if(n==0){
			return 1;
		}
		if(n%2==0){
			int p=superiorpower(x,n/2);
			pow=p*p;
		}
		else{
			int p=superiorpower(x,n/2);
			pow=x*p*p;
		}
		return pow;
	}

}
