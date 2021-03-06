  package GraphApplications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//here we are using the adjacency list.
//topological sort in directed graph.
//for topological sort starting point should be there.
//find the incoming degree for each of the nodes.
//for 0 there will be no incoming edge.
//after completing 0 we will remove its edges.
//then we will add the next edges with incoming 0.
class Graph7 {
  List<List<Integer>> graph;
  HashMap<Integer, Integer> incomingDegree;//we are using the hashmap to calculate the incoming degree.
  int nodes;
  Queue<Integer> sourceQueue;

  Graph7(int nodes) {
    graph = new ArrayList<>();
    incomingDegree = new HashMap<>();
    sourceQueue = new LinkedList<>();
    this.nodes = nodes;
    

    for (int i = 0; i < nodes; i++) {
      graph.add(i, new ArrayList<>());
      incomingDegree.put(i, 0);
    }
  }

  public void addEdge(int a, int b) {
    graph.get(a).add(b);
    incomingDegree.put(b, incomingDegree.get(b) + 1);
  }
 //here we are using bfs for the topological sort.
  public List<Integer> topologicalSort() {

    for(Map.Entry<Integer, Integer> entry: incomingDegree.entrySet()) {
      if(entry.getValue() == 0) {
        sourceQueue.add(entry.getKey());
      }
    }
    
    List<Integer> result = new ArrayList<>();
    
    while(!sourceQueue.isEmpty()) {
      int source = sourceQueue.remove();
      result.add(source);
      
      List<Integer> childrenList = graph.get(source);
      
      for(Integer child: childrenList) {
        incomingDegree.put(child, incomingDegree.get(child) - 1);//for each children reduce the incoming degree.
        
        if(incomingDegree.get(child) == 0) {//if the incoming degree becomes 0 then only add it to the queue.
          sourceQueue.add(child);
        }
      }
    }
    
    if(result.size() != nodes) {//condition for checking the cycle.
      System.out.println("Cycle is there in graph");
      return new ArrayList<>();
    }
    
    return result;
  }
 
}

public class TopoSortDir {

	public static void main(String[] args) {
	    int nodes = 6;
	    
	    Graph7 a = new Graph7(nodes);
	    
	    a.addEdge(0, 1);
	    a.addEdge(0, 2);
	    a.addEdge(1, 3);
	    a.addEdge(1, 4);
	    a.addEdge(2, 4);
	    a.addEdge(3, 5);
	    a.addEdge(4, 5);
	    
	    System.out.println(a.topologicalSort());
	  }

}
