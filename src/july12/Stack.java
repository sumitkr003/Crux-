package july12;

public class Stack {
	protected int[] data;
	protected int idx = -1;
	
	 Stack(int i){
		this.data = new int[i];
	}
	 
	 public Stack(){
		 this(5);
	 }
	 
	 public void push(int item) throws Exception{
		 if(idx==this.data.length){
			 throw new Exception("Stack is full");
		 }
		 this.idx++;
		 this.data[this.idx] = item;
	 }
	 
	 public int top() throws Exception {
		 if(size()==0){
			 throw new Exception("Stack is empty");
		 }
		 int val = this.data[this.idx];
		 return val;
	 }
	 
	 public int pop() throws Exception{
		 if(size()==0){
			 throw new Exception("Stack is empty");
		 }
		 int r = this.data[this.idx];
		 this.data[this.idx] = 0;
		 this.idx--;
//		 
//		 for(int i = this.idx;i>=0;i--){
//			 System.out.print(this.data[i]+" ");
//		 }
//		 
		 System.out.println("");
		 return r;
		 
	 }
	 
	 public int size(){
		 return this.idx+1;
	 }
	 
	 public boolean isempty(){
		 if(this.idx==-1){
			 return true;
		 }else{
			 return false;
		 }
	 }
	 
	 public void display(){
		 for(int i = this.idx;i>=0;i--){
			 System.out.print(this.data[i]+" ");
		 }
		 
		 System.out.println("\n -----------------------------------------");
	 }
	

}
