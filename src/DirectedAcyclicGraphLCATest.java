import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class DirectedAcyclicGraphLCATest {

	@Test
	public void testBFSPathFind()
	{
		System.out.println("TEST: BFSPathFind");
		DirectedAcyclicGraphLCA testGraph = new DirectedAcyclicGraphLCA();
		testGraph.root = initialiseBasicDirectedAcyclicGraph();
		testGraph.printAllPaths(testGraph.BFSPathFind(testGraph.root, 10));;
	}
	
	@Test
	public void testGetAncestorList()
	{
		System.out.println("TEST: getAncestorList");
		DirectedAcyclicGraphLCA testGraph = new DirectedAcyclicGraphLCA();
		testGraph.root = initialiseBasicDirectedAcyclicGraph();
		ArrayList<Node> ancestors = testGraph.getAncestorList(testGraph.BFSPathFind(testGraph.root, 10));
		testGraph.printAllPaths(testGraph.BFSPathFind(testGraph.root, 10));
		String result = "";
		for(int i = 0; i < ancestors.size(); i++)
		{
			result += ancestors.get(i).data;
			if(i != ancestors.size()-1)
			{
				result += ",";
			}
		}
		assertEquals(result,"4,7,8,9,10,5,6");
	}
	
	@Test
	public void  testFindCommonAncestor()
	{
		System.out.println("TEST: findCommonAncestor in a normal circumstance");
		DirectedAcyclicGraphLCA testGraph = new DirectedAcyclicGraphLCA();
		testGraph.root = initialiseBasicDirectedAcyclicGraph();
		ArrayList<Node> ancestors1 = testGraph.getAncestorList(testGraph.BFSPathFind(testGraph.root, 10));
		ArrayList<Node> ancestors2 = testGraph.getAncestorList(testGraph.BFSPathFind(testGraph.root, 7));
		System.out.println("Paths belonging to the first value");
		testGraph.printAllPaths(testGraph.BFSPathFind(testGraph.root, 10));
		System.out.println("Paths belonging to the second value");
		testGraph.printAllPaths(testGraph.BFSPathFind(testGraph.root, 7));
		ArrayList<Node> commonAncestors = testGraph.findCommonAncestors(ancestors1, ancestors2);
		System.out.println("Ancestors belonging to both:");
		String result = "";
		for(int i = 0; i < commonAncestors.size(); i++)
		{
			result += commonAncestors.get(i).data;
			if(i != commonAncestors.size()-1)
			{
				result += ",";
			}
		}
		System.out.println(result);
		assertEquals(result, "4,7");
	}
	
	@Test
	public void testprintPath()
	{
		System.out.println("TEST: printPath");
		DirectedAcyclicGraphLCA tester = new DirectedAcyclicGraphLCA();
		ArrayList<Node> testPath = new ArrayList<Node>();
		testPath.add(new Node(1));
		testPath.add(new Node(2));
		testPath.add(new Node(3));
		testPath.add(new Node(4));
		testPath.add(new Node(5));
		tester.printPath(testPath);
		
	}
	
	@Test
	public void printAllPaths()
	{
		System.out.println("TEST: printAllPaths");
	}
	
	
	public Node initialiseBasicDirectedAcyclicGraph()
	{
		//Using the graph in the document as a basic graph for testing
		Node aNode = new Node(10);
		Node bNode = new Node(9);
		Node cNode = new Node(8);
		Node dNode = new Node(7);
		Node eNode = new Node(6);
		Node fNode = new Node(5);
		Node gNode = new Node(4);
		
		gNode.addChild(dNode);
		gNode.addChild(fNode);
		dNode.addChild(cNode);
		cNode.addChild(bNode);
		bNode.addChild(aNode);
		fNode.addChild(eNode);
		eNode.addChild(bNode);
		
		
		return gNode;
	}

}
