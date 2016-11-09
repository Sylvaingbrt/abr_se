package abr_se;

public class ABR extends java.lang.Object{
	
	
	private int nbElements; // number of elements in the abr
	private ABRNode root; /// root node of the ABR
	
	public ABR(){
		this.nbElements=0;
		this.root=null;
	}
	
	public void insert(int value){
		if(this.contains(value)){
			
		}
		else{
			this.nbElements++;
			if(root==null) 
				root = new ABRNode(0, value);
			ABRNode node = getParent(value);
			if(node.diff(value)<0) {
				assert(node.leftChild==null);
				node.leftChild = new ABRNode((node.pos+1), value);
			} else if (node.diff(value)>0){
				assert(node.rightChild==null);
				node.rightChild = new ABRNode((node.pos+1), value);
			}
		}
		
	}
	
	
	public boolean isEmpty(){
		return this.nbElements==0;
	}
	
	public int nbElement(){
		return this.nbElements;
	}
	
	public boolean contains(int value){
		ABRNode node = this.root;
		return isInside(node, value);
	}
	
	public void toList(java.util.List<java.lang.Integer> l){
		addToList(this.root, l);
	}
	
	
	
	//Ce qui suit est la liste des fonctions "privates" dont je me suis servi pour faire marcher les 
	//fonctions précédentes
	
	
	
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
	

	private boolean isInside(ABRNode node, int value){
		if (node == null){
			return false;
		}
		if(node.value==value){
			return true;
		}
		if(node.diff(value)<0){
			return isInside(node.leftChild, value);
		}
		else{
			return isInside(node.rightChild, value);
		}
	}
	
	private ABRNode getParent(int value) {
		
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
	
	private void addToList(ABRNode node, java.util.List<java.lang.Integer> l){
		int i = 0;
		if(l.isEmpty()){
			l.add(node.value);
		}
		else{
			if(node.value>=l.get(l.size()-1)){
				l.add(node.value);
			}
			else{
				while(node.value >= l.get(i)){
					i++;
				}
				l.add(i, node.value);
			}
		}
		if(node.leftChild != null){
			addToList(node.leftChild, l);
		}
		if(node.rightChild != null){
			addToList(node.rightChild, l);
		}
		
	}
	
	
	

}
