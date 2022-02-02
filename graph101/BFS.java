package graph101;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
public class BFS
{
	
	public void bfs(int v, ArrayList<ArrayList<Integer>> adj)
	{
		boolean vis[] = new boolean[v];
		for(int i = 0; i<v ; i++)
		{
			if(!vis[i])
			{
				Queue<Integer> q = new LinkedList<>();
				vis[i]=true;
				q.add(i);
				
				while(!q.isEmpty())
				{
					Integer node = q.poll();
					System.out.println(node+" ");
					for(Integer it : adj.get(node))
					{
						if(vis[it]==false)
						{
							q.add(it);
							vis[it]=true;
						}
					}
				}
				
			}
		}
	}
		 void bfs(int s,int v,LinkedList<Integer> adj[])
		    {
		        
		        boolean visited[] = new boolean[v];
		 
		       
		        LinkedList<Integer> queue = new LinkedList<Integer>();
		 
		        
		        visited[s]=true;
		        queue.add(s);
		 
		        while (queue.size() != 0)
		        {
		            
		            s = queue.poll();
		            System.out.print(s+" ");
		
		            Iterator<Integer> i = adj[s].listIterator();
		            while (i.hasNext())
		            {
		                int n = i.next();
		                if (!visited[n])
		                {
		                    visited[n] = true;
		                    queue.add(n);
		                }
		            }
		        }
		    }
}
