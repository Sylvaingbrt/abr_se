package abr_se;

import static org.junit.Assert.*;
import org.junit.Test;

public class ABRtests {

	@Test
	public void testIsEmpty() {
		ABR emptyTree = new ABR();
		assertTrue(emptyTree.isEmpty());
	}
	
	@Test
	public void testInsert() {
		ABR tree = new ABR();
		tree.insert(8);
		assertFalse(tree.isEmpty());
	}
	
	
	@Test
	public void testNbElement() {
		ABR tree = new ABR();
		assertTrue(tree.nbElement()==0);
		tree.insert(8);
		assertTrue(tree.nbElement()==1);
		tree.insert(9);
		assertEquals(tree.nbElement(),2);
	}

}
