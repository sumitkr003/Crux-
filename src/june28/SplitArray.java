package june28;

public class SplitArray {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};
		subset(arr,0,"","",0,0);

	}
	public static void subset(int[] arr,int idx,String s1,String s2,int sum1,int sum2){
		if(idx==arr.length){
			if(sum1==sum2){
				System.out.println(s1+" = "+s2);
			}
			return;
		}
		
		subset(arr,idx+1,s1,s2+" "+arr[idx],sum1,sum2+arr[idx]);
		subset(arr,idx+1,s1+" "+arr[idx],s2,sum1+arr[idx],sum2);
		
		
	//	return;
	}

}
