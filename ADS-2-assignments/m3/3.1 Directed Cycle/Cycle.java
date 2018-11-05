/**
 * Class for cycle.
 */
public class Cycle {
    /**
     * { var_description }.
     */
    private boolean[] marked;
    // marked[v] = has vertex v been marked?
    /**
     * { item_description }.
     */
    private int[] edgeTo;
    /**
     * { var_description }.
     */
    private boolean[] onStack;
    /**
     * { var_description }.
     */
    private Stack<Integer> cycle;
    /**
     * Determines whether the digraph {@code G} has a directed cycle and, if so,
     * finds such a cycle.
     * @param gph the digraph
     */
    /**
     * Constructs the object.
     * time complexity - O(V+E).
     * @param      gph     { parameter_description }
     */
    public Cycle(final Digraph gph) {
        marked  = new boolean[gph.V()];
        onStack = new boolean[gph.V()];
        edgeTo  = new int[gph.V()];
        for (int v = 0; v < gph.V(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(gph, v);
            }
        }
    }
    /**
     * dfs.
     * time complexity - O(V+E).
     * @param      gph1     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final Digraph gph1, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : gph1.adj(v)) {
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(gph1, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    /**
     * Does the digraph have a directed cycle?
     * @return true or false
     * time complexity - O(1).
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**
     * Returns a directed cycle if the digraph
     * has a directed cycle, and {@code null} otherwise.
     *
     */
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
}





