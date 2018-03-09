package july5;

public class Board_PathUsingDP {

	public static void main(String[] args) {
	   int n =30;
	   int[] arr = new int[n+1];
	   System.out.println(getboardpath(0,30,arr));
//	   System.out.println(getboardcount(0,30));

	}
	
	public static int getboardpath(int cur,int end,int[] arr){
		if(cur==end){
			return 1;
		}
		else if(cur>end){
			return 0;
		}
		
		if(arr[cur]!=0){
			return arr[cur];
		}
		int count = 0;
		for(int i=1;i<=6;i++){
			count+=getboardpath(cur+i,end,arr);
		}
		
		arr[cur] = count;
		return count;
	}
	
	public static int getboardcount(int cur,int end){
		if(cur==end){
			return 1;
		}
		else if(cur>end){
			return 0;
		}
		
		int count = 0;
		for(int i=1;i<=6;i++){
			count+=getboardcount(cur+i,end);
		}
		
		
		return count;
	}

}
