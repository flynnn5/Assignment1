import java.util.NoSuchElementException;

public class BinaryTree<Key extends Comparable<Key>> {
	Node root;

	class Node {
		Key key;
		Node left;
		Node right;

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

	private Node findLCA() {
		return root;
	}

	public BinaryTree() {

	}
}