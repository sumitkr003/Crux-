package july12;

public class lexicographical {

	public static void main(String[] args) {
		dic(1000,1,1);

	}

	public static void dic(int num,int ans,int n){
		if(ans>num){
			return;
		}
		
		System.out.println(ans);
		  
		for(int i=1;i<=9;i++){
			if(i<=n && ans<num)
			{
				dic(num,ans*10,n);
			
			}
			if(ans<num){
				System.out.println(ans+i);
			}
		
		
		}
	}
}
