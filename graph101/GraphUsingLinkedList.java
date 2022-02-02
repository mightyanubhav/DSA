package graph101;
import java.util.LinkedList;
public class GraphUsingLinkedList
{
	int v;
	LinkedList<LinkedList<Integer>> adj;
	GraphUsingLinkedList(int v){
		this.v = v;
		adj = new LinkedList<>();
		
		for(int i = 0;i<v ; i++)
		{
			adj.add(new LinkedList<Integer>()) ;
		}
		
	}
	public void addEdge(int source, int destination)
	{
		adj.get(source).add(destination);
		adj.get(destination).add(source);
	}
	public void printLinkedList()
	{
		 for (int i = 0; i < adj.size(); ++i) {
			 	           
	            System.out.print(i + "->");
	 
	            for (int v : adj.get(i)) {
	               
	                System.out.print(v + " ");
	            }
	 	            
	            System.out.println();
	        }
	}
}
