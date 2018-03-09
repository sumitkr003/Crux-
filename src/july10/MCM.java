package july10;

public class MCM {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60};
		int[][] storage = new int[arr.length-1][arr.length];
		 System.out.println(totalcost(arr,0,arr.length-1,storage));
//		 System.out.println(cost(arr,0,arr.length-1));

	}
//	public static int totalcost(int[] arr,int si,int ei){
//		int[] temp = new int[5];
//		for(int i = 0;i<arr.length;i++){
//			int s1 = cost(arr,0,i+1);
//			int s2 = cost(arr,i+1,arr.length-1);
//			int ts = s1 * s2 * arr[0] * arr[i+1];
//			temp[i] = ts;
//		}
//		
//		int min =temp[0],max;
//		for(int i =1;i<temp.length;i++){
//			max = arr[i];
//			if(max<min){
//				min = max;
//			}
//		}
//		return min;
//	}
//	public static int cost(int[] arr,int si,int ei){
//		if(ei-si<=2){
//			if(ei==1){
//				return 1;
//			}
//			if(ei-si==1){
//				return arr[si]*arr[si+1];
//			}
//			return arr[si]*arr[si+1]*arr[si+2];
//		}
//		return arr[si]*arr[si+1]*arr[si+3] + cost(arr,si+1,ei);
//		
//	}

	public static int totalcost(int[] arr,int si,int ei,int[][] storage){
		if(ei-si==1){
			return 0;
		}
		int min = Integer.MAX_VALUE;
		if(storage[si][ei]!=0){
			return storage[si][ei];
		}
		for(int i = si+1;i<ei;i++){
			int s1 = totalcost(arr,si,i,storage);
			int s2 = totalcost(arr,i,ei,storage);
			int rcm = arr[si] * arr[ei] * arr[i];
			int tc = s1 + s2 + rcm;
			
			if(tc<min){
				min = tc;
			}
		}
		storage[si][ei] = min;
		return min;
	}
}
