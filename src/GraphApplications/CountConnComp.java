package GraphApplications;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//to find the number of connected components in a graph.
class Graph2 {
  List<List<Integer>> graph;
  boolean visited[];
  int nodes;

  Graph2(int nodes) {
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
  
  public int numberOfConnectedComponent() {
    int numberOfConnectedComponent = 0;
    
    for(int i = 0; i < nodes; i++) {
      if(!visited[i]) {//If the node is not connected after the first iteration dfs will be called and count will increase.
        dfs(i);
        numberOfConnectedComponent++;
      }
    }
    
    return numberOfConnectedComponent;
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
}

public class CountConnComp {

  public static void main(String[] args) {
    int nodes = 7;
    
    Graph2 a = new Graph2(nodes);
    
    a.addEdge(0, 1);
    a.addEdge(0, 2);
    a.addEdge(1, 3);
    
    a.addEdge(4, 5);
    a.addEdge(4, 6);

    System.out.println(a.numberOfConnectedComponent());
  }

}