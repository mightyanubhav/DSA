package graph101;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


class Node{
	int nod, par;
	Node(int nod,int par)
	{
		this.nod = nod;
		this.par = par;		
	}
}
public class CycleDetection 
{
	public boolean cycleDector(int V, ArrayList<ArrayList<Integer>> adj)
	{
		boolean vis[]= new boolean[V];
		for(int i = 0 ;i < V; i++)
		{
			if(!vis[i])
			{
				if(checkCycle(adj,i,vis))
					return true;				
			}
				
		}
		return false;
	}
	public boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int node , boolean vis[])
	{
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(node,-1));
		vis[node]=true;
		
		while(!q.isEmpty())
		{
			int par = q.peek().par;
			int nod = q.peek().nod;
			
			for(Integer it:adj.get(node))
			{
				if(!vis[it])
				{
					q.add(new Node(it,nod));
					vis[it]=true;					
				}
				else if(par != it)
					return true;
			}
			
		}
		return false;
	}
}
