import java.util.NoSuchElementException;

public class DAG<Key extends Comparable<Key>> {
	 class Node {
		Key key;
		int counter;
		Node[] parent;
		Node[] child;

		private Node next, prev;
		public Node(Key key) {
			this.key = key;
			parent = child = null;
		}
	}
	Node root;


	public Key findLCA(Key k1, Key k2) {
		if ((root == null) || (!exists(k1)) || (!exists(k2))) {
			return null;
		} else {
			return findLCA(root, k1, k2).key;
		}
	}

	private Node findLCA(Node root, Key k1, Key k2) {
		if (root == null) {
			return null;
		} else if ((root.key == k1) || (root.key == k2)) {
			return root;
		}
		Node left = findLCA(root.left, k1, k2);
		Node right = findLCA(root.right, k1, k2);
		if ((left != null) && (right != null)) {
			return root;
		}
		if (left == null && right == null) {
			return null;
		}
		return left != null ? left : right;
	}
	//this will undoubtadly need to be changed
	//solution- figure out a way to store parents
	//each time you put a new node in, it should 
	//store the node it came from, and the node
	//that node came from etc

	public boolean exists(Key k1) {
		if (exists(root, k1) == k1) {
			return true;
		} else {
			return false;
		}
	}

	private Key exists(Node n1, Key k1) {
		if (n1 == null) {
			return null;
		} else {
			int compare = k1.compareTo(n1.key);
			if (compare < 0) {
				return exists(n1.prev, k1);
			} else if (compare > 0) {
				return exists(n1.next, k1);
			} else {
				return n1.key;
			}
		}
	}
	
}//need to connect nodes
//if a is connected to b and c, and be is connected to c
//should be a - b - c 
