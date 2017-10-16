import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void isEmpty() {
		BinaryTree test = new BinaryTree();
		assertEquals(test.root, null);
		test.put(3);
		assertEquals(test.root.key, 3);
	}
	@Test
	public void testEmptyLCA(){
		BinaryTree test = new BinaryTree();
		assertNull(test.findLCA(1, 2));
	}
	@Test
	public void testOneNode(){
		BinaryTree test = new BinaryTree();
		test.put(1);
		assertEquals(test.findLCA(1,1),1);
	}
	public void testTwoNodes(){
		BinaryTree test = new BinaryTree();
		test.put(1);
		test.put(2);
		assertEquals(test.findLCA(1,2),1);
	}
	@Test
	public void testOneParent(){
		BinaryTree test = new BinaryTree();
		test.put(2);
		test.put(1);
		test.put(3);
		assertEquals(test.findLCA(3, 1),2);
	}
	@Test
	public void testTwoParents(){
		BinaryTree test = new BinaryTree();
		test.put(2);
		test.put(1);
		test.put(4);
		test.put(3);
		test.put(5);
		assertEquals (test.findLCA(1, 4),2);
		assertEquals(test.findLCA(3,5),4);
	}
	@Test 
	public void testNonExistingNode(){
		BinaryTree test = new BinaryTree();
		test.put(6);
		test.put(4);
		test.put(8);
		assertEquals (test.findLCA(3, 66), null);
	}
	@Test
	public void testPut() {
		BinaryTree test = new BinaryTree();
		test.put(10);
		test.put(2);
		test.put(6);
		test.put(1);
		test.put(2);
		test.put(3);
		test.put(23);
		test.put(7);
		test.put(10);

		assertEquals(test.root.key,10);
		assertEquals(test.root.left.key,2);
		assertEquals(test.root.left.right.key,6);
		assertEquals(test.root.left.left.key,1);
		assertEquals(test.root.right.key,23);
		assertEquals(test.root.left.right.left.key,3);
		assertEquals(test.root.left.right.right.key,7);
	}
	@Test
	public void testLCA(){
		BinaryTree test = new BinaryTree();
		test.put(6);
		test.put(2);
		test.put(8);
		test.put(1);
		test.put(4);
		test.put(5);
		test.put(3);
		test.put(7);
		test.put(9);
		
		assertEquals(test.findLCA(5,8), 6);
		assertEquals(test.findLCA(7,9),8);
		assertEquals(test.findLCA(3, 5),4);
		assertEquals(test.findLCA(1, 4),2);
		assertEquals(test.findLCA(7, 8),8);
	}
}
