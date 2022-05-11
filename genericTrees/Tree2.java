package genericTrees;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Queue;
public class Tree2 {

	private static class Node
	{
		int data;
		ArrayList<Node> children = new ArrayList<>();
		Node()
		{
			
		}
		Node(int data)
		{
			this.data = data;
		}
		
	}
	public static void display(Node node)
	{
		String st = node.data + "-->";
		for(Node child: node.children)
			st = st+ child.data + " ";
		System.out.println(st );
		
//		for(int i = 0 ;i<node.children.size(); i++)
//		{
//			display(node.children.get(i));
//		}
		
		for(Node child: node.children)
			display(child);
	}
	public static int height(Node node)
	{
		int ht = -1;
		
		for(Node child : node.children)
		{
			int ch  = height(child);
			ht  = Math.max(ht, ch); 
			
		}
		return ht+1;
	}
	public static int max(Node node)
	{
		int max = Integer.MIN_VALUE	;
		for(Node child: node.children)
		{
			int curr = max(child); 
			max = Math.max(max, curr);
			
		}
		return Math.max(max, node.data);
	}
	public static void allEuler(Node node)
	{
		System.out.println(node.data); // pre printing
		for(Node child : node.children)
			{	
				System.out.println(node.data+"-->"+child.data); // form moving one node to another (pre)
				allEuler(child);
				System.out.println(child.data+"-->"+node.data);//  returning form given node to previous node(post);
			}
		//post
	}
	public static void leverOrderInLine(Node node)
	{
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(node);
		while(q.size()>0)
		{
			node  = q.poll();
			System.out.print(node.data+ " ");
			for(Node child : node.children)
				q.add(child);
		}
	}
//	public static void levelOrderInLineRecu(Node node)
//	{
//		System.out.println(node.data);
//		for(Node child: node.children)
//			System.out.println(child.data);
//		
//		for(Node child: node.children)
//			levelOrderInLineRecu(child);
//			
//	}
	public static void levelOrderInDiffLine(Node node)
	{
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(node);
		Queue<Node> cq = new ArrayDeque<>();
		
		while(mq.size()>0)
		{
			node = mq.poll();
			System.out.print(node.data+" ");
			
			for(Node child : node.children)
				cq.add(child);
			
			if(mq.size()==0)
			{
				mq = cq;
				System.out.println();
				cq = new ArrayDeque<>();
			}
		}
	}
	public static void LevelOrderInDiffLine2(Node node)
	{
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(node);
		mq.add(new Node(-1));
		
		while(mq.size()>0)
		{
			node = mq.poll();
			System.out.print(node.data+ " ");
			
			for(Node child : node.children)
				mq.add(child);
			
			if(mq.peek().data == -1	)
			{
				mq.remove();
				System.out.println();
				
				if(mq.size()>0)
					mq.add(new Node(-1));
			}
							
		}
	}
	public static void makeMirror(Node node)
	{
		for(Node child: node.children)
		{
			makeMirror(child);
		}
		Collections.reverse(node.children);
	}
	public static void LevelOrderTraverseZZ(Node node)
	{
//		Queue<Node> mq = new ArrayDeque<>();
//		Stack<Node> st = new Stack<>();
//		mq.add(node);
//		
//		int level = 1 ; ?? // Logic for two different data str failed .. 
		// lets see;
		
		
		Stack<Node> ms = new Stack<>();
		ms.push(node);
		Stack<Node> ch = new Stack<>();
		
		int level = 1 ;
		while(ms.size()>0)
		{
			node = ms.pop()	;
			System.out.print(node.data + " ");
			if(level%2 != 0)
			{
				for(int i = 0 ;i<node.children.size(); i++)
				{
					Node child = node.children.get(i);
					ch .push(child);
				}
			}
			else
			{
				for(int i = node.children.size()-1 ;i>=0; i--)
				{
					Node child = node.children.get(i);
					ch .push(child);
				}
			}
			if(ms.size()==0)
			{
				ms = ch;
				ch = new Stack<>();
				level++;
				System.out.println();
			}
		}
				
	}
	public static void displayEuler(Node node)
	{
		System.out.print(node.data+"  ");
		for(Node child : node.children)
			displayEuler(child);
	}
	
