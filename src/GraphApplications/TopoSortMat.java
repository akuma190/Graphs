package GraphApplications;
//Topological sort using the adjacency matrix for the directed graph.
//Even the directed graph should be acyclic there should not be the cycle.
class Vertex {
	  public char label;
	  public Vertex(char lab) {
	    label = lab;
	  }
	}

	class Graph8 {

	  private final int MAX_SIZE = 10;
	  private Vertex vertexList[];
	  private int adjList[][];
	  private int nVerts;
	  private char sortedArray[]; 
	  
	  public Graph8() {
	    vertexList = new Vertex[MAX_SIZE];
	    adjList = new int[MAX_SIZE][MAX_SIZE];
	    nVerts = 0;
	    sortedArray = new char[MAX_SIZE];
	  }
	  
	  public void addVertex(char lab) {
	    vertexList[nVerts++] = new Vertex(lab);
	  }
	  
	  public void addEdge(int start, int end) {
	    adjList[start][end] = 1;
	  }
	  
	  public void displayVertex(int v) {
	    System.out.println(vertexList[v].label);
	  }
	  
	  public void topo() {
	    int orig_nVerts = nVerts;
	    
	    while(nVerts>0) {
	      int currentVertex = noSuccessors();//finding the value which has no successor.
	      if(currentVertex == -1) {
	        System.out.println("Error: Graph has cycle");
	        return;
	      }
	      
	      //we will fill from the end and add H to the last.
	      sortedArray[nVerts-1] = vertexList[currentVertex].label;
	      
	      deleteVertex(currentVertex);
	      
	    }
	    
	    System.out.println("Topologically Sorted order: ");
	    for(int j=0; j<orig_nVerts; j++) {
	      System.out.print(sortedArray[j]);
	    }
	    System.out.println("");
	  }
	  
	  public int noSuccessors() {
	    boolean isEdge;
	    
	    for(int row=0; row<nVerts; row++) {//finding a value for which the row and column are zero.
	      isEdge = false;
	      for(int col=0; col<nVerts; col++) {
	        if(adjList[row][col] > 0) {
	          isEdge = true;
	          break;
	        }
	      }
	      if(!isEdge) //if row and col is not >0 then that rwo will be returned.
	        return row;
	    }  
	    return -1;
	  }
	  
	  public void deleteVertex(int delVert) {
	    if(delVert!= nVerts-1) {        // if not last vertex,
	      for(int j=delVert; j<nVerts-1; j++)        // delete from vertexList
	        vertexList[j] = vertexList[j+1];
	      
	      for(int row=delVert; row<nVerts-1; row++)    // delete row from adjMat
	        moveRowUp(row, nVerts);
	      
	      for(int col=delVert; col<nVerts-1; col++)     // delete col from adjMat
	        moveColLeft(col, nVerts-1);
	    }
	    nVerts--;        // one less vertex
	  }
	  
	  private void moveRowUp(int row, int length) {
	    for(int col=0; col<length; col++) 
	      adjList[row][col] = adjList[row+1][col];
	  }
	  
	  private void moveColLeft(int col, int length)
	  {
	    for(int row=0; row<length; row++)
	      adjList[row][col] = adjList[row][col+1];
	  
	  } 
	}

public class TopoSortMat {

	public static void main(String[] args) {
		  
	    Graph8 theGraph = new Graph8();
	    theGraph.addVertex('A'); 
	    theGraph.addVertex('B'); 
	    theGraph.addVertex('C'); 
	    theGraph.addVertex('D'); 
	    theGraph.addVertex('E'); 
	    theGraph.addVertex('F'); 
	    theGraph.addVertex('G'); 
	    theGraph.addVertex('H'); 
	    
	    theGraph.addEdge(0, 3); // AD
	    theGraph.addEdge(0, 4); // AE
	    theGraph.addEdge(1, 4); // BE
	    theGraph.addEdge(2, 5); // CF
	    theGraph.addEdge(3, 6); // DG
	    theGraph.addEdge(4, 6); // EG
	    theGraph.addEdge(5, 7); // FH
	    theGraph.addEdge(6, 7); // GH
	    theGraph.topo(); // do the sort
	  }

}
