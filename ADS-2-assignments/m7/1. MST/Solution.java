import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int vertices = Integer.parseInt(s.nextLine());
		int edges = Integer.parseInt(s.nextLine());
		EdgeWeightedGraph ewgraph = new EdgeWeightedGraph(vertices);
		//KruskalMST kruskal = new KruskalMST();
		while(s.hasNext()) {
			String[] temp = s.nextLine().split(" ");
			Edge edge = new Edge(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),
				Integer.parseInt(temp[2]));
			ewgraph.addEdge(edge);
		}
		LazyPrimMST prim = new LazyPrimMST(ewgraph);
		System.out.println(prim.weight());
	}
}