import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class WordNet {
	HashMap<String,ArrayList<Integer>> hm = new HashMap<String,ArrayList<Integer>>();
    HashMap<Integer,String> hm2 = new HashMap<Integer,String>();
    Digraph graph;
    SAP  sapObj;
    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        File fileobj1 = new File(synsets);
        File fileobj2 = new File(hypernyms);
        Scanner s1 = new Scanner("E:\\6053_ADS2\\6053_ADS-2\\ADS-2-assignments\\m4\\Code Camp - WordNet\\WordNet\\Files" + fileobj1);
        Scanner s2 = new Scanner("E:\\6053_ADS2\\6053_ADS-2\\ADS-2-assignments\\m4\\Code Camp - WordNet\\WordNet\\Files" + fileobj2);
        // Scanner s1 = new Scanner(new File("Files/" + synsets));
        // Scanner s2 = new Scanner(new File("Files/" + hypernyms));
        while(s1.hasNextLine()) {
            //System.out.println("hi");
        	String[] input = s1.nextLine().split(",");
        	hm2.put(Integer.parseInt(input[0]),input[1]);
        	String[] words = input[1].split(" ");
            System.out.println(Arrays.toString(words));
        	for(int i = 0; i < words.length; i++) {
        		if(hm.containsKey(words[i])) {
        			ArrayList<Integer> arr = hm.get(words[i]);
        			arr.add(Integer.parseInt(input[0]));
        		} else {
        			ArrayList<Integer> arr1 = new ArrayList<Integer>();
        			arr1.add(Integer.parseInt(input[0]));
        			hm.put(words[i],arr1);
        		}
        	}
        }
        graph = new Digraph(hm.size());
        while(s2.hasNextLine()) {
        	String[] input1 = s2.nextLine().split(",");
        	for(int i = 1; i <input1.length; i++) {
        		graph.addEdge(Integer.parseInt(input1[0]),Integer.parseInt(input1[i]));
        	}
        }

    }

    // returns all WordNet nouns
    // public Iterable<String> nouns()

    // // is the word a WordNet noun?
    // public boolean isNoun(String word)

    // // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
    	ArrayList id1 = hm.get(nounA);
    	ArrayList id2 = hm.get(nounB);
    	sapObj = new SAP(graph);
    	return sapObj.length(id1,id2);
    	
    }

    // // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
    	ArrayList id1 = hm.get(nounA);
    	ArrayList id2 = hm.get(nounB);
    	sapObj = new SAP(graph);
    	int ans =  sapObj.ancestor(id1,id2);
    	return hm2.get(ans);
    }

    // do unit testing of this class
    //public static void main(String[] args)
}
