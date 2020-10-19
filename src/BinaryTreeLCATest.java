import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreeLCATest {

	@Test
	void testEmpty() {
		BinaryTreeLCA tree = new BinaryTreeLCA();
		assertEquals(tree.findLowestCommonAncestor(3, 5), -1);
	}
	@Test
	void testNeitherInTree() {
		BinaryTreeLCA tree = new BinaryTreeLCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		assertEquals(tree.findLowestCommonAncestor(6, 7),-1);
		assertEquals(tree.findLowestCommonAncestor(7, 6),-1);
	}
	@Test
	void testOneInTree() {
		BinaryTreeLCA tree = new BinaryTreeLCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		assertEquals(tree.findLowestCommonAncestor(2, 7),-1);
		assertEquals(tree.findLowestCommonAncestor(7, 2),-1);
	}
	@Test
	void testNormal()
	{
		BinaryTreeLCA tree = new BinaryTreeLCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		//Rudimentary test system
		assertEquals(tree.findLowestCommonAncestor(7, 6),3);
		assertEquals(tree.findLowestCommonAncestor(3, 7),3);
		assertEquals(tree.findLowestCommonAncestor(5, 6),1);
	}

}
