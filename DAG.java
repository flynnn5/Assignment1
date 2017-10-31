import java.util.ArrayList;
import java.util.NoSuchElementException;

public class DAG<Key extends Comparable<Key>> {

	public static ArrayList<Node> listOfAncestors(Node a) {
		ArrayList<Node> ancestors = new ArrayList<Node>();
		ancestors.add(a);
		Node temp = a;
		if (temp != null) {
			while (temp.ancestor != null) {
				ancestors.add(temp.ancestor);
				temp = temp.ancestor;
			}
		}
		return ancestors;

	}

	static Node root;

	static Node findLCA(Node n1, Node n2) {
		if ((n1 == null) || (n2 == null)) {
			return null;
		}
		// } else if (n1.ancestor == null) {
		// return n1;
		// } else if (n2.ancestor == null) {
		// return n2;
	else if(n1==n2)

	{
		return n1;
	} else

	{
		ArrayList<Node> n1List = DAG.listOfAncestors(n1);
		ArrayList<Node> n2List = DAG.listOfAncestors(n2);

		for (int loopn1 = 0; loopn1 < n1List.size(); loopn1++) {
			for (int loopn2 = 0; loopn2 < n2List.size(); loopn2++) {
				if (n2List.get(loopn2).key.equals(n1List.get(loopn1).key)) {
					return (n2List.get(loopn2));
				}
			}
		}
	} return null;

	}
	// in the same way BT looped down until it found the
	// shared ancestor, we will implement this for a DAG

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

	public static String ancestorsToString(ArrayList<Node> ancestors) {
		if (ancestors == null) {
			return null;
		}
		String ans = "[";
		for (int i = 0; i < ancestors.size(); i++) {
			if (i != ancestors.size() - 1) {
				ans += ancestors.get(i).key.toString() + ",";
			} else {
				ans += ancestors.get(i).key.toString();
			}
		}
		ans += "]";
		return ans;

	}
}// need to connect nodes
	// if a is connected to b and c, and be is connected to c
	// should be a - b - c
