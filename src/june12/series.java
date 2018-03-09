package june12;

import java.util.Scanner;

public class series {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
                        
		int j=1;
		for(int i=1;i<=n1;i++){
			if((3*j+2)%n2==0){
				j++;
				i--;
				continue;
			}
			else{
				System.out.println((3*j+2));
				j++;
				
			}
		}

	}

}
