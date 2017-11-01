import java.util.ArrayList;
import java.util.List;

public class DAG<Key extends Comparable<Key>, Value> {
		public Node root; 
	
		/**
		 * Private node class.
		 */
		private class Node 
		{
			List<Node> successor;
			private Key key;
	
			public Node(Key key) 
			{
				this.key = key;
			}
		}
	
		public Node addNode(Key key) 
		{
			if (root == null)
				return root = new Node(key);
			if (root.successor == null)
				root.successor = new ArrayList<Node>();
	
			Node tmp = new Node(key);
			root.successor.add(tmp);
			return tmp;
		}
	
		public Node connectNew(Key key, Key newNode) 
		{
			Node find = search(key);
			if (find.successor == null)
				find.successor = new ArrayList<Node>();
			Node tmp = new Node(newNode);
			find.successor.add(tmp);
			return tmp;
		}
	
		public Node search(Key key) 
		{
			if (root.key == key)
			{
				return root;
			}
			return search(root, key,root);
		}
	
		private Node search(Node find, Key key, Node ans) 
		{
			
			if (find.key == key)
			{
			  ans=find;
			  return ans;
			}
			int i = 0;
			if (find.successor != null) 
			{
				while ((i) < find.successor.size()) 
				{		
					ans=search(find.successor.get(i), key,ans);
					 i++;
				}
			}
		    return ans;
		}
		
		public boolean connect(Node first, Node second)
		{
			boolean toCheck=false;	
			toCheck=connectCheck(root, first, second, 0,true);
			if(toCheck)
			{
				if (first.successor == null)
				{
					first.successor = new ArrayList<Node>();
				first.successor.add(second);
				return true;
				}
			}
			return false;
		}
		private boolean connectCheck(Node head, Node first, Node second, int count, boolean ans)
		{
			int i = -1;
			if(head.key==second.key)
			{	
				count++;
			}
			if(count>0&&head.key==first.key)
			{				
				ans= false;
				return ans;
			}
			if (head.successor != null) 
			{
				
				while ((i + 1) < head.successor.size()) 
				{
					i++;
					 ans=connectCheck(head.successor.get(i), first, second,count,ans);
				}	
			}
			
			return ans;
		}
		public Node LCA (Node first, Node second)
		{
			if(first.key==second.key)
				return first;
			return LCA(root,first, second,root);
		}
		private Node LCA(Node head, Node first, Node second, Node ans)
		{
			int i = -1;
		    if(head.key==first.key)
		    {
		    	ans=searchLCA(first,second.key,ans,first);
		    	return ans;
		    }
		    if(head.key==second.key)
		    {
		    	ans=searchLCA(second,first.key,ans,second);
		    	return ans;
		    }
			if (head.successor != null) 
			{	
				while ((i + 1) < head.successor.size()) 
				{
					i++;
					ans=LCA(head.successor.get(i), first, second,ans);
				}	
			}
			
			return ans;
		}
	private Node searchLCA(Node find, Key key, Node ans, Node start) 
	{
			
			if (find.key == key)
			{
			  ans=start;
			  return ans;
			}
			int i = 0;
			if (find.successor != null) 
			{
				while ((i) < find.successor.size()) 
				{	
					ans=searchLCA(find.successor.get(i), key,ans, start);
					 i++;
				}
			}
		    return ans;
		}
	
	public static void main(String[] args) 
	{
		DAG<Integer, Integer> bst = new DAG<Integer, Integer>();
		bst.addNode(1);
		bst.addNode(2);
		bst.addNode(3);
		bst.connectNew(3, 4);
		System.out.println(bst.LCA(bst.search(3),bst.search(2)).key);
	}
	
}