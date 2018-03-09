package SegmentTree;

public class maxoperator implements issegmentoperator {

	@Override
	public int operation(int lsv, int rsv) {
		// TODO Auto-generated method stub
		
		return Math.max(lsv,rsv);
	}

	@Override
	public int defaultvalue() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

}
