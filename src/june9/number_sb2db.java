package june9;

import java.util.Scanner;

public class number_sb2db {

	public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);

			int sb = scn.nextInt();
			int db = scn.nextInt();
			long num = scn.nextLong();
		
			int p=0,rem;
			long d=0;
			while(num!=0){
				rem=(int)num%10;
				d+=(long)(rem*Math.pow(sb,p));
				p++;
				num=num/10;
			}
			
			p=0;
			long ans=0;
			while(d!=0){
				rem=(int)(d%db);
				ans+=(long)(rem*Math.pow(10,p));
				p++;
				d=d/db;
			}
			System.out.println(ans);

	}

}
