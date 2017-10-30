import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class DAGTest {
	
	@Test
	public void testAncestorToString(){
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
		assertEquals ("Testing two ancestors", "[a,b]", STRcList);
	}
	@Test
	public void testListOfAncestors(){
		
	}
	//@Test
//	public void testEmptyLCA() {
//		DAG<String> test = new DAG<String>();
//		assertNull(test.findLCA("A", "C"));
//		   assertEquals("Testing null inputs", null, DAG.findLCA(null, null, null));
//		    assertEquals("Testing null inputs", null, LCA.findLowestCommonAncestor(null, a, null));
//		    assertEquals("Testing null inputs", null, LCA.findLowestCommonAncestor(null, null, b));
//		// test the array list is empty
//	}

	@Test
	public void testOneNode() {
		DAG<String> test = new DAG<String>();
		assertEquals("A", test.findLCA("A","B"));
		// test that the first node is its own LCA
	}
}

//	@Test
//	public void testOneParent() {
//		DAG<String> test = new DAG<String>();
//		test.put(2);
//		test.put(1);
//		test.put(3);
//		assertEquals("2", test.findLCA(3, 1).toString());
//
//	}
//
//	@Test
//	public void testTwoParents() {
//		DAG<String> test = new DAG<String>();
//		test.put(2);
//		test.put(1);
//		test.put(4);
//		test.put(3);
//		test.put(5);
//		assertEquals("2", test.findLCA(1, 4).toString());
//		assertEquals("4", test.findLCA(3, 5).toString());
//	}
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
