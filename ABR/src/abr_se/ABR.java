package abr_se;

public class ABR {
	
	
	private int nbElements; /// number of elements in the abr
	
	
	public ABR(){
		this.nbElements=0;
	}
	
	public void insert(int value){
		this.nbElements++;
		
	}
	
	
	public boolean isEmpty(){
		return this.nbElements==0;
	}
	
	public int nbElement(){
		return this.nbElements;
	}

}
