import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//comstructor.
	}
	/**
	 * main.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		int vertices = Integer.parseInt(s.nextLine());
		int edges = Integer.parseInt(s.nextLine());
		EdgeWeightedGraph ewgraph = new EdgeWeightedGraph(vertices);
		//KruskalMST kruskal = new KruskalMST();
		//s.nextLine();
		try {
		while(s.hasNext()) {
			String[] temp = s.nextLine().split(" ");
			Edge edge = new Edge(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),
				Float.parseFloat(temp[2]));
			ewgraph.addEdge(edge);
		} 
	}catch(Exception e) {
			System.out.println("Exception occured in wile");
		}
		LazyPrimMST prim = new LazyPrimMST(ewgraph);
		System.out.format("%.5f",prim.weight());
	}
}