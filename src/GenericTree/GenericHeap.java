package GenericTree;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericHeap<T>{
	private ArrayList<T> data = new ArrayList<>();
	Comparator cmp;
	
	public GenericHeap (Comparator min){ 
		this.cmp = min;
	}
	
	public GenericHeap(boolean ismin,T[] arr){
		for(int i =0;i<arr.length;i++){
		   data.add(arr[i]);
		}
		
		for(int i = arr.length/2 -1;i>=0;i--){
			downheapify(i);
		}
	}
	
	public int size(){
		return data.size();
	}
	
	public boolean isempty(){
		return data.isEmpty();
	}
	
	public void display(){
		System.out.println(data);
	}
	
	public void add(T value){
		data.add(value);
		upheapify(data.size()-1);
	}
	
	private void upheapify(int ci){
		if(ci <= 0){
			return;
		}
		
		int pi = (ci -1)/2;
		if(islarger(pi,ci) == false){
			swap(pi,ci);
			upheapify(pi);
		}
	}
	
	private void swap(int i,int j){
		T ith = data.get(i);
		T jth = data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
		
	}
	
	public boolean islarger(int i,int j){
		T ith = data.get(i);
		T jth = data.get(j);
		
		if(cmp.compare(ith, jth)>0){
			return true;
		}else{
			return false;
		}
	}
	
	public T getHP(){
		return data.get(0);
	}
	
	public T removeHP(){
		swap(0,data.size()-1);
		T rv = data.remove(data.size()-1);
		
		downheapify(0);
		
		return rv;
	}
	
	private void downheapify(int pi){
		if(pi<0){
			return;
		}
		
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		
		int max = pi;
		
		if(lci < data.size() && islarger(max,lci) == false){
			max = lci;
		}
		
		if (rci < data.size() && islarger(max,rci) == false){
			max = rci;
		}
		
		if(max!=pi){
			swap(pi,max);
			downheapify(max);
		}
	}
	
	public void updatepriority(T value){
		int idx = -1;
		for(int i = 0;i<this.data.size();i++){
			if(data.get(i) == value){
				idx = i;
			}
		}
		
		if(idx!=-1){
			upheapify(idx);
			downheapify(idx);
		}
	}


}
