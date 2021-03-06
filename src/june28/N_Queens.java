package june28;

public class N_Queens {

	public static void main(String[] args) {
		int[][] arr = new int[8][8];
		queens(arr,0);
	}
	public static void queens(int[][] arr,int q){
		if(q==arr.length){
			for(int i=0;i<arr.length;i++){
				for(int j=0;j<arr[0].length;j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("-----------------------------------------------------------");
			return;
		}
		for(int i=0;i<arr.length;i++){
			if(isqueensafe(arr,q,i)==true){
				arr[q][i]=1;
				queens(arr,q+1);
				arr[q][i]=0;
			}
			
		}
		
	}
	
	public static boolean isqueensafe(int[][] arr,int row,int col){
		int r = row,c=col;
		//vertical test
		while(r>=0){
			if(arr[r][c]==1){
				return false;
			}
			r--;
		}
		r = row;
		c=col;
		//positive diagonal test
		while(r>=0 && c<arr.length){
			if(arr[r][c]==1){
				return false;
			}
			r--;
			c++;
		}
		r = row;
		c=col;
		//negative diagonal
		while(r>=0 && c>=0){
			if(arr[r][c]==1){
				return false;
			}
			r--;
			c--;
		}
		
		return true;
	}

}
