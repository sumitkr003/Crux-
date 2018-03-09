package SegmentTree;

public class Client {

	public static void main(String[] args) {
		int[] arr = {10,2,-3,7,6,-4,8,-2};
		segmenttree st = new segmenttree(arr,new maxoperator());
		
		System.out.println(st.query(0, 2));
		
//		st.update(0, 0);
		
		st.changeoperator(new minoperator());
		
		System.out.println(st.query(0, 2));
		
		st.changeoperator(new productoperator());
		
		System.out.println(st.query(0, 1));
	}

}
