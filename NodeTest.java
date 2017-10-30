import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testConnect() {
		Node n = new Node ("a",2);
		Node f =  new Node("f", 0);
		n.connectChild(f);
		assertTrue(n.children.size()==1);
		assertTrue(f.ancestor.equals(n));
		
	}

}
