package GraphApplications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphPract {
	public static void main(String[] args) {
//		Graph graph = new Graph(5);
//		graph.addEdge(1, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(3, 5);
//		graph.addEdge(2, 5);
//		graph.addEdge(2, 4);
//		graph.addEdge(4, 5);
//		graph.addEdge(4, 6);
//		graph.addEdge(5, 6);

//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 0);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 3);

//		for (ArrayList<Integer> li : graph.arr) {
//			System.out.println(li);
//		}
//
//		System.out.println("The DFS is given below");
//		graph.dfs(2);
//
//		System.out.println("The BFS is given below");
//		graph.bfs();

//		Graph graph = new Graph(5);
//		System.out.println("The minimum spanning tree is below");
//		ArrayList<String> map = new ArrayList<String>();
//		map.add("A");
//		map.add("B");
//		map.add("C");
//		map.add("D");
//		map.add("E");
//		map.add("F");
//
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(0, 3);
//		graph.addEdge(0, 4);
//		graph.addEdge(1, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(1, 4);
//		graph.addEdge(2, 3);
//		graph.addEdge(2, 4);
//		graph.addEdge(3, 4);
//		System.out.println(graph.findThePath(0, 2, map));
//		graph.findThePath(0, 4, map);

//		Graph graph = new Graph(6);
//		System.out.println("To check if the graph undirectedd is connected or not");
//
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(2, 4);
//		graph.addEdge(3, 5);
//		graph.addEdge(4, 5);
//		graph.addEdge(4, 6);
//		System.out.println(graph.checkIfConnected(6));

//		Graph graph = new Graph(4);
//		System.out.println("To check if the directed graph is connected or not");
//		graph.addEdge(0, 1);
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 0);
//		graph.addEdge(0, 3);
//		graph.addEdge(3, 2);
//		
//		System.out.println(graph.checkIfDirectedConn(0));

//		Graph22 graph = new Graph22(9);
//		System.out.println("To count the connected components in an undireceted the graph.");
//
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(1, 3);
//
//		graph.addEdge(4, 5);
//		graph.addEdge(4, 6);
//		
//		graph.addEdge(7, 8);
//		System.out.println(graph.countConnectedComponenet());

//		Graph22 graph = new Graph22(9);
//		System.out.println("To check if source destination connected in undirected graph");
//		
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(1, 3);
//	    
//		graph.addEdge(4, 5);
//		graph.addEdge(4, 6);
//		
//		System.out.println(graph.sourceDestinConn(0,6));

		Graph22 graph = new Graph22(3);
		System.out.println("To check if the undirecetd graph has the cycle");

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		
		

	}
}

class Graph22 {
	ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
	boolean[] visited;

	Graph22(int size) {
		visited = new boolean[size];
		for (int i = 0; i < size; i++) {
			arr.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int node1, int node2) {
		arr.get(node1).add(node2);
		arr.get(node2).add(node1);
	}

	public void dfs(int val) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(val);
		visited[val] = true;
		int node = stack.peek();
		System.out.print(node + " ");
		while (!stack.isEmpty()) {
			node = stack.peek();
			int v = findTheNode(node);

			if (v == -1) {
				stack.pop();
			} else {
				stack.push(v);
				visited[v] = true;
				System.out.print(v + " ");
			}
		}
	}

	public void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		int node = queue.element();
		System.out.print(node + " ");

		while (!queue.isEmpty()) {
			// System.out.println("hi");
			node = queue.remove();
			ArrayList<Integer> list = getAllTheNodes(node);

			for (Integer li : list) {
				queue.add(li);
				visited[li] = true;
				System.out.print(li + " ");
			}

		}
	}

	public int findTheNode(int node) {
		for (int i = 0; i < arr.get(node).size(); i++) {
			if (visited[arr.get(node).get(i)] == false) {
				return arr.get(node).get(i);
			}
		}
		return -1;
	}

	public ArrayList<Integer> getAllTheNodes(int node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.get(node).size(); i++) {
			if (visited[arr.get(node).get(i)] == false) {
				list.add(arr.get(node).get(i));
			}
		}
		return list;
	}

	public String findThePath(int node1, int node2, ArrayList<String> map) {
		StringBuilder str = new StringBuilder();
		Stack<Integer> mstStack = new Stack<Integer>();

		mstStack.push(node1);
		visited[node1] = true;
		int node = mstStack.peek();
		// System.out.println(node+" ");

		while (!mstStack.isEmpty()) {
			node = mstStack.peek();
			int v = findTheNode(node);
			if (v == -1) {
				mstStack.pop();
			} else {
				// System.out.print(node);
				mstStack.push(v);
				visited[v] = true;
				// System.out.print(v);
				str.append(map.get(node) + "" + map.get(v) + " ");
				if (v == node2) {
					break;
				}
			}
			System.out.print(" ");
		}

		return str.toString();
	}

	public boolean checkIfConnected(int node1) {
		Stack<Integer> conStack = new Stack<Integer>();
		conStack.push(node1);
		visited[node1] = true;

		int node = conStack.peek();

		while (!conStack.isEmpty()) {
			node = conStack.peek();
			int v = findTheNode(node);

			if (v == -1) {
				conStack.pop();
			} else {
				conStack.push(v);
				visited[v] = true;
			}
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	public boolean checkIfDirectedConn(int node1) {
		for (int i = 0; i < arr.size(); i++) {
			checkIfConnected(i);
			for (int j = 0; j < visited.length; j++) {
				if (!visited[j]) {
					System.out.println(Arrays.toString(visited));
					System.out.println(i);
					return false;
				}
			}
			Arrays.fill(visited, false);
		}
		return true;
	}

	public int countConnectedComponenet() {
		int count = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (!visited[i]) {
				count = count + 1;
				checkIfConnected(i);
			}
		}
		return count;
	}

	public boolean sourceDestinConn(int source, int destination) {
		checkIfConnected(source);
		return visited[destination];
	}
	
	//to check if the cycle exists in iterative manner
	public boolean checkCycleUndirected(int node1) {
		Stack<Integer> cyclUndirStack=new Stack<Integer>();
		
		int node=0;
		cyclUndirStack.push(node1);
		visited[node1]=true;
		
		while(!cyclUndirStack.isEmpty()) {
			node=cyclUndirStack.peek();
			int v=findTheNode(node);
			
			if(v==-1) {
				cyclUndirStack.pop();
			}else {
				cyclUndirStack.push(v);
				visited[v]=true;
				if(findTheNodeCycle(v,node)) {
					return true;
				}
			}
			
			
		}
		return false;
	}
	
	public boolean findTheNodeCycle(int node,int parent) {
		for (int i = 0; i < arr.get(node).size(); i++) {
			if (visited[arr.get(node).get(i)] == true && ) {
				return arr.get(node).get(i);
			}
		}
		return false;
	}
}
