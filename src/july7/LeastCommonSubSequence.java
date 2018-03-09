package july7;

public class LeastCommonSubSequence {

	public static void main(String[] args) {
		String str1 = "abefg";
		String str2 = "abefg";
		
//		System.out.println(lcs(str1,str2));

//		System.out.println(lcdI(str1,str2));
		
		System.out.println(lcsSW(str1,str2));
	}
	
	public static int lcdI(String str1,String str2){
		int[][] arr = new int[str1.length()+1][str2.length()+1];
		
		for(int i = str1.length()-1;i>=0;i--){
			char ch1 = str1.charAt(i);
			for(int j = str2.length()-1;j>=0;j--){
				char ch2 = str2.charAt(j);
				if(ch1==ch2){
					arr[i][j]=arr[i+1][j+1]+1;
				}
				else{
					arr[i][j] = Math.max(arr[i+1][j], arr[i][j+1]);
				}
			}
		}
		
		return arr[0][0];
	}
	
	public static int lcs(String str1,String str2){
		
		if(str1.length()==0 || str2.length()==0){
			return 0;
		}
		
		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);
		
		String ros1,ros2;
		ros1 = str1.substring(1);
	    ros2 = str2.substring(1);
	    
		if(ch1==ch2){
			return 1 + lcs(ros1,ros2);
		}
		
			int x = lcs(ros1,str2);
			int y = lcs(str1,ros2);
			return Math.max(x, y);
		
		
		
		
	}

	public static int lcsSW(String str1,String str2){
		int[] arr = new int[str2.length()+1];
		
		for(int i = str2.length()-1;i>=0;i--){
			char ch1 = str2.charAt(i);
			for(int j = str1.length()-1;j>=0;j--){
				int temp = arr[j];
				char ch2 = str1.charAt(j);
				if (ch1 == ch2){
					arr[j]= temp +1;
				}
				else{
					arr[j] = Math.max(arr[j],arr[j+1]);
				}
				
			}
		}
		
		return arr[0];
	}

	
}
