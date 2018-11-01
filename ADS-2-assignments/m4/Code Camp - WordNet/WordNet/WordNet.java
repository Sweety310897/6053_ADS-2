import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.util.Scanner;
public class WordNet {

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        File synsets1 = new File("E:\\6053_ADS2\\6053_ADS-2\\ADS-2-assignments\\m4\\Code Camp - WordNet\\WordNet\\Files" + synsets);
        File hypernyms1 = new File("E:\\6053_ADS2\\6053_ADS-2\\ADS-2-assignments\\m4\\Code Camp - WordNet\\WordNet\\Files" + hypernyms);
        Scanner sc = new Scanner(synsets);
        Map map = new HashMap();
        
        int count = 0;
        while(sc.hasNext()) {
            String[] synsetsinput = sc.nextLine().split(",");
            count++;
            //map.put(synsetsinput[0],synsetsinput[1]);
        }
        Digraph g = new Digraph(count);
        Scanner sc1 = new Scanner(hypernyms);
        while(sc1.hasNext()) {
            String[] hypernymsinput = sc.nextLine().split(" ");
            g.addEdge(Integer.parseInt(hypernymsinput[0]),
                Integer.parseInt(hypernymsinput[1]));
        }
    }

    // returns all WordNet nouns
    // public Iterable<String> nouns()

    // // is the word a WordNet noun?
    // public boolean isNoun(String word)

    // // distance between nounA and nounB (defined below)
    // public int distance(String nounA, String nounB)

    // // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // // in a shortest ancestral path (defined below)
    // public String sap(String nounA, String nounB)

    // do unit testing of this class
    //public static void main(String[] args)
}
