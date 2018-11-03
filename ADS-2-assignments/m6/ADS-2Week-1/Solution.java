import java.util.ArrayList;
import java.io.File;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
class PageRank {
	Digraph dg;
	double pr;
	PageRank(Digraph g) {
		dg = g;
		System.out.println(dg.V() + "im cou");
		pr = (1/dg.V());
		System.out.println(pr);
		//dg.matRep();
		//System.out.println("hel");
		//return false;
		for(int i = 0; i < dg.V()-1; i++) {
			// for(int k: adj(i)) {
			// 	getPR(k);
			// }
			getPR(dg.V());
		}
		//for(int k:adj[])
		//System.out.println(pr);
	}
	public double getPR(int v) {

		double pr = 1/v;
		for(int i = 0; i < 1000; i++) {
			pr = pr/dg.outdegree(v);
		}
		//System.out.println(pr);
		return pr;
	}
	public String toString() {
		String str = "";
		//System.out.println("hi");
		for(int i = 0; i < dg.V()-1; i++) {
			str = str + dg.V() + "-" + getPR(dg.V()) + "\n";
		}
		return str;
	}
}

class WebSearch {
	HashMap<String, ArrayList<Integer>> h = new HashMap<String, ArrayList<Integer>>();
	WebSearch(PageRank rank, String filename) throws Exception {
		try {
		File obj = new File("WebContent/" + filename);
        Scanner fOne = new Scanner(obj);
        while(fOne.hasNextLine()) {
        	String[] tokens = fOne.nextLine().split(":");
        	String[] words = tokens[1].split(" ");
            for (int i = 0; i < words.length; i++) {
                if (h.containsKey(words[i])) {
                        ArrayList<Integer> arraylist = h.get(words[i]);
                        arraylist.add(Integer.parseInt(tokens[0]));
                } else {
                        ArrayList<Integer> arraylist = new ArrayList<Integer>();
                        arraylist.add(Integer.parseInt(tokens[0]));
                        h.put(words[i], arraylist);
                 }
            }

        }
    }catch(Exception e) {
    	System.out.println("Exception");
    }
	}
	// public int iAmFeelingLucky(String query) {
	// 	//String str1 = "";
	// 	for(int i = 0; i < h.size(); i++) {
	// 		if(h.containsKey(query[i])) {
	// 			return h.get(query[i]);
	// 		}
	// 		else {
	// 			return -1;
	// 		}
	// 	}
	// 	return 0;
	// }
}


public class Solution {
	public static void main(String[] args) throws Exception {
		// read the first line of the input to get the number of vertices
		Scanner s = new Scanner(System.in);
		int vertices = Integer.parseInt(s.nextLine());
		Digraph graph = new Digraph(vertices);
		try {


		while (s.hasNext()) {
            String[] n2 = s.nextLine().split(" ");//"0" "5"
            //System.out.println(Arrays.toString(n2));
            for(int i = 0; i < n2.length-1; i++) {
            graph.addEdge(Integer.parseInt(n2[0]),//0,5
                Integer.parseInt(n2[i]));
        	}
        }
        System.out.println(graph.toString());
    	//graph.matRep(vertices);
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
		String filetemp = "WebContent.txt";
		//String file = "E:\\6053_ADS2\\6053_ADS-2\\ADS-2-assignments\\m6\\ADS-2Week-1\\" + filetemp;

		//WebSearch search = new WebSearch(page,file);
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		} catch(Exception e) {
			System.out.println("Exception raised");
		}
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
