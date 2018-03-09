package july12;

public class StacktoQueue {
	private DynamicStack input = new DynamicStack();
	private DynamicStack output = new DynamicStack();
	int size = 0;
	
	public void enq(int val) throws Exception{
	     this.input.push(val);
	     this.size++;
	}
	
	public int dq() throws Exception{
		if(this.input.isempty()){
			this.output.push(this.input.pop());
		}
		this.size--;
		int rv = this.output.pop();
		if(this.output.isempty()){
			this.input.push(this.output.pop());
		}
		return rv;
	}
	
	public void display() throws Exception{
		while(this.input.isempty()){
			this.output.push(this.input.pop());
		}
		while(output.isempty()){
			System.out.print(this.output.top()+" ");
			this.input.push(this.output.pop());
		}
	}

}
