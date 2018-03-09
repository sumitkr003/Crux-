package june12;
import java.util.Scanner;

public class LogUsingFunctions {

	public static void main(String[] args) {
		 
		        Scanner scn = new Scanner(System.in);
				int num = scn.nextInt();
				int b = scn.nextInt();
		        int ans=log(num,b);
		        System.out.println(ans);
		    }
		    public static int log(int num,int b){
		        int i=1;
		        while(true){
		            if((int)Math.pow(b,i)==num){
		                break;
		            }
		            i++;
		        }
		        return i;

	}

}
