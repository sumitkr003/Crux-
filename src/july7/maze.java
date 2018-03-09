package july7;

import java.util.Arrays;

public class maze {

	public static void main(String[] args) {
		int row = 3,col=3;
		System.out.println(maze(row,col,new int[row+2][col+2]));

//		System.out.println(mazediagonalsw(row,col));
	}
	public static int maze(int row,int col,int[][] arr){
		
		arr[row][col] = 1;
		for(int i = row;i>=0;i--){
			for(int j = col;j>=0;j--){
				arr[i][j]+= arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1];
			}
		}
		
		return arr[0][0];
	}


	public static int mazediagonalsw(int row,int col){
		int arr[] = new int[col+2];
		Arrays.fill(arr, 1);
		arr[col]=1;
		for(int i = row-1;i>=0;i++){
			int dia = arr[i];
			arr[i] = 1;
			for(int j = col-1;j>=0;j++){
				int nv = arr[j];
			}
		}
		
	}
}
