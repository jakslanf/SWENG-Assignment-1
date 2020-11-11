import java.util.ArrayList;

class Node
	{ 
	    int data; 
	    Node left, right; //Binary Tree
	    ArrayList<Node> children; //Directed Acyclic Graph
	    Node(int value)
	    { 
	        data = value; 
	        left = right = null;
	        children = new ArrayList<Node>();
	    }
	    
	    public Node getChild(int i)
	    {
	    	if(i < children.size())
	    	{
	    		return children.get(i);
	    	}
	    	else
	    	{
	    		return null;
	    	}
	    }
	    
	    public int getChildAmount()
	    {
	    	return children.size();
	    }
	    
	    public void addChild(Node child)
	    {
	    	children.add(child);
	    }
	    
	    public Node setChild(int i, Node child)
	    {
	    	if(i < children.size() - 1)
	    	{
	    		Node oldValue = children.get(i);
	    		children.set(i, child);
	    		return oldValue;
	    	}
	    	else
	    	{
	    		return null;
	    	}
	    }
	} 
