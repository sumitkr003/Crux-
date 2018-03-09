package SegmentTree;

public class segmenttree {
	
	private class node{
		int data;
		int si;
		int ei;
		node left;
		node right;
	}
	
	private node root;
	private int size;
	private issegmentoperator operator;
	
	public void changeoperator(issegmentoperator operator){
		this.operator = operator;
		updatetonewoperator(root);
	}
	
	private void updatetonewoperator(node node){
		if(node.si == node.ei){
			return;
		}
		
		updatetonewoperator(node.left);
		updatetonewoperator(node.right);
		
		node.data = this.operator.operation(node.left.data, node.right.data);
	}
	
	public segmenttree(int[] arr,issegmentoperator operator){
		this.operator = operator;
		this.root = construct(arr,0,arr.length-1);
	}
	
	private node construct(int[] arr,int si,int ei){
		if(si == ei){
			node temp = new node();
			temp.si = temp.ei = si;
			temp.data = arr[si];
			this.size++;
			return temp;
		}
		
		int mid = (si+ei)/2;
		node curr = new node();
		
		curr.left = construct(arr,si,mid);
		curr.right = construct(arr,mid+1,ei);
		
		curr.data = operator.operation(curr.left.data, curr.right.data);
		curr.si = si;
		curr.ei = ei;
		
		return curr;
	}

	public int query(int si,int ei){
		return query(root,si,ei);
	}
	
	private int query(node node,int si,int ei){
		if(node.si>=si && node.ei<=ei){
			return node.data;
		}else if(node.si>ei || node.ei<si){
			return operator.defaultvalue();
		}else{
			int left = query(node.left,si,ei);
			int right = query(node.right,si,ei);
			
			return this.operator.operation(left, right);
		}
	}
	
	public void update(int val,int idx){
		this.update(root, val, idx);
	}
	
	private int update(node node,int val,int idx){
		if(node.si == node.ei){
			if(node.si == idx){
				node.data = val;
			}
		    return node.data;
		}
		
		int mid = (node.si + node.ei)/2;
		int left = 0,right = 0;
		if(idx>=mid){
			 left = update(node.right,val,idx);
		}else{
			 right = update(node.left,val,idx);
		}
		
		node.data = this.operator.operation(left, right);
		return node.data;
	}
	
	public void display(){
		display(root);
	}
	
	private void display(node node){
		String str = "";
		
//		str=node.data +"[" + node.si + "," + node.ei + "] =>" node.left.data + "," + node.right.data 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
