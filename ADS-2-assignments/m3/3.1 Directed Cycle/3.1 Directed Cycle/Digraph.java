/**
 * Class for digraph.
 */
public class Digraph {
    /**
     * { var_description }.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * { var_description }.
     */
    private final int ver;
    // number of vertices in this digraph.
    /**
     * { var_description }.
     */
    private int ed;
    // number of edges in this digraph.
    /**
     * { var_description }.
     */
    private Bag<Integer>[] adj;
    // adj[v] = adjacency list for vertex v.
    /**
     * { var_description }.
     */
    private int[] indegree;
    // indegree[v] = indegree of vertex v.
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  ver1 the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph(final int ver1) {
        if (ver1 < 0) {
            throw new IllegalArgumentException(
            "Number of vertices in a Digraph must be nonnegative");
        }
        this.ver = ver1;
        this.ed = 0;
        indegree = new int[ver];
        adj = (Bag<Integer>[]) new Bag[ver];
        for (int v = 0; v < ver; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Initializes a new digraph that is a deep copy of the specified digraph.
     *
     * @param  gph the digraph to copy
     */
    public Digraph(final Digraph gph) {
        this(gph.V());
        this.ed = gph.E();
        for (int v = 0; v < ver; v++) {
            this.indegree[v] = gph.indegree(v);
        }
        for (int v = 0; v < gph.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : gph.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
    /**
     * Returns the number of vertices in this digraph.
     *
     * @return the number of vertices in this digraph
     */
    public int V() {
        return ver;
    }
    /**
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
    public int E() {
        return ed;
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= ver) {
            throw new IllegalArgumentException("vertex " + v
                + " is not between 0 and " + (ver - 1));
        }
    }

    /**
     * Adds the directed edge v→w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * @throws IllegalArgumentException
     */
    public void addEdge(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        ed++;
    }

    /**
     * Returns the vertices adjacent from vertex {@code v} in this digraph.
     *
     * @param  v the vertex
     * @return the vertices adjacent from vertex
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the number of directed edges incident from vertex {@code v}.
     * This is known as the <em>outdegree</em> of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the outdegree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int outdegree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns the number of directed edges incident to vertex {@code v}.
     * This is known as the <em>indegree</em> of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the indegree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int indegree(final int v) {
        validateVertex(v);
        return indegree[v];
    }
}





