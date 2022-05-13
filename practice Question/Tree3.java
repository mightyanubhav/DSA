package genericTrees;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
public class Tree3 
{
	private static class Node
	{
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	
	static int size, min , max , height;
	public static void multisolver(Node node, int depth)
	{
		size ++	;
		min = Math.min(node.data, min);
		max = Math.max(node.data, max);
		height = Math.max(depth, height);
		
		for(Node child : node.children)
			multisolver(child, depth+1);
	}
	
	static Node successor, predecessor;
	static int state;
	public static void findPreAndSuccS(Node node , int data)
	{
		if(state == 0 )
		{
			if(node.data == data)
			{
				state = 1;
				
			}
			else
				predecessor = node;
		}
		else if(state ==1)
		{
			successor = node;
			state = 2;
		}
		for(Node child : node.children)
			findPreAndSuccS(child, data);
	}
	static int ciel  , floor ;
	public static void cielAndFloor(Node node, int data)
	{
		if(node.data>data)
		{
			if(node.data<ciel)
				ciel = node.data;
		}
		if(node.data<data)
		{
			if(node.data>floor)
				floor = node.data;
		}
	}
	public static void main(String args[])
	{
		int arr[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=null;
		Stack<Node> st = new Stack<>();
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
		
//		size = 0;
//		min = Integer.MAX_VALUE	;
//		max = Integer.MIN_VALUE	;
//		height = 0;
		
//		multisolver(root, 0);
//		System.out.println(size);
//		System.out.println(max);
//		System.out.println(height);
//		System.out.println(min);
		
		
//		findPreAndSuccS(root, 50);
//		System.out.println(successor.data+ " " +predecessor.data);
		
		ciel = Integer.MAX_VALUE;
		floor = Integer.MIN_VALUE;
		cielAndFloor(root,65);
		System.out.println(ciel + "  " + floor);
		
		
	}
	private static class Pair
	{
		Node node;
		int state;
		Pair(Node n , int s)
		{
			node= n;
			state = s;
		}
	}
	public static void iterativePreAndPost(Node node) 
	{
		
	}
	public static void display(Node root)
	{
		String st = root.data+"-->";
		for(Node child : root.children)
			st = st+child.data + " ";
		
		System.out.println(st);
		for(Node child : root.children)
			display(child);
		
		
		
	}
}
