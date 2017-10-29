import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class DAGTest {
	@SuppressWarnings("deprecation")
	
	//This will start by ensuring nodes are 
	//connected and nodes have been entered (not empty)
	//then i will need to test that LCA works, that 
	//the graph is not acyclic
	@Test
	public void isEmpty() {
		DAG<String> test = new DAG<String>();
		assertEquals("Testing an empty DAG",test.root, null);
		test.put("A");
		Assert.assertEquals("A", test.root.key);
		// will need to change this for a directed graph, possibly
		//using an array list instead of binary tree?
	}
	@Test
	public void testEmptyLCA(){
		DAG<String> test = new DAG<String>();
		Node a = new Node(1);
		assertNull(test.findLCA(1, 2));
		//test the array list is empty
	}
	@Test
	public void testOneNode(){
		DAG<String> test = new DAG<String>();
		test.put(1);
		assertEquals("1",test.findLCA(1,1).toString());
		//test that the first node is its own LCA
	}
	@Test
	public void testOneParent(){
		DAG<String> test = new DAG<String>();
		test.put(2);
		test.put(1);
		test.put(3);
		assertEquals("2",test.findLCA(3, 1).toString());
		
	}
	@Test
	public void testTwoParents(){
		DAG<String> test = new DAG<String>();
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
		DAG<String> test = new DAG<String>();
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
		DAG<String> test = new DAG<String>();
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
