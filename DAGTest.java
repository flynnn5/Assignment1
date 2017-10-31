import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class DAGTest {
	
	@Test
	public void testListOfAncestors(){
		ArrayList<Node> nullList = DAG.listOfAncestors(null);
		assertEquals("testing ancestry of null", "[]", DAG.ancestorsToString(nullList));
		Node a = new Node ("a" ,1);
		ArrayList<Node> aList = DAG.listOfAncestors(a);
		String STRaList = DAG.ancestorsToString(aList);
		assertEquals("Testing ancestry of a", "[]", STRaList);
		
		
		Node b = new Node ("b", 2);
		a.connectChild(b);
		ArrayList<Node> bList =DAG.listOfAncestors(b);
		String STRbList = DAG.ancestorsToString(bList);
		assertEquals("Testing one parent", "[a]", STRbList);
		
		
		Node c = new Node ("c",3);
		b.connectChild(c);
		ArrayList<Node> cList = DAG.listOfAncestors(c);
		String STRcList = DAG.ancestorsToString(cList);
		assertEquals ("Testing two ancestors", "[b,a]", STRcList);
		
		Node d = new Node("d", 4);
		b.connectChild(d);
		ArrayList<Node> dList = DAG.listOfAncestors(d);
		String STRdList = DAG.ancestorsToString(dList);
		assertEquals ("Testing two ancestors", "[b,a]", STRdList);
	}
	@Test
	public void testEmptyLCA() {
		ArrayList<Node> test = DAG.listOfAncestors(null);
		assertEquals("Testing LCA on null", null, DAG.findLCA(null,null));
	}

	@Test
	public void testTwoChildren() {
		Node a = new Node ("a",3);
		Node b = new Node ("b", 5);
		Node c = new Node ("c", 6);		
		a.connectChild(b);
		a.connectChild(c);
		//b.connectChild(d);

		
		ArrayList<Node> test1 = DAG.listOfAncestors(c);
		ArrayList<Node> test2 = DAG.listOfAncestors(b);
		assertEquals(a, DAG.findLCA(test1, test2));
		// test that the first node is its own LCA
	}
	@Test
	public void testSameList(){
		Node a = new Node ("a",34);
		ArrayList<Node> test = DAG.listOfAncestors(a);
		assertEquals(a,DAG.findLCA(test, test));
		
		Node b = new Node ("b",333);
		Node c = new Node ("c", 212);
		Node d = new Node ("d", 22);
		b.connectChild(c);
		c.connectChild(d);
		ArrayList<Node> test2 = DAG.listOfAncestors(d);
		assertEquals(d, DAG.listOfAncestors(d));

	}
	@Test
	public void testOneShortPath() {
		Node a = new Node ("a",3);
		Node b = new Node ("b", 5);
		Node c = new Node ("c", 6);		
		Node d = new Node ("d", 45);		
		Node e = new Node ("e", 34);		

		a.connectChild(b);
		b.connectChild(c);
		a.connectChild(e);
		c.connectChild(d);
		ArrayList<Node> test = DAG.listOfAncestors(e);
		ArrayList<Node> test2 = DAG.listOfAncestors(d);
		
		assertEquals("Testing one short path",a, DAG.findLCA(test, test2));

	}


}
//
//	@Test
//	public void testNonExistingNode() {
//		DAG<String> test = new DAG<String>();
//		test.put(6);
//		test.put(4);
//		test.put(8);
//		assertNull(test.findLCA(55, 44));
//		assertNull(test.findLCA(33, 6));
//		assertNull(test.findLCA(4, 33));
//	}
//
//	@Test
//	public void testExists() {
//		BinaryTree<Integer> test = new BinaryTree<Integer>();
//		test.put(2);
//		assertTrue(test.exists(2));
//		assertFalse(test.exists(66));
//	}
//
//	@Test
//	public void testLCA() {
//		DAG<String> test = new DAG<String>();
//		test.put(6);
//		test.put(2);
//		test.put(8);
//		test.put(1);
//		test.put(4);
//		test.put(5);
//		test.put(3);
//		test.put(7);
//		test.put(9);
//
//		assertEquals("6", test.findLCA(5, 8).toString());
//		assertEquals("8", test.findLCA(7, 9).toString());
//		assertEquals("4", test.findLCA(3, 5).toString());
//		assertEquals("2", test.findLCA(1, 4).toString());
//		assertEquals("8", test.findLCA(7, 8).toString());
//	}
//}
