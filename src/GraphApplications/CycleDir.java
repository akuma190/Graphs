package GraphApplications;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph6 {
  List<List<Integer>> graph;
  boolean visited[], recursiveStack[];
  int nodes;

  Graph6(int nodes) {
    graph = new ArrayList<>();
    visited = new boolean[nodes];
    recursiveStack = new boolean[nodes];
    this.nodes = nodes;

    for (int i = 0; i < nodes; i++) {
      graph.add(i, new ArrayList<>());
    }
  }

  public void addEdge(int a, int b) {
    graph.get(a).add(b);
  }

  public boolean ifDirectedGraphHasCycle() {

    for (int i = 0; i < nodes; i++) {
      if(ifCycleExists(i)) {
        return true;
      }
    }

    return false;
  }
  
  public boolean ifCycleExists(int index) {
    if(recursiveStack[index]) {
      return true;
    }
    
    if(visited[index]) {
      return false;
    }
    
    visited[index] = true;
    recursiveStack[index] = true;

    List<Integer> neighboursList = graph.get(index);

    for (Integer neighbour : neighboursList) {
      if (ifCycleExists(neighbour)) {
        return true;
      } 
    }
    
    recursiveStack[index] = false;
    return false;
  }
}

public class CycleDir {

	public static void main(String[] args) {
	    int nodes = 5;

	    Graph6 a = new Graph6(nodes);

	    a.addEdge(0, 1);
	    a.addEdge(1, 2);
	    a.addEdge(2, 0);
	    a.addEdge(0, 3);
	    a.addEdge(3, 4);
	    a.addEdge(4, 0);
	    
	    System.out.println(a.ifDirectedGraphHasCycle());
	  }

}
