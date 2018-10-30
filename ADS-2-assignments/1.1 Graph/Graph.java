import java.util.Arrays;
import java.io.*;
/**
 * Interface for graph.
 */
interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> arr(int v);
    public boolean hasEdge(int v, int w);
}
/**
 * Class for graph rep.
 */
class GraphRep implements Graph {
	int vertex;
    int edge;
    Bag<Integer>[] arr;
    /**
     * Constructs the object.
     */
    GraphRep() {

    }
    /**
     * Constructs the object.
     *
     * @param      ver   The version
     */
    public GraphRep(int ver) {
        this.vertex = ver;
        this.edge = 0;
        arr = (Bag<Integer>[]) new Bag[ver];
        for (int i = 0; i < vertex; i++) {
            arr[i] = new Bag<Integer>();
        }
    }
    /**
     * V().
     *
     * @return     vertex.
     */
	public int V() {
		return vertex;
    }
    /**
     * E().
     *
     * @return     edge.
     */
	public int E() {
		return edge;
    }
    /**
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> arr(int v) {
        return arr[v];
    }
    /**
     * Adds an edge.
     * time complexity - O(1).
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
	public void addEdge(int v, int w) {
		if (v == w) {
        	return;
        }
		if (!hasEdge(v,w)) {
            edge++;

            arr[v].add(w);
            arr[w].add(v); 
        }
    }
	/**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *time complexity - O(E)
     * @return     True if has edge, False otherwise.
     */
	public boolean hasEdge(int v, int w) {
		for(int k :arr[v]) {
				if (k==w) {
					return true;
				}
		}
		return false;
    }
    /**
     * matrix.
     *
     * @param      v          { parameter_description }
     * @param      e          { parameter_description }
     *time complexity - O(V^2).
     * @throws     Exception  { exception_description }
     */
    public void matrixRep(int v, int e) throws Exception {
    	if (e <= 1 && v <= 1) {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		throw new Exception("No edges");
    	} else {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		int[][] mat = new int[v][v];
    		for (int i = 0; i  < v; i++) {
    			for (int j = 0; j < v; j++) {
    				if (hasEdge(i, j)) {
    					mat[i][j] = 1;
		    		}
    			}
    		}
    		for (int i = 0; i < v; i++) {
    			for (int j = 0; j < v; j++) {
    				System.out.print(mat[i][j] + " ");
    			}
    			System.out.println();
    		}
    	}
    }
    /**
     * list rep.
     *
     * @param      v          { parameter_description }
     * @param      e          { parameter_description }
     * @param      n1         The n 1
     * time complexity - O(V+E).
     * @throws     Exception  { exception_description }
     */
    public void listRep(int v, int e, String[] n1) throws Exception {
    	if (e <= 1 && v <= 1) {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		throw new Exception("No edges");
    	} else {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		for (int i = 0; i < n1.length; i++) {
				String str = "";
				str = n1[i] + ": ";
				//System.out.println(str);
				for (int k : arr(i)) {
					//System.out.println((arr(i)) + "arr");
					str = str + n1[k] + " ";
					//System.out.println(str + "this is in for loop");
				}
				System.out.println(str);
			}
    	}
    }
}