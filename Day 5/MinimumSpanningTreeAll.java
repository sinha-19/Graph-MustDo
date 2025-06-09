/*
 * Problem: Compute total weight of MST (generic prompt)
 * Approach: Use Kruskal’s MST via DSU
 * Time: O(E log E + E α(V)), Space: O(V + E)
 */
public class MinimumSpanningTreeAll {
    public int buildMST(int V, int[][] edges) {
        return new KruskalMST().kruskalMST(V, edges);
    }
}
