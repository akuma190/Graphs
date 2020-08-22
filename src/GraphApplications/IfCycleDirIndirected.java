package GraphApplications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//if there is nor node whose incoming degeree is zero then cycle will definitely exist in the graph.
//if a node is having value zero then put that in the queue.decrease the the count of all its childer by removing it.
//if the count reduces to o after removing then add to the queue. 
//if at any point no node is having 0 then cycle will exist.
//visited count becomes equal to the total nodes then no cycle.
class Graph9 {
	List<List<Integer>> graph;
	HashMap<Integer, Integer> incomingDegree;
	int visitedNodes;
	int nodes;
	Queue<Integer> sourceQueue;

	Graph9(int nodes) {
		graph = new ArrayList<>();
		incomingDegree = new HashMap<>();
		sourceQueue = new LinkedList<>();
		this.nodes = nodes;
		visitedNodes = 0;

		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());//adding the graph and incoming degree.
			incomingDegree.put(i, 0);
		}
	}

	public void addEdge(int a, int b) {
		graph.get(a).add(b);//increasing the incoming degree here.
		incomingDegree.put(b, incomingDegree.get(b) + 1);
	}

	public boolean checkIfGraphHasCycle() {

		for (Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()) {
			if (entry.getValue() == 0) {
				sourceQueue.add(entry.getKey());
			}
		}

		while (!sourceQueue.isEmpty()) {
			visitedNodes++;
			int source = sourceQueue.remove();

			List<Integer> childrenList = graph.get(source);

			for (Integer child : childrenList) {
				incomingDegree.put(child, incomingDegree.get(child) - 1);
                //decreasing the incoming degree of the children by -1
				if (incomingDegree.get(child) == 0) {
					sourceQueue.add(child);
				}
			}
		}

		return nodes != visitedNodes;//if nodes are not eqal to visited count then some nodes are left with incoming degree not zero
		//hence cycle exists.
	}

}

public class IfCycleDirIndirected {

	public static void main(String[] args) {
		int nodes = 4;//we have total 4 nodes.

		Graph9 a = new Graph9(nodes);

		a.addEdge(0, 1);
		a.addEdge(1, 2);
		a.addEdge(2, 0);
		a.addEdge(3, 0);

		System.out.println(a.checkIfGraphHasCycle());
	}

}
