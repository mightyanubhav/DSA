package graph101;
import java.util.ArrayList;
class GraphUsingArrayList
{
	public  int v;
	public  ArrayList<ArrayList<Integer>>adj;
	
	public GraphUsingArrayList(int Vertex)
	{
		v=Vertex;
		adj= new ArrayList<ArrayList<Integer>>(v);
		
		for(int i = 0; i<v ; i++)
		{
			adj.add(new ArrayList<Integer>());
		}
	}
	public void addEdge(int u , int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
		
	}
	public void printAdjList()
	{
		for(int i =0 ;i<adj.size(); i++)
		{
			System.out.println("Adj list of "+i);
			for(int j=0 ; j<adj.get(i).size(); j++)
				System.out.print(adj.get(i).get(j)+" ");
			
			System.out.println();
		}
	}
	public ArrayList<ArrayList<Integer>> giveAdj()
	{
		return adj;
	}

}

