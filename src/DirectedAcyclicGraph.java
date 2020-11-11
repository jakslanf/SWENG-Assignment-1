import java.util.ArrayList;

public class DirectedAcyclicGraph
{
	Node root;
	ArrayList<Node> value1Ancestors;
	ArrayList<Integer> value1AncestorsDistance;
	ArrayList<Node> value2Ancestors;
	ArrayList<Integer> value2AncestorsDistance;
	
	//An ArrayList containing all possible paths of Nodes you can take from a starting Node to an end node
	public ArrayList<ArrayList<Node>> BFSPathFind(Node root, Node start, Node end)
	{
		ArrayList<ArrayList<Node>> queue = new ArrayList<ArrayList<Node>>();
		ArrayList<ArrayList<Node>> completePaths = new ArrayList<ArrayList<Node>>();
		ArrayList<Node> startingPath = new ArrayList<Node>();
		startingPath.add(start);
		queue.add(startingPath);
		while(!queue.isEmpty())
		{
			//boolean pathFound = false;
			ArrayList<Node> current = queue.remove(0);
			Node lastNode = current.get(current.size()-1);
			if (lastNode == end)
			{
				completePaths.add(current);
			}
			else
			{
				for(int i = 0; i < lastNode.getChildAmount()-1; i++)
				{
					@SuppressWarnings("unchecked")
					ArrayList<Node> nextPath = (ArrayList<Node>) current.clone();
					nextPath.add(lastNode.getChild(i));
					queue.add(nextPath);
				}
			}
		}
		return completePaths;
	}
	
	// Condense all paths to a Node into two ArrayLists alongside their distance from the starting Node
	public ArrayList<Node> condenseAncestorList()
	{
		return null;
	}

}
