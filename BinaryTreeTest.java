import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {
	@Test
	public void isEmpty() {
		BinaryTree<Integer> test = new BinaryTree<Integer>();
		assertEquals(test.root, null);
		test.put(3);
		assertEquals("3",test.root.key.toString());
	}
	@Test
	public void testEmptyLCA(){
		BinaryTree<Integer> test = new BinaryTree<Integer>();
		assertNull(test.findLCA(1, 2));
	}
	@Test
	public void testOneNode(){
		BinaryTree<Integer> test = new BinaryTree<Integer>();
		test.put(1);
		assertEquals("1",test.findLCA(1,1).toString());
	}
	@Test
	public void testOneParent(){
		BinaryTree<Integer> test = new BinaryTree<Integer>();
		test.put(2);
		test.put(1);
		test.put(3);
		assertEquals("2",test.findLCA(3, 1).toString());
	}
	@Test
	public void testTwoParents(){
		BinaryTree<Integer> test = new BinaryTree<Integer>();
		test.put(2);
		test.put(1);
		test.put(4);
		test.put(3);
		test.put(5);
		assertEquals ("2",test.findLCA(1, 4).toString());
		assertEquals("4",test.findLCA(3,5).toString());
	}
	@Test 
	public void testNonExistingNode(){
		BinaryTree<Integer> test = new BinaryTree<Integer>();
		test.put(6);
		test.put(4);
		test.put(8);
		assertNull(test.findLCA(55, 44));
		assertNull(test.findLCA(33, 6));
		assertNull(test.findLCA(4, 33));
	}
	@Test
	public void testExists(){
		BinaryTree<Integer> test = new BinaryTree<Integer>();
		test.put(2);
		assertTrue(test.exists(2));
		assertFalse(test.exists(66));
	}
	@Test
	public void testLCA(){
		BinaryTree<Integer> test = new BinaryTree<Integer>();
		test.put(6);
		test.put(2);
		test.put(8);
		test.put(1);
		test.put(4);
		test.put(5);
		test.put(3);
		test.put(7);
		test.put(9);
		
		assertEquals("6",test.findLCA(5,8).toString());
		assertEquals("8",test.findLCA(7,9).toString());
		assertEquals("4",test.findLCA(3, 5).toString());
		assertEquals("2",test.findLCA(1, 4).toString());
		assertEquals("8",test.findLCA(7, 8).toString());
	}
}
