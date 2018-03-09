package Heap;

import java.util.ArrayList;
import java.util.Scanner;

public class Heap {
	private ArrayList<Integer> data = new ArrayList<>();
	private boolean ismin;
	
	public Heap (boolean ismin){
	}
	
	public Heap(boolean ismin,int[] arr){
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
	
	public void add(int value){
		data.add(value);
		upheapify(data.size()-1);
	}
	
	private void upheapify(int ci){
		if(ci == 0){
			return;
		}
		
		int pi = (ci -1)/2;
		if(islarger(pi,ci) == false){
			swap(pi,ci);
			upheapify(pi);
		}
	}
	
	private void swap(int i,int j){
		int ith = data.get(i);
		int jth = data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
		
	}
	
	public boolean islarger(int i,int j){
		int ith = data.get(i);
		int jth = data.get(j);
		
		if(ismin){
			if(ith<jth){
				return true;
			}else{
				return false;
			}
		}else{
			if(ith>jth){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public int getHP(){
		return data.get(0);
	}
	
	public int removeHP(){
		swap(0,data.size()-1);
		int rv = data.remove(data.size()-1);
		
		downheapify(0);
		
		return rv;
	}
	
	private void downheapify(int pi){
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

}
