package july12;

public class DynamicQueue extends Queue {
	
	@Override
	public void enq(int value) throws Exception{
		if(this.size==data.length){
			int[] temp = this.data;
			this.data = new int[size*2];
			for(int i = 0;i<size;i++){
				this.data[i] = temp[(this.front+i)%temp.length];
			}
		}
		super.enq(value);
	}
}
