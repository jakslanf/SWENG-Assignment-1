import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class DirectedAcyclicGraphLCATest {

	@Test
	public void testBFSPathFind()
	{
		
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

}
