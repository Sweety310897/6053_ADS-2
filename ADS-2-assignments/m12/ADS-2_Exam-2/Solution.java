import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//constructor.
	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner s = new Scanner(System.in);
		int vertices = Integer.parseInt(s.nextLine());
		int edges = Integer.parseInt(s.nextLine());
		//System.out.println(vertices + " " + "vertices" + " " + edges + " " + "edges");
		//EdgeWeightedGraph g = new EdgeWeightedGraph(vertices);
		EdgeWeightedGraph ewgraph = new EdgeWeightedGraph(vertices);
		//EdgeWeightedDiGraph ewdigraph = new EdgeWeightedDiGraph(vertices);
		for (int i = 0; i < edges; i++) {

			String[] temp = s.nextLine().split(" ");
			Edge edge = new Edge(Integer.parseInt(temp[0]),
                Integer.parseInt(temp[1]),
                Float.parseFloat(temp[2]));
            ewgraph.addEdge(edge);

		}
		LazyPrimMST prim = new LazyPrimMST(ewgraph);
		//String temp = s.nextLine();
		String caseToGo = s.nextLine();
		switch (caseToGo) {
			//time complexity - O(n^2) for matrix.
			//O(E+v) - for adjacency list representation.
		case "Graph":
			//Print the Graph Object.
			System.out.println(ewgraph.toString());
			break;

		case "DirectedPaths":

			String[] temp5 = s.nextLine().split(" ");

			DijkstraUndirectedSP dj = new DijkstraUndirectedSP(ewgraph,Integer.parseInt(temp5[0]));
            if (dj.hasPathTo(Integer.parseInt(temp5[1]))) {
                //StdOut.println("%d to %d (%.2f)  ", s, t, dj.distTo(t));
                System.out.println(dj.distTo(Integer.parseInt(temp5[1])));
            }
            else {
                //StdOut.printf("%d to %d         no path\n", s, t);
                System.out.println("No Path Found.");
                return;
            }
        
			
        
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			
			break;

		default:
			break;
		}

	}
}