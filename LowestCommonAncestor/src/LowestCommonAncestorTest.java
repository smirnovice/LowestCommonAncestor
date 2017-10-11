import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	public void testContains(){
		LowestCommonAncestor<Integer, Integer> bst = new LowestCommonAncestor<Integer, Integer>();
		assertEquals("Checking getting contains on empty tree", false, bst.contains(null));
		
		bst.put(7, 7);   	//        _7_
		bst.put(8, 8);   	//      /     \
		bst.put(3, 3);   	//    _3_      8
		bst.put(1, 1);   	//  /     \     
		bst.put(2, 2);   	// 1       6     
		bst.put(6, 6);   	//  \     /
		bst.put(4, 4);   	//   2   4
		bst.put(5, 5);   	//        \
		                	//         5


		assertSame("Checking getting median of non-empty tree", true, bst.contains(6)); 
	}
	
	@Test
	public void testHeight() {
		LowestCommonAncestor<Integer, Integer> bst = new LowestCommonAncestor<Integer, Integer>();
		assertEquals("Checking height of empty tree", -1, bst.height());

		bst.put(7, 7);   
		assertEquals("Checking height of single node tree", 0, bst.height());

						   //         _7_
		bst.put(8, 8);     //       /     \
		bst.put(3, 3);     //     _3_      8
		bst.put(1, 1);     //   /     \
		bst.put(2, 2);     //  1       5
		bst.put(5, 5);     //   \     
						   //    2   

		assertEquals("Checking height of non-empty tree", 3, bst.height());
	}
	
	@Test
	public void testLowestCommonAncestor(){
		LowestCommonAncestor<Integer, Integer> bst = new LowestCommonAncestor<Integer, Integer>();
		
		bst.put(7, 7);   	//        _7_
		bst.put(8, 8);   	//      /     \
		bst.put(3, 3);   	//    _3_      8
		bst.put(1, 1);   	//  /     \     
		bst.put(2, 2);   	// 1       6     
		bst.put(6, 6);   	//  \     /
		bst.put(4, 4);   	//   2   4
		bst.put(5, 5);   	//        \
		                	//         5

		assertSame("Checking lowest common ancestor of two Keys", 7, bst.lowestCommonAncestor(bst.root, 7, 8)); 
	}

}
