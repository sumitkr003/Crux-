package july5;

public class BoardPath_I {

	public static void main(String[] args) {
		int n = 10;
//		System.out.println(boardcount(n,new int[2]));
		
		System.out.println(boardcountfaster(10,new int[6]));

	}

	public static int boardcount(int end,int[] arr){
		
		arr[end] = 1;
		for(int i=end-1;i>=0;i--){
			arr[i]= arr[i+1] + arr[i+2] + arr[i+3] + arr[i+4] + arr[i+5] + arr[i+6];
		}
		
		return arr[0];
	}
	
   public static int boardcountfaster(int end,int[] arr){
		
		arr[0] = 1;
		int count=0;
		for(int i=1;i<=end;i++){
			count = arr[0] + arr[1] + arr[2] + arr[3] + arr[4] + arr[5];
			arr[5] = arr[4];
			arr[4] = arr[3];
			arr[3] = arr[2];
			arr[2] = arr[1];
			arr[1] = arr[0];
			arr[0] = count;
		}
		
		return count;
	}
}
