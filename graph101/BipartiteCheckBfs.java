package graph101;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BipartiteCheckBfs
{

	public boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int V)
	{
		int color[] = new int[V];
		for(int i = 0 ; i<V ; i++)
			color[i] = -1;
		
		for(int i = 0 ; i<V ; i++)
		{
			if(color[i]==-1)
				if(!bfsCheck(adj,i,color))
					return false;
			
		}
		return true;				
		
	}
	public boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node , int[] color)
	{
		color[node] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty())
		{
			Integer nd = q.poll();
			for(Integer it : adj.get(node))
			{
				if(color[it] == -1)
				{
					color[it] = 1-color[nd];
					q.add(it);
				}
				else if(color[it]==color[nd])
					return false;
			}
		}
		return true;
		
	}
}
