package july12;

public class Queue {

	protected int[] data;
	protected int front;
	protected int size;
	
	public Queue(){
		this(5);
	}
	
    public Queue(int i){
    	this.data = new int[i];
    }
	
	public void enq(int value) throws Exception{
		if(this.size==data.length){
			throw new Exception("queue is full");
		}
		int tail = (this.front+this.size)%this.data.length;
		this.data[tail] = value;
		this.size++;
	}
	
	public int dq() throws Exception{
		if(this.size==0){
			throw new Exception("Queue is empty");
		}
		int rv = this.data[front];
		this.data[this.front] = 0;
		this.front = (this.front+1)%this.data.length;
		this.size--;
		return rv;
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isempty(){
		if(this.size==0){
			return true;
		}else{
			return false;
		}
	}
	
	public void display(){
		for(int i = 0;i<size;i++){
			System.out.print(this.data[(this.front+i)%this.data.length]+" ");
		}
		System.out.println("-----------------------------------------");
	}
}
