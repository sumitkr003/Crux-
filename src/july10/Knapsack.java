package july10;

public class Knapsack {

	public static void main(String[] args) {
		int[] price = {10,15,20,5,8};
		int[] weight = {20,15,15,5,8};
		int bag = 50;
		
		System.out.println(knapsack(price,weight,bag,0,0));

	}
	
	public static int knapsack(int[] price,int[] weight,int bag, int wsf,int idx){
		if(idx==weight.length){
			return 0;
		}
		if(wsf == bag){
			System.out.println();
		}
		
		int psf=0,ps=0;
		psf = knapsack(price,weight,bag,wsf,idx+1);
		if(wsf+weight[idx]<=bag){
			 ps = knapsack(price,weight,bag,wsf+weight[idx],idx+1);
		}
		
		return Math.max(psf, ps);
	}

}
