package GraphApplications;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//to check if the source and destination are connected in a directed graph.
//apply the depth first search on the source.
//if the viiting destion comes in the traversal then we will use true.
class Graph3 {
  List<List<Integer>> graph;
  boolean visited[];
  int nodes;

  Graph3(int nodes) {
    graph = new ArrayList<>();
    visited = new boolean[nodes];
    this.nodes = nodes;

    for (int i = 0; i < nodes; i++) {
      graph.add(i, new ArrayList<>());
    }
  }

  public void addEdge(int a, int b) {
    graph.get(a).add(b);
    graph.get(b).add(a);
  }
  
  public boolean ifSourceConnectedToDestination(int source, int destination) {

    dfs(source);
    
    return visited[destination];
  }

  public void dfs(int start) {
    Stack<Integer> stack = new Stack<>();
    
    stack.push(start);
    visited[start] = true;
    
    while(!stack.isEmpty()) {
      Integer node = stack.pop();
      
      List<Integer> neighboursList = graph.get(node);
      
      for(Integer neighbour: neighboursList) {
        if(!visited[neighbour]) {
          stack.push(neighbour);
          visited[neighbour] = true;
        }
      }
    }
  }
  
  public void dfsAnother(int start) {
    visited[start] = true;

    List<Integer> neighboursList = graph.get(start);

    for (Integer neighbour : neighboursList) {
      if (!visited[neighbour]) {
        dfsAnother(neighbour);
      }
    }
  }
}

public class SourceDestinationConnected {

	public static void main(String[] args) {
	    int nodes = 7;
	    
	    Graph3 a = new Graph3(nodes);
	    
	    a.addEdge(0, 1);
	    a.addEdge(0, 2);
	    a.addEdge(1, 3);
	    
	    a.addEdge(4, 5);
	    a.addEdge(4, 6);

	    System.out.println(a.ifSourceConnectedToDestination(0, 5));
	  }

}
