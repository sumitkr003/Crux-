package june23;

public class pattern2 {

	public static void main(String[] args) {
		pattern(1,1,1,7);

	}
	public static void pattern(int row,int col,int space,int n){
		if(row>n){
			return;
		}
		if(col>2*row-1){
			System.out.println();
			pattern(row+1,1,row+1,n);
			if(row<n-1){
				System.out.println();
			}
			return;
		}
		if(space==row){
	    for(int i=row;i<n;i++){
	    	System.out.print(" ");
	    }
		}
		System.out.print("*");
		pattern(row,col+1,space+1,n);
		if(space==3*row-2 && row<=n-1){
		    for(int i=n;i>row;i--){
		    	System.out.print(" ");
		    }
		}
		if(row<=n-1){
			System.out.print("*");
		}
		return;
	}

}
