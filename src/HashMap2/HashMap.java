package HashMap2;

import java.util.ArrayList;

public class HashMap<K, V> {
	private class hmnode {
		K key;
		V value;
	}

	LinkedList<hmnode>[] buckets = new LinkedList[5];
	int size = 0;

	public HashMap() {

		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList();
		}

		size = 0;
	}

	public void put(K key, V value) throws Exception {
		int hc = hashfunction(key);
		LinkedList ll = buckets[hc];
		int foundat = foundat(key, ll);

		if (foundat == -1) {
			hmnode n2add = new hmnode();
			n2add.key = key;
			n2add.value = value;
			buckets[hc].addlast(n2add);
			this.size++;
		} else {
			hmnode n2update = buckets[hc].getatindex(foundat);
			n2update.value = value;
		} 
		
		double lambda = (this.size*1.0)/buckets.length;
		if(lambda>2){
			rehashing();
		}
	}

	private void rehashing() throws Exception{
		LinkedList<hmnode>[] ll = buckets;
		
		LinkedList<hmnode>[] buckets = new LinkedList[2*ll.length];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList();
		}

		size = 0;
		
		for(int i = 0;i<ll.length;i++){
			for(int j = 0;j<ll[i].size;j++){
				hmnode node = ll[i].getatindex(j);
				put(node.key,node.value);
			}
		}
	}

	public V get(K key) throws Exception {
		int hc = hashfunction(key);
		LinkedList ll = buckets[hc];
		int foundat = foundat(key, ll);

		if (foundat == -1) {
			return null;
		} else {
			hmnode n2update = buckets[hc].getatindex(foundat);
			return n2update.value;
		}
	}

	public V remove(K key) throws Exception {
		int hc = hashfunction(key);
		LinkedList ll = buckets[hc];
		int foundat = foundat(key, ll);

		if (foundat == -1) {
			return null;
		} else {
			hmnode n2update = buckets[hc].removeat(foundat);
			this.size--;
			return n2update.value;
		}
	}

	public boolean containskey(K key) throws Exception {
		int hc = hashfunction(key);
		LinkedList ll = buckets[hc];
		int foundat = foundat(key, ll);

		if (foundat == -1) {
			return false;
		} else {
			return true;
		}
	}

	private int hashfunction(K key) {
		int hc = key.hashCode();

		hc = Math.abs(hc);
		hc = hc % buckets.length;

		return hc;
	}

	private int foundat(K key, LinkedList<hmnode> ll) throws Exception {

		for (int i = 0; i < ll.size; i++) {
			hmnode match = ll.getatindex(i);
			if (match.key.equals(key)) {
				return i;
			}
		}

		return -1;
	}
	
	public void display() throws Exception{
		for(int i = 0;i<buckets.length;i++){
			LinkedList<hmnode> ll = buckets[i];
			for(int j = 0;j<ll.size;j++){
				hmnode node = ll.getatindex(j);
				System.out.println(node.key + " "+ node.value);
			}
		}
	}
	
	public ArrayList<K> keyset() throws Exception{
		ArrayList<K> al = new ArrayList<>();
		for(int i = 0;i<buckets.length;i++){
			LinkedList<hmnode> ll = buckets[i];
			for(int j = 0;j<ll.size;j++){
				hmnode node = ll.getatindex(j);
				al.add(node.key);
			}
		}
		
		return al;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
