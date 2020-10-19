	import java.util.ArrayList; 
	import java.util.List; 
public class BinaryTreeLCA
{
	Node root; 
	private List<Integer> path1; 
    private List<Integer> path2; 
    
	
	int findLowestCommonAncestor(int value1, int value2)
	{
		path1 = new ArrayList<Integer>();
		path2 = new ArrayList<Integer>();
		return LowestCommonAncestorSearch(root, value1, value2);
	}
	
	private boolean findPath(Node root, int n, List<Integer> path) 
    { 
        if (root == null)
        { 
            return false; 
        }
        path.add(root.data);
        if (root.data == n)
        {
            return true;
        }
        if (root.left != null && findPath(root.left, n, path))
        { 
            return true; 
        }
        if (root.right != null && findPath(root.right, n, path))
        { 
            return true;
        }
        path.remove(path.size()-1); 
        return false; 
    } 
	
	private int LowestCommonAncestorSearch(Node root, int value1, int value2) { 
		  
		boolean path1Find = findPath(root, value1, path1);
		boolean path2Find = findPath(root, value2, path2);
        if ( !path1Find || !path2Find )
        { 
            System.out.println((path1.size() > 0) ? "" + value1 + " is in BST" : "" + value1 + " is missing from BST"); 
            System.out.println((path2.size() > 0) ? "" + value2 + " is in BST" : "" + value2 + " is missing from BST"); 
            return -1; 
        }
        int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++)
        {
        	if (!path1.get(i).equals(path2.get(i))) 
        		break; 
        }
        return path1.get(i-1); 
    } 
	
	public static void main(String[] args) {
		//Intialise a tree so that it can be tested
		BinaryTreeLCA tree = new BinaryTreeLCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		//Rudimentary test system
		System.out.println("The LCA of 7 and 6 is " + tree.findLowestCommonAncestor(7, 6));
		System.out.println("The LCA of 3 and 7 is " + tree.findLowestCommonAncestor(3, 7));
		System.out.println("The LCA of 5 and 6 is " + tree.findLowestCommonAncestor(5, 6));

	}

}
