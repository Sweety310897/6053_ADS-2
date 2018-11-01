/**
 * Interface for graph.
 */
interface Graph {
    /**
     * ve.
     *
     * @return     { description_of_the_return_value }
     */
    int ve();
    /**
     * ed.
     *
     * @return     { description_of_the_return_value }
     */
    int ed();
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    void addEdge(int v, int w);
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    boolean hasEdge(int v, int w);
    /**
     * Iterable.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    Iterable<Integer> adj(int v);
}
/**
 * Class for graph rep.
 */
class GraphRep implements Graph {
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
     * Constructs the object.
     */
    GraphRep() {

    }
    /**
     * Constructs the object.
     *
     * @param      ver   The version
     */
    GraphRep(final int ver) {
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
     * Adds an edge.
     *time complexity - O(1).
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        if (v == w) {
            return;
        }
        if (!hasEdge(v, w)) {
            edge++;

            adj[v].add(w);
            //adj[w].add(v);
        }
    }
    /**
     * Determines if it has edge.
     *time complexity - O(V).
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
     * matrix.
     *
     * @param      v          { parameter_description }
     * @param      e          { parameter_description }
     *time complexity - O(V^2).
     * @throws     Exception  { exception_description }
     */
    public void matrixRep(final int v, final int e)
    throws Exception {
        if (e <= 1 && v <= 1) {
            System.out.println(ve() + " vertices" + ", " + ed() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(ve() + " vertices" + ", " + ed() + " edges");
            int[][] mat = new int[v][v];
            for (int i = 0; i  < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (hasEdge(i, j)) {
                        mat[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    /**
     * list rep.
     *
     * @param      v          { parameter_description }
     * @param      e          { parameter_description }
     * @param      n1         The n 1
     * time complexity - O(V+E).
     * @throws     Exception  { exception_description }
     */
    public void listRep(final int v, final int e,
        final String[] n1) throws Exception {
        if (e <= 1 && v <= 1) {
            System.out.println(ve() + " vertices" + ", " + ed() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(ve() + " vertices" + ", " + ed() + " edges");
            for (int i = 0; i < n1.length; i++) {
                String str = "";
                str = n1[i] + ": ";
                //System.out.println(str);
                for (int k : adj(i)) {
                    //System.out.println((arr(i)) + "arr");
                    str = str + n1[k] + " ";
                }
                System.out.println(str);
            }
        }
    }
}




