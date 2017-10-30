import java.util.ArrayList;
import java.util.*;

public class Node<T> {

	public T key;
	public T data;
	public ArrayList<Node<T>> children;
	public Node<T> ancestor;  

	public Node (T key, T value) {
		this.key = key;
		this.data = value;
		children = new ArrayList<Node<T>>();
		ancestor = null;
	}
	
	public void connectChild(Node<T> child){
		if (child != null){
			this.children.add(child);
			child.ancestor = this;
		}
	}
	
	
	
	
}
