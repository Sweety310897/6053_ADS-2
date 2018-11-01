import java.util.Scanner;
import java.util.Stack;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * grid.
     */
    private boolean[][] grid;
    /**
     * top.
     */
    private int top = 0;
    /**
     * bottom.
     */
    private int bottom;
    /**
     * size.
     */
    private int size;
    /**
     * g.
     */
    private GraphRep g;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    Percolation(final int n) {
        size = n;
        bottom = size * size + 1;
        g = new GraphRep(size * size + 2);
        grid = new boolean[size][size];
    }
    /**
     * gettop.
     *
     * @return     { description_of_the_return_value }
     */
    public int gettop() {
        return this.top;
    }
    /**
     * getbottom.
     *
     * @return     { description_of_the_return_value }
     */
    public int getbottom() {
        return this.bottom;
    }
    /**
     * getsize.
     *
     * @return     { description_of_the_return_value }
     */
    public int getsize() {
        return this.size;
    }
    /**
     * open.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void open(final int i, final int j) {
        grid[i - 1][j - 1] = true;
        if (i == 1) {
            g.addEdge(component(i, j), gettop());
        }
        if (i == getsize()) {
            g.addEdge(component(i, j), getbottom());
        }

        if (j > 1 && isOpen(i, j - 1)) {
            g.addEdge(component(i, j), component(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1)) {
            g.addEdge(component(i, j), component(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            g.addEdge(component(i, j), component(i - 1, j));
        }
        if (i < getsize() && isOpen(i + 1, j)) {
            g.addEdge(component(i, j), component(i + 1, j));
        }
    }
    /**
     * Determines if open.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int i, final int j) {
        return grid[i - 1][j - 1];
    }
    /**
     * Determines if full.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     True if full, False otherwise.
     */
    public boolean isFull(final int i, final int j) {
        if (0 < i && i <= getsize() && 0 < j && j <= getsize()) {
            return g.hasEdge(gettop(), component(i, j));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * percolates.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean percolates() {
        DepthFirstSearch obj = new DepthFirstSearch(g, gettop());
        return obj.hasPathTo(getbottom());
        //return g.hasEdge(top, bottom);

    }
    /**
     * component.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int component(final int i, final int j) {
        return getsize() * (i - 1) + j;
    }

}
/**
 * Class for depth first search.
 */
class DepthFirstSearch {
    /**
     * marked.
     */
    private boolean[] marked;    // marked[v] = is there an s-v path?
    /**
     * edgeTo.
     */
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    /**
     * s.
     */
    private final int s;         // source vertex
    /**
     * Constructs the object.
     *
     * @param      gph     { parameter_description }
     * @param      s1     { parameter_description }
     */
    DepthFirstSearch(final GraphRep gph, final int s1) {
        this.s = s1;
        edgeTo = new int[gph.V()];
        marked = new boolean[gph.V()];
        validateVertex(s1);
        dfs(gph, s1);
    }
    /**
     * dfs.
     *
     * @param      g1     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final GraphRep g1, final int v) {
        marked[v] = true;
        for (int w : g1.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g1, w);
            }
        }
    }
    /**
     * Determines if it has path to.
     *
     * @param      v     { parameter_description }
     *
     * @return     True if has path to, False otherwise.
     */
    public boolean hasPathTo(final int v) {
        validateVertex(v);
        return marked[v];
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> pathTo(final int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
    /**
     * validate.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        int v1 = marked.length;
        if (v < 0 || v >= v1) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (v1 - 1));
        }
    // }
    // public void display(GraphRep G) {
    //     for (int v = 0; v < G.V(); v++) {
    //         if (dfs.hasEdge(v)) {
    //             System.out.println("%d to %d:  ", s, v);
    //             for (int x : dfs.hasEdge(v)) {
    //                 if (x == s) System.out.print(x);
    //                 else        System.out.print("-" + x);
    //             }
    //             System.out.println();
    //         }
    //         else {
    //             System.out.printf("%d to %d:  not connected\n", s, v);
    //         }

    //     }
    // }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Percolation p = new Percolation(size);
        //GraphRep g = new GraphRep(size);
        while (sc.hasNext()) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            //g.addEdge(n1-1,n2-1);
            p.open(n1, n2);
        }
        //System.out.println(size);
        //DepthFirstSearch d = new DepthFirstSearch(g, size-2);
        System.out.println(p.percolates());
    }
}






