import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = Integer.parseInt(sc.nextLine());
        Digraph g = new Digraph(v);
        int e = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            //String tokens = sc.nextLine();
            String[] input = sc.nextLine().split(" ");
            g.addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        Cycle c = new Cycle(g);
        if (c.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");
        }
    }
}





