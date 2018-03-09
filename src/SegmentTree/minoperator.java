package SegmentTree;

public class minoperator implements issegmentoperator {

	@Override
	public int operation(int lsv, int rsv) {
		// TODO Auto-generated method stub
		return Math.min(lsv,rsv);
	}

	@Override
	public int defaultvalue() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

}
