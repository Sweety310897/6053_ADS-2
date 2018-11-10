import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner s = new Scanner(System.in);
		int vertices = Integer.parseInt(s.nextLine());
		int edges = Integer.parseInt(s.nextLine());
		System.out.println(vertices + " " + "vertices" + " " + edges + " " + "edges");
		//EdgeWeightedGraph g = new EdgeWeightedGraph(vertices);
		EdgeWeightedGraph ewgraph = new EdgeWeightedGraph(vertices);
		for (int i = 0; i < edges; i++) {

			String[] temp = s.nextLine().split(" ");
			Edge edge = new Edge(Integer.parseInt(temp[0]),
                Integer.parseInt(temp[1]),
                Float.parseFloat(temp[2]));
            ewgraph.addEdge(edge);

		}
		//String temp = s.nextLine();
		String caseToGo = s.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(ewgraph.toString());
			break;

		case "DirectedPaths":
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