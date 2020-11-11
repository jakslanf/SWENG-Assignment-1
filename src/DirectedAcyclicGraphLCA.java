import java.util.ArrayList;

public class DirectedAcyclicGraphLCA
{
	Node root;
	ArrayList<Node> value1Ancestors;
	ArrayList<Integer> value1AncestorsDistance;
	ArrayList<Node> value2Ancestors;
	ArrayList<Integer> value2AncestorsDistance;
	
	//An ArrayList containing all possible paths of Nodes you can take from a starting Node to an end node
	public ArrayList<ArrayList<Node>> BFSPathFind(Node start, int end)
	{
		ArrayList<ArrayList<Node>> queue = new ArrayList<ArrayList<Node>>();
		ArrayList<ArrayList<Node>> completePaths = new ArrayList<ArrayList<Node>>();
		ArrayList<Node> startingPath = new ArrayList<Node>();
		startingPath.add(root);
		queue.add(startingPath);
		while(!queue.isEmpty())
		{
			ArrayList<Node> current = queue.remove(0);
			Node lastNode = current.get(current.size()-1);
			if (lastNode.data == end)
			{
				completePaths.add(current);
			}
			else
			{
				for(int i = 0; i < lastNode.getChildAmount(); i++)
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
	
	public void printPath(ArrayList<Node> path)
	{
		String pathString = "";
		for(int i = 0; i < path.size(); i++)
		{
			pathString += "" + path.get(i).data;
			if(i !=path.size() - 1)
			{
				pathString += "->";
			}
		}
		System.out.println(pathString);
	}
	
	public void printAllPaths(ArrayList<ArrayList<Node>> pathList)
	{
		for(int i = 0; i < pathList.size(); i++)
		{
			printPath(pathList.get(i));
		}
	}

}
