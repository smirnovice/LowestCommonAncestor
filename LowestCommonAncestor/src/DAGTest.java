import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest 
{

	@Test
	//test for createHead
	public void testHead() 
	{
		DAG dag = new DAG();
		dag.createHead(1, 'x');
		assertEquals("This will return the head of DAG", 'x', dag.returnKey(dag.head));
	}
	
	@Test
	//test for addNode
	public void testAdd()
	{
		DAG dag = new DAG();
		dag.createHead(1,'x');
		dag.addNode('y',2,dag.head);
		assertEquals("Get y",'y',dag.returnKey(dag.head.children.get(0)));		
		dag.addNode('z', 3, dag.head.children.get(0));
		assertEquals("Get z",'z',dag.returnKey(dag.head.children.get(0).children.get(0)));
		
	}
	
	@Test
	//test for findNode
	public void testFind()
	{
		DAG dag = new DAG();
		dag.createHead(1,'x');
		assertEquals("Find head",'x',dag.returnKey(dag.findNode('x')));
		dag.addNode('y',2,dag.head);
		assertEquals("Find y",'y',dag.returnKey(dag.findNode('y')));
		dag.addNode('z',2,dag.head.children.get(0));
		assertEquals("Find z",'z',dag.returnKey(dag.findNode('z')));
	}
	
	@Test
	//test for LCA
	public void testLCA()
	{
		DAG dag = new DAG();
		dag.createHead(1,'x');
		dag.addNode('y', 2, dag.head);
		dag.addNode('z', 3, dag.head);
		assertEquals("Check the LCA", 'x', dag.returnKey(dag.LCA(dag.head, dag.head.children.get(0), dag.head.children.get(1))));
		dag.addNode('a', 4, dag.head.children.get(0));
		dag.addNode('b', 5, dag.head.children.get(0));
		assertEquals("Check the LCA", 'y', dag.returnKey(dag.LCA(dag.head, dag.head.children.get(0).children.get(0), dag.head.children.get(0).children.get(1))));
	}

}