package abr_se;

import static org.junit.Assert.*;
import org.junit.Test;

public class ABRtests {

	@Test
	public void testEmpty() {
		ABR emptyTree = new ABR();
		assertTrue(emptyTree.isEmpty());
	}
	
	@Test
	public void testInsert() {
		ABR tree = new ABR();
		tree.insert(8);
		assertFalse(tree.isEmpty());
		assertTrue(tree.nbElement()==1);
		tree.insert(9);
		assertEquals(tree.nbElement(),2);
	}
	
	
	@Test
	public void testContains() {
		ABR tree = new ABR();
		tree.insert(8);
		tree.insert(9);
		tree.insert(5);
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(9));
		assertTrue(tree.contains(5));
	}

}
