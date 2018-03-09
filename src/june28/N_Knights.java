package june28;

public class N_Knights {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		
		knights(arr,0,0,0);
	}

	public static void knights(int[][] arr,int k,int row,int col){
		if(k>=arr.length){
			for(int i=0;i<arr.length;i++){
				for(int j=0;j<arr[0].length;j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("-------------------------------------------------");
			return;
		}
		
		if(col==arr.length){
			knights(arr,k,row+1,0);
			return;
		}
		
		if(row==arr.length){
			return;
		}
		
		int i;
		for(i=col;i<arr.length;i++){
			if(isknightsafe(arr,row,i)==true){
				arr[row][i]=1;
				knights(arr,k+1,row,i+1);
				arr[row][i]=0;
			}
		}
		if(i==arr.length){
			knights(arr,k,row+1,0);
			return;
		}
		return;
	}
	
	public static boolean isknightsafe(int[][] arr,int row,int col){
		int r=row,c=col;
		r=row-2;
		c=col-1;
		if(r>=0 && c>=0 && arr[r][c]==1){
			return false;
		}
		
		
		r=row-2;
		c=col+1;
	    if( r>=0 && c<arr.length && arr[r][c]==1){
			return false;
		}
	    
	    
		r=row-1;
		c=col-2;
	    if(r>=0 && c>=0 && arr[r][c]==1){
			return false;
		}
	    
	    
		r=row-1;
		c=col+2;
	    if( r>=0 && c<arr.length && arr[r][c]==1){
			return false;
		}
	    
	    
		r=row+1;
		c=col-2;
		if(r>arr.length && c>=0 && arr[r][c]==1){
			return false;
		}
		
		
		r=row+1;
		c=col+2;
		if(r<arr.length && c<arr.length){
		if(arr[r][c]==1){
			return false;
		}
		}
		
		r=row+2;
		c=col-1;
		if( r<arr.length && c>=0 && arr[r][c]==1){
			return false;
		}
		
		r=row+2;
		c=col+1;
		if(r<arr.length && c<arr.length && arr[r][c]==1){
			return false;
		}
		
		return true;
	}
	}
