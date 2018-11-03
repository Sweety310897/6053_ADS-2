import java.util.Scanner;
import java.util.Arrays;
class PageRank {
	Digraph dg;
	double pr;
	PageRank(Digraph g) {
		dg = g;
		pr = 1/dg.V();
		for(int i = 0; i < dg.V()-1; i++) {
			getPR(dg.V());
		}
		System.out.println("im");
		//System.out.println(pr);
	}
	public double getPR(int v) {

		double pr = 1/v;
		for(int i = 0; i < 1000; i++) {
			pr = pr/dg.outdegree(v);
		}
		return pr;
	}
	public String toString() {
		String str = "";
		System.out.println("hi");
		for(int i = 0; i < dg.V()-1; i++) {
			str = str + dg.V() + "-" + getPR(dg.V()) + "\n";
		}
		return str;
	}
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner s = new Scanner(System.in);
		int vertices = Integer.parseInt(s.nextLine());
		Digraph graph = new Digraph(vertices);
		while (s.hasNext()) {
            String[] n2 = s.nextLine().split(" ");//"0" "5"
            //System.out.println(Arrays.toString(n2));

            graph.addEdge(Integer.parseInt(n2[0]),//0,5
                Integer.parseInt(n2[1]));
        }
        System.out.println(graph.toString());
    	//System.out.println("hi");
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		PageRank page = new PageRank(graph);
		//System.out.println("hi");
		//page.toString();
		//System.out.println(page);
		// Create page rank object and pass the graph object to the constructor
		
		// print the page rank object
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
