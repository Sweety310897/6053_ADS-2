import java.util.Scanner;
public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int vertices = scan.nextInt();
		GraphRep g = new GraphRep(vertices);
		Cycle finder = new Cycle(g);
		int edges = scan.nextInt();
		scan.nextLine();
		while(scan.hasNext()) {
			String[] temp = scan.nextLine().split(" ");
			
			g.addEdge(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
			System.out.println(temp[0] + "temp0" + temp[1] + "temp1");
			//System.out.println("hello");
		}
		//g.matrixRep(vertices, edges);
        //In in = new In(args[0]);
        //Graph G = new Graph(in);
        
        if (finder.hasCycle()) {
            // for (int v : finder.cycle()) {
            //     //System.out.print(v + " " + "hi");
            //     System.out.println("Cycle exists.");
            // }
            System.out.println("Cycle exists.");
        }
        else {
            System.out.println("Cycle doesn't exists.");
        }
    
		
	}
}