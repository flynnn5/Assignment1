import java.util.NoSuchElementException;

public class BinaryTree<Key extends Comparable<Key>> {
	Node root;

	class Node {
		Key key;
		Node left;
		Node right;
		int N;
		public Node(Key key) {
			this.key = key;
		}
	}

	public void put(Key key) {
		root = put(root, key);
	}

	private Node put(Node node, Key key) {
		if (node == null) {
			return new Node(key);
		}
		int compare = key.compareTo(node.key);
		if (compare > 0) {
			node.right = put(node.right, key);
		} else if (compare < 0) {
			node.left = put(node.left, key);
		}
		return node;
	}
	public Key findLCA(Key k1, Key k2){
		return findLCA(root, k1,k2).key;
	}
	private Node findLCA(Node root, Key k1, Key k2) {
		
	}

	public BinaryTree() {

	}
}