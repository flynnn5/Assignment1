import java.util.ArrayList;

public class Node<String> {

	public String key;
	public int data;
	public ArrayList<Node<String>> edgesTo;
	public int noOfNodesIn;
	public int noOfNodesOut;

	public Node (String key, int value) {
		this.key = key;
		this.data = value;
		edgesTo = new ArrayList<Node<String>>();
		noOfNodesIn =0;
		noOfNodesOut = edgesTo.size();
	}
	//add an edge and connect a parent node to a child
	public void connectChild(Node<String> child){
		if (child != null){
			this.edgesTo.add(child);
			child.noOfNodesIn++;
		}
	}
	
	
	
	
}
