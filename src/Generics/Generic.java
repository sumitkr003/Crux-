package Generics;

import java.util.Comparator;

public class Generic implements Comparable<Generic> {
	private String name;
	private int speed;
	private int price;
	public static final Comparator<Generic> speedcpt = new speedcomparator();
	public static final Comparator<Generic> speedrevcpt = new speedrevcomparator();
	public static final Comparator<Generic> pricecpt = new pricecomparator();
	public static final Comparator<Generic> pricerevcpt = new pricerevcomparator();
	public static final Comparator<Generic> namecpt = new namecomparator();
	public static final Comparator<Generic> namerevcpt= new namerevcomparator();
	
	public Generic(String name,int speed,int price){
		this.name = name;
		this.speed = speed;
		this.price = price;
	}

	@Override
	public int compareTo(Generic o) {
		return this.price - o.price;
	}
	
	@Override
	public String toString(){
		String str = this.name + " " + this.speed + " " + this.price;
		return str;
	}
	
	public static class speedcomparator implements Comparator<Generic> {

		@Override
		public int compare(Generic o1, Generic o2) {
			return o1.speed - o2.speed;
		}
		
	}
	
	public static class speedrevcomparator implements Comparator<Generic> {

		@Override
		public int compare(Generic o1, Generic o2) {
			return o2.speed - o1.speed;
		}
		
	}
	
	public static class pricecomparator implements Comparator<Generic> {

		@Override
		public int compare(Generic o1, Generic o2) {
			return o1.price - o2.price;
		}
		
	}
	
	public static class pricerevcomparator implements Comparator<Generic> {

		@Override
		public int compare(Generic o1, Generic o2) {
			return o2.price - o1.price;
		}
		
	}
	
	public static class namecomparator implements Comparator<Generic> {

		@Override
		public int compare(Generic o1, Generic o2) {
			return o1.compareTo(o2);
		}
		
	}
	
	public static class namerevcomparator implements Comparator<Generic> {

		@Override
		public int compare(Generic o1, Generic o2) {
			return o2.compareTo(o1);
		}
		
	}
	
	
}
