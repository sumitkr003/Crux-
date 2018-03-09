package june21;

public class InverseOfarray {

	public static void main(String[] args) {
		int[] arr = {3,2,4,0,1};
		inverse(arr,0);
		for(int val:arr){
			System.out.print(val+" ");
		}

	}
	public static void inverse(int[] arr,int vidx){
		if(vidx==arr.length){
			return;
		}
		int temp = arr[vidx];
		inverse(arr,vidx+1);
		arr[temp] = vidx ;
		return;
		}

}
