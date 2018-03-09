package june12;

import java.util.Scanner;

public class PreciseSquareRoot {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		double num = scn.nextDouble();
		int p = scn.nextInt();
		
		double sqroot=squareroot(num,p);
		
		System.out.println(sqroot);

	}
	public static double squareroot(double num,int p){
		 double sqroot = Math.pow(num,0.5);
		
		 int q =(int)(sqroot*(Math.pow(10,p)));
		 double d=q/Math.pow(10, p);
		 return d;
		 
	}

}
