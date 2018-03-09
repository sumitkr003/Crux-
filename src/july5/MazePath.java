package july5;

public class MazePath {

	public static void main(String[] args) {
		int row = 3;
		int col = 3;
		int maze[][] = new int[row+2][col+2];
		
		System.out.println(mazepathI(row,col,maze));
	}
	
	public static int mazepathI(int row,int col,int[][] maze){
		maze[row][col] = 1;
		
		for(int i = row;i>=0;i--){
			for(int j = col;j>=0;j--){
				maze[i][j]+= maze[i+1][j] + maze[i][j+1];
			}
		}
		
		return maze[0][0];
	}

}
