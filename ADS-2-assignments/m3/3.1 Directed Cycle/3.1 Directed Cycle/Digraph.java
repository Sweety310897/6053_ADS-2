class Digraph {
    /**
    vertex.
     */
    private int vertex;
    /**
     * edge.
     */
    private int edge;
    /**
     * adj.
     */
    private Bag<Integer>[] adj;
    /**
     * indeg.
     */
    private int[] indegree;
    /**
     * Constructs the object.
     */
    Digraph() {

    }
    /**
     * Constructs the object.
     *
     * @param      ver   The version
     */
    Digraph(final int ver) {
        this.vertex = ver;
        this.edge = 0;
        adj = (Bag<Integer>[]) new Bag[ver];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * getvertex.
     *
     * @return     { description_of_the_return_value }
     */
    public int getvertex() {
        return this.vertex;
    }
    /**
     * getedge.
     *
     * @return     { description_of_the_return_value }
     */
    public int getedge() {
        return this.edge;
    }
    /**
     * V().
     *
     * @return     vertex.
     */
    public int ve() {
        return getvertex();
    }
    // public Iterable<Integer> adj(int v) {
    //     return arr[v];
    // }
    /**
     * E().
     *
     * @return     edge.
     */
    public int ed() {
        return getedge();
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    /**
     * { function_description }
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= getvertex()) {
            throw new IllegalArgumentException("vertex " + v
                + " is not between 0 and " + (getvertex() - 1));
        }
    }
    // /**
    //  * Adds an edge.
    //  *time complexity - O(1).
    //  * @param      v     { parameter_description }
    //  * @param      w     { parameter_description }
    //  */
    // public void addEdge(final int v, final int w) {
    //     if (v == w) {
    //         return;
    //     }
    //     if (!hasEdge(v, w)) {
    //         edge++;

    //         adj[v].add(w);
    //         //adj[w].add(v);
    //     }
    // }
    /**
    *add edge.
    * @param      v     { parameter_description }
    * @param      w     { parameter_description }
    */
    public void addEdge(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        edge++;
    }
    /**
     * Determines if it has edge.
     *time complexity - O(n).
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        for (int k :adj[v]) {
                if (k == w) {
                    return true;
                }
        }
        return false;
    }
    /**
     * outdeg.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int outdegree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }
    /**
     * indeg.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int indegree(final int v) {
        validateVertex(v);
        return indegree[v];
    }

}





















// /**
//  * Class for digraph.
//  */
// public class Digraph {
//     /**
//      * { var_description }
//      */
//     private static final String NEWLINE = System.getProperty("line.separator");
//     /**
//      * V.
//      */
//     private final int V;           // number of vertices in this digraph
//     /**
//      * E.
//      */
//     private int E;                 // number of edges in this digraph
    
//     private Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v
//     private int[] indegree;        // indegree[v] = indegree of vertex v
    
//     /**
//      * Initializes an empty digraph with <em>V</em> vertices.
//      *
//      * @param  V the number of vertices
//      * @throws IllegalArgumentException if {@code V < 0}
//      */
//     public Digraph(int V) {
//         if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
//         this.V = V;
//         this.E = 0;
//         indegree = new int[V];
//         adj = (Bag<Integer>[]) new Bag[V];
//         for (int v = 0; v < V; v++) {
//             adj[v] = new Bag<Integer>();
//         }
//     }
//     /**
//      * Initializes a new digraph that is a deep copy of the specified digraph.
//      *
//      * @param  G the digraph to copy
//      */
//     public Digraph(Digraph G) {
//         this(G.V());
//         this.E = G.E();
//         for (int v = 0; v < V; v++)
//             this.indegree[v] = G.indegree(v);
//         for (int v = 0; v < G.V(); v++) {
//             // reverse so that adjacency list is in same order as original
//             Stack<Integer> reverse = new Stack<Integer>();
//             for (int w : G.adj[v]) {
//                 reverse.push(w);
//             }
//             for (int w : reverse) {
//                 adj[v].add(w);
//             }
//         }
//     }
        
//     /**
//      * Returns the number of vertices in this digraph.
//      *
//      * @return the number of vertices in this digraph
//      */
//     public int V() {
//         return V;
//     }
//     /**
//      * Returns the number of edges in this digraph.
//      *
//      * @return the number of edges in this digraph
//      */
//     public int E() {
//         return E;
//     }
//     /**
//      * { function_description }
//      *
//      * @param      v     { parameter_description }
//      */
//     private void validateVertex(final int v) {
//         if (v < 0 || v >= V) {
//             throw new IllegalArgumentException("vertex " + v
//                 + " is not between 0 and " + (V - 1));
//         }
//     }

//     /**
//      * Adds the directed edge v→w to this digraph.
//      *
//      * @param  v the tail vertex
//      * @param  w the head vertex
//      * @throws IllegalArgumentException
//      */
//     public void addEdge(final int v, final int w) {
//         validateVertex(v);
//         validateVertex(w);
//         adj[v].add(w);
//         indegree[w]++;
//         E++;
//     }

//     /**
//      * Returns the vertices adjacent from vertex {@code v} in this digraph.
//      *
//      * @param  v the vertex
//      * @return the vertices adjacent from vertex
//      * @throws IllegalArgumentException unless {@code 0 <= v < V}
//      */
//     public Iterable<Integer> adj(final int v) {
//         validateVertex(v);
//         return adj[v];
//     }

//     /**
//      * Returns the number of directed edges incident from vertex {@code v}.
//      * This is known as the <em>outdegree</em> of vertex {@code v}.
//      *
//      * @param  v the vertex
//      * @return the outdegree of vertex {@code v}
//      * @throws IllegalArgumentException unless {@code 0 <= v < V}
//      */
//     public int outdegree(final int v) {
//         validateVertex(v);
//         return adj[v].size();
//     }

//     /**
//      * Returns the number of directed edges incident to vertex {@code v}.
//      * This is known as the <em>indegree</em> of vertex {@code v}.
//      *
//      * @param  v the vertex
//      * @return the indegree of vertex {@code v}
//      * @throws IllegalArgumentException unless {@code 0 <= v < V}
//      */
//     public int indegree(final int v) {
//         validateVertex(v);
//         return indegree[v];
//     }
// }