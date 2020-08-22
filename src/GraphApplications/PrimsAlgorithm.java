package GraphApplications;

//find the minimum spanning tree from a weighted graph.
//minimum cost to cover all the nodes.
//here we are using the adjacency list to to represent the graph.
//we make a min heap from the priority queue.

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge2 {
	int targetNode;
	int distanceFromNode;

	Edge2(int targetNode, int distance) {
		this.targetNode = targetNode;
		this.distanceFromNode = distance;
	}
}

class Graph12 {
	List<List<Edge2>> graph;
	boolean visited[];
	int nodes;

	Graph12(int nodes) {
		graph = new ArrayList<>();
		visited = new boolean[nodes];
		this.nodes = nodes;

		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
		}
	}

	public void addEdge(int sourceNode, int targetNode, int distance) {
		graph.get(sourceNode).add(new Edge2(targetNode, distance));  xq	
		graph.get(targetNode).add(new Edge2(sourceNode, distance));
	}

	public int mst() {
		int minCost = 0;
        
		//minimum spanning tree must cover all the nodes thus even if some unconnected nodes are there
		//then also the cost will get added.
		for (int i = 0; i < nodes; i++) {
			if (!visited[i]) {
				minCost = minCost + minimumSpanningTreeUnweightedGraph(i);
			}
		}

		return minCost;
	}

	public int minimumSpanningTreeUnweightedGraph(int source) {

		PriorityQueue<Edge2> minEdgeHeap = new PriorityQueue<>((e1, e2) -> e1.distanceFromNode - e2.distanceFromNode);

		visited[source] = true;
		List<Edge2> childOfSource = graph.get(source);
        //we will add the nodes for this source to the heap.
		for (Edge2 edge : childOfSource) {
			minEdgeHeap.add(edge);
		}

		int minimumCost = 0;
		while (!minEdgeHeap.isEmpty()) {

			Edge2 minValueEdge = minEdgeHeap.poll();

			if (visited[minValueEdge.targetNode]) {
				continue;
			}

			visited[minValueEdge.targetNode] = true;

			minimumCost = minimumCost + minValueEdge.distanceFromNode;

			List<Edge2> childList = graph.get(minValueEdge.targetNode);

			for (Edge2 edge : childList) {
				if (!visited[edge.targetNode]) {
					minEdgeHeap.add(edge);
				}
			}
		}

		return minimumCost;
	}
}

public class PrimsAlgorithm {

	public static void main(String[] args) {
		int nodes = 5;

		Graph12 a = new Graph12(nodes);

		a.addEdge(0, 1, 6);
		a.addEdge(0, 3, 4);
		a.addEdge(1, 2, 10);
		a.addEdge(1, 3, 7);
		a.addEdge(1, 4, 7);
		a.addEdge(2, 3, 8);
		a.addEdge(2, 4, 5);
		a.addEdge(3, 4, 12);

		System.out.println(a.mst());
	}
}
