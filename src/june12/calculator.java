package june12;

import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long n1,n2;
		do{
			char ch = scn.next().charAt(0);
			if(ch=='+'){
				n1 = scn.nextLong();
			    n2 = scn.nextLong();
				System.out.println(n1+n2);
			}
			else if(ch=='-'){
				n1 = scn.nextLong();
			    n2 = scn.nextLong();
				System.out.println(n1-n2);
			}
			else if(ch=='*'){
				n1 = scn.nextLong();
			    n2 = scn.nextLong();
				System.out.println(n1*n2);
			}
			else if(ch=='/'){
				n1 = scn.nextLong();
			    n2 = scn.nextLong();
				System.out.println(n1/n2);
			}
			else if(ch=='%'){
				n1 = scn.nextLong();
			    n2 = scn.nextLong();
				System.out.println(n1%n2);
			}
			else if(ch=='x' || ch=='X'){
				break;
			}
			else{
				System.out.println("Invalid operation. Try again.");
			}
		}while(true);
	}

}
