import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int vertices = scan.nextInt();
		GraphRep g = new GraphRep(vertices);
		int edges = scan.nextInt();
		Cycle finder = new Cycle(g);
		scan.nextLine();
		while(scan.hasNext()) {
			String[] temp = scan.nextLine().split(" ");
			//System.out.println("hi");
			//System.out.println(temp[0]);
			//System.out.println("hi");
			g.addEdge(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
			//System.out.println("hello");
		}
        //In in = new In(args[0]);
        //Graph G = new Graph(in);
        
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        else {
            System.out.println("Cycle doesn't exists.");
        }
    
		
	}
}