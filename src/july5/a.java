package july5;

import java.util.Arrays;

public class a {

	public static void main(String[] args) {
	   System.out.println(mazepathsw(3,3));

	}

	public static int mazepathsw(int row,int col){
		int arr[] = new int[col+1];
		Arrays.fill(arr, 1);
		int nv=0;
		for(int i = row-1;i>=0;i--){
			arr[col] = 1;
			for(int j = col-1;j>=0;j--){
				 nv = arr[j] + arr[j+1];
				 arr[j] = nv;
				
			}
		}
		
		return nv;
	}
}
