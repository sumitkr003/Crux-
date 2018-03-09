package july5;

import java.util.Arrays;

public class MazePathUsingDp {

	public static void main(String[] args) {
		int row = 3;
		int col = 3;
		int[][] arr = new int[row+1][col+1];
		System.out.println(mazepath(row,col,0,0,arr));

//		System.out.println(mazepathsw(row,col));
	}
	
	public static int mazepath(int row,int col,int cr,int cc,int[][] arr){
		if(cr==row && cc ==col){
			return 1;
		}
		
		else if(cr>row || cc>col){
			return 0;
		}
		
		if(arr[cr][cc]!=0){
			return arr[cr][cc];
		}
		
		int ch=mazepath(row,col,cr,cc+1,arr);
		int cv = mazepath(row,col,cr+1,cc,arr);
		int count = ch+cv;
		
		arr[cr][cc]=count;
		
		return count;
	}
	


	public static int mazepathsw(int row,int col){
		int arr[] = new int[col+1];
		Arrays.fill(arr, 1);
		int nv=0;
		for(int i = row-1;i>=0;i--){
			int temp=arr[col];
			arr[col] = 1;
			for(int j = col-1;j>=0;j--){
				 nv = arr[j] + arr[j+1] + temp;
				 temp = arr[j];
				 arr[j] = nv;
				 
				
			}
			
		}
		
		return arr[0];
	}
}
