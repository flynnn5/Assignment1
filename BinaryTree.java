import java.util.NoSuchElementException;

public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;

	private class Node {
		private Key key;
		private Node left, right;

		public Node(Key key) {
			this.key = key;
		}
	}

	private Node put(Node x, Key key) {

		return null;
	}

	private Node findLCA() {
		return root;
	}

	public BinaryTree() {

	}
}