import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
class PageRank {
	Digraph graph;
	Digraph reverse;
	double tempval;
	PageRank(Digraph graph) {
		this.graph = graph;
		//this.reverse = graph.reverse();
		System.out.println(graph);
		reverse = graph.reverse();
		for(int i = 0; i < graph.V()-1; i++) {
			// for(int k: adj(i)) {
			// 	getPR(k);
			// }
			getPR(graph.V());
		}

	}
	public double getPR(int v) {
		double pr = 1/v;
		for(int i = 1; i < 1000; i++) {
			pr = pr/graph.outdegree(v);
		}
		//System.out.println(pr);
		return pr;
	}
	public String toString() {
		String str = "";
		//System.out.println("hi");
		for(int i = 0; i < graph.V()-1; i++) {
			str = str + graph.V() + "-" + getPR(graph.V()) + "\n";
		}
		return str;
	}
}
// class WebSearch {
// 	HashMap<String, ArrayList<Integer>> h = new HashMap<String, ArrayList<Integer>>();
// 	WebSearch(PageRank rank, String filename) throws Exception {
// 		try {
// 		File obj = new File("WebContent/" + filename);
//         Scanner fOne = new Scanner(obj);
//         while(fOne.hasNextLine()) {
//         	String[] tokens = fOne.nextLine().split(":");
//         	String[] words = tokens[1].split(" ");
//             for (int i = 0; i < words.length; i++) {
//                 if (h.containsKey(words[i])) {
//                         ArrayList<Integer> arraylist = h.get(words[i]);
//                         arraylist.add(Integer.parseInt(tokens[0]));
//                 } else {
//                         ArrayList<Integer> arraylist = new ArrayList<Integer>();
//                         arraylist.add(Integer.parseInt(tokens[0]));
//                         h.put(words[i], arraylist);
//                  }
//             }

//         }
//     }catch(Exception e) {
//     	System.out.println("Exception");
//     }
// 	}
// }


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
					for(int j = 1; j < temp.length; j++) {
						//System.out.println(temp.length + "templen");
						//System.out.println("i" + i +" " +j +"jva");
						//System.out.println(temp[0] + "temp0" + " " + temp[j] + "tempj");
						dg.addEdge(Integer.parseInt(temp[0]),Integer.parseInt(temp[j]));
					}	
			}
			
		}
		PageRank pg = new PageRank(dg);
	}
}