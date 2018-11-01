import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int vertices = scan.nextInt();
		int edges = scan.nextInt();
		Graph g = new Graph(vertices);
		while (edges > 0) {
            String[] input = scan.nextLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            g.addEdge(v, w);
            edges--;
        }
        Bipartite bi = new Bipartite(g);
        if (bi.isBipartite()) {
            System.out.println("Graph is bipartite");
        } else {
            System.out.println("Graph is not a bipartite");
        }
	}
}