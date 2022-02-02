package graph101;

public class Test
{
	public static void main(String[]args)
	{
		int v = 5;
		GraphUsingArrayList g = new GraphUsingArrayList(v);
//		GraphUsingLinkedList g = new GraphUsingLinkedList(v);
		
			g.addEdge(0, 1);
	        g.addEdge(0, 4);
	        g.addEdge(1, 2);
	        g.addEdge(1, 3);
	        g.addEdge(1, 4);
	        g.addEdge(2, 3);
	        g.addEdge(3, 4);
//	        g.printAdjList();
//	        g.printLinkedList();
	        
	        
//	        BFS b = new BFS();
//	        b.bfs(v, g.giveAdj());
	        
//	        DFS d = new DFS();
//	        d.dfs(v, g.giveAdj());
	        
//	        CycleDetection c = new CycleDetection();
//	        System.out.println(c.cycleDector(v, g.giveAdj()));
	        
//	        CycleDectViaDfs c = new CycleDectViaDfs();
//	        System.out.println(c.isCycle(v, g.giveAdj()));
	       
	        BipartiteCheckDFS c = new BipartiteCheckDFS();
	        System.out.println(c.checkBipartite(g.giveAdj(), v));
	        
	        
	}
}
