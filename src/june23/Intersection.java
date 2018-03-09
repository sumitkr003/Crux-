package june23;
import java.util.*;

public class Intersection {

	public static void main(String[] args) {
    Integer[] one = {1,1,2,2,2,3,5};
    Integer[] two = {1,1,1,2,2,4,5};
    
    ArrayList<Integer> inter = getintersection(one,two);
    System.out.println(inter);

	}
	public static ArrayList<Integer> getintersection(Integer[] one,Integer[] two){
		ArrayList<Integer> list = new ArrayList<>();
		int i=0,j=0;
		while(true){
			if(i==one.length || j==two.length){
				break;
			}
			else if(one[i]==two[j]){
	    	   list.add(one[i]);
	    	   i++;
	    	   j++;
	       }
	       else if(one[i]>two[j]){
	    	   j++;
	       }
	       else if(one[i]<two[j]){
	    	   i++;
	       }
	       
		}
		return list;
	}

}
