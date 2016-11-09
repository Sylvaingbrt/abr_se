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
			// si l'élément est dans l'arbre, on ne fait rien
		}
		else{
			this.nbElements++;
			if(root==null) 
				root = new ABRNode(0, value);
			ABRNode node = getParent(value);
			if(node.diff(value)<0) { //si c'est plus grand, c'est le fils de gauche
				assert(node.leftChild==null);
				node.leftChild = new ABRNode((node.pos+1), value);
			} else if (node.diff(value)>0){ // si c'est plus petit, c'est le fils de droite
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
		return isInside(node, value); //appel d'une fonction recursive pour voir si l'élement est dans l'arbre
	}
	
	public void toList(java.util.List<java.lang.Integer> l){
		addToList(this.root, l); // appel d'une fonction recursive pour créer la liste
	}
	
	
	
	//Ce qui suit est la liste des fonctions "privates" dont je me suis servi pour faire marcher les 
	//fonctions précédentes
	
	
	
	/** A node in the ABR
	 */
	private class ABRNode //Class de noeud
	{
		ABRNode leftChild, rightChild;
		int pos; //position dans l'arbre: couche 0 = racine.
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
			l.add(node.value); //première valeur dans la liste
		}
		else{
			if(node.value>=l.get(l.size()-1)){
				l.add(node.value); //si l'élément est plus grand que tout on le met à la fin
			}
			else{
				while(node.value >= l.get(i)){
					i++;
				}
				l.add(i, node.value); //on rajoute l'élément à la "bonne" place
			}
		}
		//on ajoute ensuite les noeuds suivant
		if(node.leftChild != null){
			addToList(node.leftChild, l); 
		}
		if(node.rightChild != null){
			addToList(node.rightChild, l);
		}
		
	}
	
	
	

}
