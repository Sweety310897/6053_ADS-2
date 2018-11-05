import java.util.Scanner;
import java.util.Arrays;
class PageRank {
	Digraph graph;
	Digraph reverse;
	double tempval;
	PageRank(Digraph graph) {
		this.graph = graph;
		this.reverse = graph.reverse();
		System.out.println(graph);

	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int vertices = Integer.parseInt(s.nextLine());
		Digraph dg = new Digraph(vertices);
		for(int i = 0; i < vertices; i++) {
			String[] temp = s.nextLine().split(" ");
			//System.out.println(Arrays.toString(temp));
			if(temp.length == 1) {
				for(int j = 0; j < vertices; j++) {
					//System.out.println(i + " " + "j" +  j);
					dg.addEdge(i,j);
				}
			}
			else {
					for(int j = 0; j < temp.length; j++) {
						//System.out.println(temp.length + "templen");
						System.out.println("i" + i +" " +j +"jva");
						//System.out.println(temp[0] + "temp0" + " " + temp[j] + "tempj");
						dg.addEdge(Integer.parseInt(temp[0]),Integer.parseInt(temp[j]));
					}	
			}
			
		}
		PageRank pg = new PageRank(dg);
	}
}