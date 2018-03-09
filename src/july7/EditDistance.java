package july7;

public class EditDistance {

	public static void main(String[] args) {
	   String str1 = "abcdef";
	   String str2 = "abcefg";
	   
	   System.out.println(distance(str1,str2));

	}
	
	public static int distance(String str1,String str2){
		if(str1.length()==0){
			if (str2.length()==0){
				return 0;
			}
			return str2.length();
		}
		else if(str2.length()==0){
			return str1.length();
		}
		
		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);
		
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		
		if(ch1==ch2){
			return distance(ros1,ros2);
			 
		}
		else{
			 int x = 1 + distance(ros1,str2);     //insertion
			 int y = 1 + distance(str1,ros2);     //deletion
			 int z = 1 + distance(ros1,ros2);     //replacement
			 
			 return Math.min(x, Math.min(y, z));
//			
////			int finsert = distance(str1, ch1 + str2); // ros1, s2
////			int freplace = editDistance(s1, ch1 + ros2); // ros1, ros2
//			int finsert = 1 + distance(ros1, str2); // ros1, s2
//			int freplace = 1 + distance(ros1, ros2); // ros1, ros2
//			int fremove = 1 + distance(str1, ros2);
//			
//			int rv = Math.min(finsert, Math.min(freplace, fremove));
//			return rv;
		}
		
	}
	
//	public static int edit(String str1,String str2){
//		int count = 0;
//		for(int i =0;i<=str1.length();i++){
//			char ch1 = str1.charAt(i);
//			char ch2 = str2.charAt(i);
//			
//			String ros1 = str1.substring(i+1);
//			String ros2 = str2.substring(i+1);
//			if(str1.charAt(i)==str2.charAt(i)){
//				continue;
//			}
//			else{
//				 int x = 1 + distance(ros1,ch1+ros2);     //insertion
//				 int y = 1 + distance(str1,ros2);     //deletion
//				 int z = 1 + distance(ros1,ros2);
//				 
//				 int ans = Math.min(x, Math.min(y, z));
//			}
//		}
//	}

}
