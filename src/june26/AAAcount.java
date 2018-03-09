package june26;

public class AAAcount {

	public static void main(String[] args) {
		String str = "AAAddAAAA";
		overlap(str,0);
		count(str,0);

	}
	public static void overlap(String str,int count){
		if(str.length()<=3){
			if(str.equals("aaa") || str.equals("AAA")){
				count++;
			}
			System.out.println(count);
			return;
		}
		String sub = str.substring(0, 3);
		String ros;
		if(sub.equals("aaa") || sub.equals("AAA")){
			count++;
			ros = str.substring(3);
		}else{
			ros = str.substring(1);
		}
		overlap(ros,count);
		return;
		
	}
	
	public static void count(String str,int count){
		if(str.length()<=2){
			if(str.equals("aaa") || str.equals("AAA")){
				count++;
			}
			System.out.println(count);
			return;
		}
		String sub = str.substring(0, 3);
		String ros = str.substring(1);
		if(sub.equals("aaa") || sub.equals("AAA")){
			count++;
		}
		count(ros,count);
		return;
		
	}


}
