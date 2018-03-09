package july12;

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception{
		 if(idx==this.data.length-1){
			 int[] na = this.data;
			 this.data = new int[2*idx];
			 
			 for(int i =0;i<na.length;i++){
				 data[i] = na[i];
			 }
		 }
		 
		 super.push(item);
		 
	}
}

