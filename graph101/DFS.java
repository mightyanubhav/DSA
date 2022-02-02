package graph101;
import java.util.ArrayList;
public class DFS
{
	
	public void dfs(int v, ArrayList<ArrayList<Integer>>adj)
	{
		boolean vis[] = new boolean[v];
		for(int i = 0 ; i<v ; i++)
		{
			if(!vis[i])
				dfsCheck(i, vis, adj);
		}
	}
	public void dfsCheck(int node, boolean vis[], ArrayList<ArrayList<Integer>>adj)
	{
		vis[node] = true;
		System.out.println(node);
		
		for(Integer it:adj.get(node))
		{
			if(!vis[it])
			{
				dfsCheck(it,vis,adj);
			}
		}
	}
}
