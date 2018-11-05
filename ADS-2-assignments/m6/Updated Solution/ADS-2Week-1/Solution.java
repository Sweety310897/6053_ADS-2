import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
class PageRank {
	Digraph d;
	double value;
	Digraph reverse;
	PageRank(Digraph d) {
		this.d = d;
		value = (d.V());
		reverse = d.reverse();
		System.out.println(d);
	}
	public double getPR(int x) {
		double pr = 1.0/value;
		return helperPr(pr,x);
	}
	public double helperPr(double pr, int x) {
		double[] prs = new double[d.V()];
		for(int i = 0; i < prs.length; i++) {
			prs[i] = pr;
			//System.out.println(pr);
		}
		double[] new_prs = new double[d.V()];
		for(int i = 0; i < prs.length; i++) {
			new_prs[i] = prs[i];
			System.out.println(prs[i]);
		}
		for(int iteration = 0; iteration < 1000; iteration++) {
			for(int i = 0; i < prs.length; i++) {
				prs[i] = new_prs[i];
			}
			for(int j = 0; j < d.V(); j++) {
				Iterable<Integer> it = reverse.adj(j);
				double cal = 0.0;
				for(Integer i : it) {
					cal += prs[i]/d.outdegree(i);
				}
				new_prs[j] = cal;
			}
		}
		return new_prs[x];
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
		for(int i = 0; i < vertices; i++) {
			System.out.println(i + " - " + pg.getPR(i));
		}
	}
}