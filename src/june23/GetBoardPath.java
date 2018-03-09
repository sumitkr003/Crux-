package june23;

import java.util.ArrayList;

public class GetBoardPath {

	public static void main(String[] args) {
		System.out.println(getpath(0,10));

	}
	public static ArrayList<String> getpath(int cur,int end){
		if(cur>end){
			ArrayList<String> n = new ArrayList<>();
			return n;
		}
		if(cur==end){
			ArrayList<String> n = new ArrayList<>();
			n.add("");
			return n;
		}
		
		ArrayList<String> path = new ArrayList<>();
		
		for(int i=1;i<7;i++){
			ArrayList<String> rr = getpath(cur+i,end);
			for(String rs:rr){
				path.add(i+rs);
			}
		}
		return path;
	}

}
