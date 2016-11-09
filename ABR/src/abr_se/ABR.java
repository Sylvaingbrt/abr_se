package abr_se;

import java.util.ArrayList;

public class ABR extends java.lang.Object{
	
	
	private int nbElements; // number of elements in the abr
	private ABRNode root; /// root node of the ABR
	private ArrayList<Object> Liste = new ArrayList<Object>() ;
	
	
	/** A node in the ABR
	 */
	private class ABRNode 
	{
		ABRNode leftChild, rightChild;
		int pos;
		int value;
		
		ABRNode(int p, int value){
			this.pos = p;
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}

		ABRNode(int p, int value, ABRNode lChild, ABRNode rChild){
			this.pos = p;
			this.value = value;
			this.leftChild = lChild;
			this.rightChild = rChild;
		}
		
		int diff(int value) { 
			return value-this.value;
		}
	}
	
	
	
	
	public ABR(){
		this.nbElements=0;
		this.Liste=null;
		this.root=null;
	}
	
	public void insert(int value){
		this.nbElements++;
		if(root==null) 
			root = new ABRNode(0, value);
		this.Liste.add(value);
		
	}
	
	
	public boolean isEmpty(){
		return this.nbElements==0;
	}
	
	public int nbElement(){
		return this.nbElements;
	}
	
	ABRNode getParent(int value) {
		
		ABRNode next = root, node = null;

		while (next != null) {
			node = next;
			if ( node.diff(value) < 0 ){
				next = node.leftChild;
			} else {
				next = node.rightChild;
			}
		}
		
		return node;
	}

}
