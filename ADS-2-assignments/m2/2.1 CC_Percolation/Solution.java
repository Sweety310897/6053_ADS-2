import java.util.Scanner;
import java.util.Stack;
class Percolation {
	boolean[][] grid;
	int top = 0;
	int bottom;
	int size;
	GraphRep g;
	Percolation(int n) {
		size = n;
        bottom = size * size + 1;
        g = new GraphRep(size * size + 2);
        grid = new boolean[size][size];
	}
	public void open(int i,int j) {
        grid[i][j] = true;
        if (i == 1) {
            g.addEdge(component(i, j), top);
        }
        if (i == size) {
            g.addEdge(component(i, j), bottom);
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
        if (i < size && isOpen(i + 1, j)) {
            g.addEdge(component(i, j), component(i + 1, j));
        }
    }
	public boolean isOpen(int i, int j) {
        return grid[i - 1][j - 1];
	}
	public boolean isFull(int i, int j) {
        if (0 < i && i <= size && 0 < j && j <= size) {
            return g.hasEdge(top, component(i, j));
        } else {
            throw new IndexOutOfBoundsException();
        }
	}
	public boolean percolates() {
        DepthFirstSearch obj = new DepthFirstSearch(g,top);
        return obj.hasPathTo(bottom);
        //return g.hasEdge(top, bottom);

	}
	private int component(int i, int j) {
        return size * (i - 1) + j;
    }

}
class DepthFirstSearch {
	private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex
    public DepthFirstSearch(GraphRep G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    private void dfs(GraphRep G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
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
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Percolation p = new Percolation(size);
        //GraphRep g = new GraphRep(size);
		
		while(sc.hasNext()) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            //g.addEdge(n1-1,n2-1);
			p.open(n1,n2);
		}
        //System.out.println(size);
        //DepthFirstSearch d = new DepthFirstSearch(g, size-2);
		System.out.println(p.percolates());
	}
}