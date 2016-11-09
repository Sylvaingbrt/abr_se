package abr_se;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void testFillList() {
		ABR tree = new ABR();
		List<Integer> L = new ArrayList<Integer>();;
		List<Integer> M= new ArrayList<Integer>();;
		tree.insert(8);
		tree.insert(9);
		tree.insert(5);
		tree.toList(L);
		M.add(5);
		M.add(8);
		M.add(9);
		System.out.println(L);
		assertEquals(L, M);
	}
	

}
