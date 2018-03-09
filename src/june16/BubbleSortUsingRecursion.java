package june16;

public class BubbleSortUsingRecursion {

	public static void main(String[] args) {
		int[] arr = {55,44,33,22,11,0,-10};
		int[] x = bubblesort(arr,0,0);
		for(int val:x){
			System.out.println(val);
		}

	}
	public static int[] bubblesort(int[] arr,int idx,int i){
		if(idx==arr.length-1-i){
			return arr;
		}
		
		int[] rr = new int[arr.length];
		if(idx==0){
			for(i=0;i<arr.length-1;i++){
				if(arr[idx]>arr[idx+1]){
					int temp = arr[idx+1];
					arr[idx+1] = arr[idx];
					arr[idx] = temp;
				}
				arr = bubblesort(arr,idx+1,i);	
			}
		}
		else{
			if(arr[idx]>arr[idx+1]){
				int temp = arr[idx+1];
				arr[idx+1] = arr[idx];
				arr[idx] = temp;
			}

			arr = bubblesort(arr,idx+1,i);
		}
		return arr;
	}

}