	public static void removeLeaves(Node node)
	{
		for(int i = node.children.size()-1; i>=0; i--)
		{
			Node child = node.children.get(i);
			if(child.children.size()==0)
				node.children.remove(i);
		}
		
		for(Node child: node.children)
			removeLeaves(child);
	}
	public static void Linearize(Node node)
	{
		for(Node child : node.children)
		{
			Linearize(child);
		}
		while(node.children.size()>1)
		{
			Node lastchild = node.children.remove(node.children.size()-1);
			Node secLastchild = node.children.get(node.children.size()-1);	
			
			Node secLastTail = getTail(secLastchild);
			secLastTail.children.add(lastchild);
		}
		
	}
	private static Node getTail(Node node)
	{
		while(node.children.size()==1)
			node= node.children.get(0);
		
		return node;
	}
	public static Node linearize2(Node node)
	{
		if(node.children.size()==0)
			return node;
		Node lkt = linearize2(node.children.get(node.children.size()-1));
		while(node.children.size()>1)
		{
			Node last = node.children.remove(node.children.size()-1);
			Node sl = node.children.get(node.children.size()-1);
			Node slkt = linearize2(sl);
			slkt.children.add(last);
		}
		return lkt;
	}
	public static boolean getElement(Node node, int x)
	{
		if(node.data==x)
			return true;
		for(Node child : node.children)
		{
			if(getElement(child,x))
				return true;
		}
		return false;
	}
	public static ArrayList<Integer> nodeToRoot(Node node, int data)
	{
		if(node.data == data)
		{
			ArrayList<Integer> al = new ArrayList<>();
			al.add(node.data);
			return al;
		}
		for(Node child : node.children)
		{
			ArrayList<Integer> ptc =nodeToRoot(child,data);
			if(ptc.size()>0)
			{
				ptc.add(node.data);
				return ptc;
			}
			
		}
		return new ArrayList<>();
	}
	public static int lowestCommonAncestor(Node node, int d1, int d2)
	{
		ArrayList<Integer> p1 = nodeToRoot(node, d1);
		ArrayList<Integer> p2 = nodeToRoot(node, d2);
		
		int i = p1.size()-1;
		int j = p2.size()-1;
		
		while(i>=0 && j>=0 && p1.get(i)==p2.get(j))
		{
			i--;
			j--;
			
		}
		
		return p1.get(i+1);
		
	}
	public static int distanceBetweenNodes(Node node, int d1, int d2)
	{
		ArrayList<Integer> p1 = nodeToRoot(node,d1);
		ArrayList<Integer> p2 = nodeToRoot(node,d2);
		
		int i = p1.size()-1;
		int j = p2.size()-1;
		
		while(i>=0 && j>=0 && p1.get(i)==p2.get(j))
		{
			i--;
			j--;
		}
		i++;
		j++;
		return i+j;
	}
	public static boolean areSimilar(Node n1, Node n2)
	{
		if(n1.children.size()!=n2.children.size())
			return false;
		
		for(int i = 0 ; i< n1.children.size(); i++)
		{
			Node c1 = n1.children.get(i);
			Node c2 = n2.children.get(i);
			if(!areSimilar(c1,c2))
				return false;
		}
		return true;
	}
	public static boolean areMirror(Node n1, Node n2)
	{
		if(n1.children.size()!=n2.children.size())
			return false;
		for(int i= 0 ; i<n1.children.size(); i++)
		{
			int j = n1.children.size()-1-i;
			Node c1 = n1.children.get(i);
			Node c2 = n2.children.get(j);
			if(!areMirror(c1,c2))
				return false;
		}
		return true;
	}
	public static boolean isSymmetric(Node node	)
	{
		return areMirror(node,node);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Stack<Node> st = new Stack<>();
		Node root = null;
		
		for(int i = 0 ;i<arr.length ; i++)
		{
			if(arr[i] == -1)
				st.pop();
			else
			{
				Node t = new Node();
				t.data = arr[i];
				if(st.size()>0)
					st.peek().children.add(t);
				else
					root = t;
				
				st.push(t);
								
			}
		}
		
		
		
//		display(root);
//		System.out.println(height(root));
//		System.out.println(max(root));
		
//		allEuler(root);
		
//		leverOrderInLine(root);
//		levelOrderInLineRecu(root);
//		levelOrderInDiffLine(root);
//		LevelOrderInDiffLine2(root);
		
//		LevelOrderTraverseZZ(root);
		
		
//		makeMirror(root);
//		displayEuler(root);
//		removeLeaves(root);
//		System.out.println();
//		displayEuler(root);

//		Linearize(root);
//		displayEuler(root);
		
//		System.out.println(getElement(root,110));
		
//		ArrayList<Integer> so = nodeToRoot(root,110);
//		System.out.println(so);
		
//		System.out.println(distanceBetweenNodes(root,110,70));
		System.out.println(areSimilar(root,root));
			
	}

}
