import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class DirectedAcyclicGraphLCATest {

	@Test
	public void testBFSPathFind()
	{
		DirectedAcyclicGraphLCA testGraph = new DirectedAcyclicGraphLCA();
		testGraph.root = initialiseBasicDirectedAcyclicGraph();
		testGraph.printAllPaths(testGraph.BFSPathFind(testGraph.root, 10));;
	}
	
	@Test
	public void testcondenseAncestorList()
	{
		
	}
	
	@Test
	public void printPath()
	{
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
