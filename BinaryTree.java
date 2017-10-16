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

	public Key findLCA(Key k1, Key k2) {
		if ((root == null) || (!exists(k1)) || (!exists(k2))){
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
				return exists(n1.left, k1);
			} else if (compare > 0) {
				return exists(n1.right, k1);
			} else {
				return n1.key;
			}
		}
	}

	public BinaryTree() {

	}
}