package GraphTRaversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph3 {
  List<List<Integer>> graph;
  boolean visited[];

  Graph3(int nodes) {
    graph = new ArrayList<>();
    visited = new boolean[nodes];

    for (int i = 0; i < nodes; i++) {
      graph.add(i, new ArrayList<>());
    }
  }

  public void addEdge(int a, int b) {
    graph.get(a).add(b);
    graph.get(b).add(a);
  }

  public void bfs(int startIndex) {
    Queue<Integer> queue = new LinkedList<>();

    queue.add(startIndex);
    visited[startIndex] = true;

    while (!queue.isEmpty()) {
      Integer node = queue.poll();
      System.out.print(node + " ");

      List<Integer> childList = graph.get(node);
      
      for (Integer child : childList) {
        if (!visited[child]) {
          queue.add(child);
          visited[child] = true;
        }
      }
    }
  }
}

public class GraphAdjListBFS {

	public static void main(String[] args) {
		int nodes = 6;

		Graph3 a = new Graph3(nodes);

		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(0, 3);
		a.addEdge(1, 4);
		a.addEdge(2, 4);
		a.addEdge(2, 5);
		a.addEdge(4, 5);

		a.bfs(0);
	}
}
