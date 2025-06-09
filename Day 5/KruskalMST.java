import java.util.*;
public class KruskalMST {
    /*
     * Problem: Build MST using Kruskal’s algorithm
     * Approach: Sort edges and join using DSU to avoid cycles
     * Time: O(E log E + E*α(V)), Space: O(V + E)
     */
    public int kruskalMST(int V, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
        DisjointSetByRank ds = new DisjointSetByRank(V);
        int total = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (ds.find(u) != ds.find(v)) {
                ds.union(u, v);
                total += w;
            }
        }
        return total;
    }
}
