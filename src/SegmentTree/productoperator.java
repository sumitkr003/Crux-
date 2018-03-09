package SegmentTree;

public class productoperator implements issegmentoperator {

	@Override
	public int operation(int lsv, int rsv) {
		// TODO Auto-generated method stub
		return lsv*rsv;
	}

	@Override
	public int defaultvalue() {
		// TODO Auto-generated method stub
	    return 1;
	}

}
