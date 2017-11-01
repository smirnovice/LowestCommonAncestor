import java.util.ArrayList;
import java.util.List;


public class DAG 
{
	public Node head;
	public class Node
	{
		char key;
		int val;
		List<Node> parents = new ArrayList<Node>();
		List<Node> children = new ArrayList<Node>();
	}

	public void createHead(int val, char key)
	{
		Node head = new Node();
		head.val = val;
		head.key = key;
		head.parents = new ArrayList<Node>();
		head.children = new ArrayList<Node>();
		this.head = head;
	}
	
	public int returnVal(Node node)
	{
		return node.val;
	}
	
	public char returnKey(Node newN)
	{
		return newN.key;
	}
	
	public void addNode(char key, int val, Node parent)
	{
		Node newNode = new Node();
		newNode.key = key;
		newNode.children = new ArrayList<Node>();
		newNode.val = val;
		newNode.parents.add(parent);
		parent.children.add(newNode);
	}
	
	public Node findNode(char key)
	{
		Node x;
		if (key == head.key)
		{
			return head;
		}
		else
		{
			for(int i = 0; i < head.children.size();i++)
			{
				x = findNode(key,head.children.get(i));
				if (x != null)
				{
					return x;
				}
			}
		}
		return null;
	}
	
	private Node findNode(char key, Node a)
	{
		Node x;
		if(a.key == key){
			return a;
		}
		else
		{
			for(int i = 0; i < a.children.size();i++)
			{
				x = findNode(key,a.children.get(i));
				if (x != null)
				{
					return x;
				}
			}
		}
		return null;
	}
	
	public Node LCA(Node start, Node a, Node b)
	{
		Node x = null;
		if (a.key == head.key || b.key == head.key)
		{
			return head;
		}
		else
		{
			Node tempA = findNode(a.key, start);
			Node tempB = findNode(b.key, start);
			if (tempA != null && tempB != null)
			{
				x = start;
				for(int i = 0; i < start.children.size();i++)
				{
					if (LCA(start.children.get(i),a,b) != null)
					{
						x = LCA(start.children.get(i),a,b);
					}
				}				
			}			
		}
		return x;
	}
}
