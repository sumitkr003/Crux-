package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class HahsMap {

	public static void main(String[] args) {
//		characterfrequency("abrakadabra");
		
		int[] arr = {2,12,9,16,10,5,3,20,35,11,1,8,6};
		consecutive(arr);

	}

	public static void characterfrequency(String str) {
		HashMap<Character, Integer> fre = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			if (fre.containsKey(str.charAt(i))) {
				fre.put(str.charAt(i), fre.get(str.charAt(i)) + 1);
			} else {
				fre.put(str.charAt(i), 1);
			}
		}

		ArrayList<Character> arr = new ArrayList<>(fre.keySet());
		int max = Integer.MIN_VALUE;
		char chr = ' ';

		for (int i = 0; i < arr.size() - 1; i++) {
			char ch = arr.get(i);
			int x = fre.get(ch);

			if (x > max) {
				max = x;
				chr = ch;
			}
		}

		System.out.println(chr + "=>" + max);
	}

	public static ArrayList<Integer> gce1(int[] one, int[] two) {
		HashMap<Integer, Integer> hp = new HashMap<>();

		for (int i = 0; i < one.length; i++) {
			if (hp.containsKey(one[i])) {
				int val = hp.get(one[i]);
				hp.put(one[i], val + 1);
			} else {
				hp.put(one[i], 1);
			}
		}

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < two.length; i++) {
			if (hp.containsKey(two[i])) {
				al.add(two[i]);
				int val = hp.get(two[i]);
				if (val == 1) {
					hp.remove(two[i]);
				} else {
					hp.put(two[i], val - 1);
				}
			}
		}

		return al;
	}
	
	public static ArrayList<Integer> gce2(int[] one, int[] two) {
		HashMap<Integer, Integer> hp = new HashMap<>();

		for (int i = 0; i < one.length; i++) {
			if (hp.containsKey(one[i])) {
				int val = hp.get(one[i]);
				hp.put(one[i], val + 1);
			} else {
				hp.put(one[i], 1);
			}
		}

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < two.length; i++) {
			if (hp.containsKey(two[i])) {
				al.add(two[i]);
				hp.remove(two[i]);
			}
		}

		return al;
	}

	public static void consecutive(int[] arr){
		
		HashMap<Integer,Boolean> hp = new HashMap<>();
		
		for(int val:arr){
			hp.put(val,true);
		}
		
		for(int val:arr){
			if(hp.containsKey(val - 1)){
				hp.put(val, false);
			}
		}
		
		int max =0;
		int maxf = 0;
		
		for(int val:arr){
			int count = 0;
			while(hp.containsKey(val + count) == true){
				count++;
			}
			
			if(count>maxf){
				maxf = count;
				max = val;
			}
		}
		
		for(int i = 0;i<maxf;i++){
			System.out.print(max + i +" ");
		}
		
		
	}
}
