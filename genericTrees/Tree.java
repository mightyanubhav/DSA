package genericTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;


// Multisolver
public class Tree {
	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
		
	}

	static int size;
	static int min ;
	static int max ;
	static int height;
	public static void main(String[] args) {

		int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
		Node root = null;

		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node t = new Node();
				t.data = arr[i];

				if (st.size() > 0) {
					st.peek().children.add(t);
				} else {
					root = t;
				}
				st.add(t);

			}
		}
//		display(root);

		size = 0 ;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		height = 0 ;
		multisolver(root, 0);
	
		System.out.println(size+" " + min + "  " + max+ " " + height);
		
		ciel = Integer.MAX_VALUE;
		floor = Integer.MIN_VALUE	;
		
		cielAndFloor(root,72);
		System.out.println(ciel + " " + floor);
	}
	public static void multisolver(Node node, int depth)
	{
		size++;
		min = Math.min(min, node.data);
		max = Math.max(node.data, max);
		height = Math.max(depth, height);
		
		for(Node child : node.children)
			multisolver(child, depth+1);
	}
	static Node predecessor;
	static Node successor;
	static int state;
	public static void predecessorAndSuccessor(Node node, int data)
	{
		if(state == 0)
		{
			if(node.data == data)
				state = 1;
			else
				predecessor = node;
		}
		else if(state == 1)
		{
			successor = node;
			state = 2;
		}
		for(Node child : node.children)
		{
			predecessorAndSuccessor(child,data);
		}
	}
	
	
	static int ciel;
	static int floor;
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
		for(Node child : node.children)
		{
			cielAndFloor(child, data);
		}
	}
	public static void display(Node node) {
		String st = node.data + "-->";
		for (Node x : node.children) {
			st = st + x.data + " ";
		}
		System.out.println(st);

		for (Node x : node.children) {
			display(x);
		}
		
		
	}
	
}
