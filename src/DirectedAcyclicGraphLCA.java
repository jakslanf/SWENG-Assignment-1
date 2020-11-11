import java.util.ArrayList;

public class DirectedAcyclicGraphLCA
{
	Node root;
	//ArrayList<Node> value1Ancestors;
	//ArrayList<Integer> value1AncestorsDistance;
	//ArrayList<Node> value2Ancestors;
	//ArrayList<Integer> value2AncestorsDistance;
	
	public int findLowestCommonAncestor(int value1, int value2)
	{
		int result = -1;
		ArrayList<ArrayList<Node>> value1AllPaths = BFSPathFind(root, value1);
		ArrayList<ArrayList<Node>> value2AllPaths = BFSPathFind(root, value2);
		ArrayList<Node> value1Ancestors = getAncestorList(value1AllPaths);
		ArrayList<Node> value2Ancestors = getAncestorList(value2AllPaths);
		ArrayList<Node> commonAncestors = findCommonAncestors(value1Ancestors, value2Ancestors);
		ArrayList<Integer> value1DistanceToCommonAncestors = new ArrayList<Integer>();
		ArrayList<Integer> value2DistanceToCommonAncestors = new ArrayList<Integer>();
		
		for(int i = 0; i < commonAncestors.size(); i++)
		{
			value1DistanceToCommonAncestors.add(findDistanceToAncestor(commonAncestors.get(i), value1AllPaths));
			value2DistanceToCommonAncestors.add(findDistanceToAncestor(commonAncestors.get(i), value2AllPaths));
		}
		for(int i =0; i < commonAncestors.size();i++)
		{
			System.out.println(commonAncestors.get(i).data + " is " + value1DistanceToCommonAncestors.get(i) +" nodes from " + value1 +
					" and " + value2DistanceToCommonAncestors.get(i) + " nodes from " + value2);
		}
		
		int total = -1;
		for(int i =0; i < commonAncestors.size();i++)
		{
			int temp = value1DistanceToCommonAncestors.get(i) + value2DistanceToCommonAncestors.get(i);
			if(total == -1 || temp < total)
			{
				total = temp;
				result = commonAncestors.get(i).data;
			}
		}
		return result;
	}
	
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
	
	// Condense all paths to a Node into two ArrayList
	public ArrayList<Node> getAncestorList(ArrayList<ArrayList<Node>> allPaths)
	{
		ArrayList<Node> condensedList = new ArrayList<Node>();
		for(int i = 0; i < allPaths.size(); i++)
		{
			ArrayList<Node> currentPath = allPaths.get(i);
			for(int j = 0; j < currentPath.size(); j++)
			{
				Node selectedNode = currentPath.get(j);
				if(condensedList.indexOf(selectedNode) == -1)
				{
					condensedList.add(selectedNode);
				}

			}
		}
		
		return condensedList;
	}
	
	public ArrayList<Node> findCommonAncestors(ArrayList<Node> ancestorList1, ArrayList<Node> ancestorList2)
	{
		ArrayList<Node> commonAncestors = new ArrayList<Node>();
		for(int i =0; i < ancestorList1.size(); i++)
		{
			for(int j = 0; j < ancestorList2.size(); j++)
			{
				if(ancestorList1.get(i) == ancestorList2.get(j))
				{
					commonAncestors.add(ancestorList1.get(i));
				}
			}
		}
		return commonAncestors;
	}
	
	public int findDistanceToAncestor(Node ancestor, ArrayList<ArrayList<Node>> allPaths)
	{
		int result = -1;
		if(ancestor == null || allPaths == null)
		{
			return result;
		}
		for(int i = 0; i < allPaths.size(); i++)
		{
			for(int j =0; j < ancestor.data; j++)
			{
				if(allPaths.get(i).indexOf(ancestor) != -1)
				{
					if((allPaths.size() - 1 - allPaths.get(i).indexOf(ancestor) < result) || result == -1)
					{
						result = allPaths.get(i).size() - 1 - allPaths.get(i).indexOf(ancestor);
					}
				};
			}
		}
		
		return result;
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
