import java.util.*;
public class BellmanFord {
    /*
     * Problem: Single-source shortest path with negative weights (no neg cycles)
     * Approach: Relax edges V-1 times.
     * Time: O(V * E), Space: O(V)
     */
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        // Could check negative cycles here
        return dist;
    }
}
