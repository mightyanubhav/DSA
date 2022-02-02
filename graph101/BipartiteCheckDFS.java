package graph101;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteCheckDFS
{

	public boolean checkBipartite(ArrayList<ArrayList<Integer>> adj , int V)
	{
		int color[] = new int[V];
		Arrays.fill(color, -1);
		
		for(int i = 0 ; i<V ;i++)
		{
			if(color[i]==-1)
				if(!dfsCheck(adj,color,i))
					return false;
		}
		return true;
	}
	public boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int color[],int node)
	{
		if(color[node]==-1)
			color[node]=1;
		
		
		for(Integer it:adj.get(node))
		{
			if(color[it]==-1)
			{
				color[it] = 1-color[node];
						
				if(!dfsCheck(adj, color, it))
					return false;
				
			}
			else if(color[it] == color[node])
				return false;
			
		}
		return true;
	}
	
	
}
