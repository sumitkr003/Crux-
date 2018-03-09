package june28;

public class SumOfSubsets {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};
		printtarget(arr,0,70,"",0);

	}
	public static void printtarget(int[] arr,int idx , int target , String ans,int a){
		if(idx==arr.length){
			if(a==target){
				System.out.println(ans);
			}
			return;
		}
		printtarget(arr,idx+1,target,ans,a);
		printtarget(arr,idx+1,target,ans+" "+arr[idx],a+arr[idx]);
	}

}
