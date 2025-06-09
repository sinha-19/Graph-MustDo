import java.util.*;
public class ShortestPathUnweighted {
    /*
     * Problem: Shortest path in an undirected graph with unit weights
     * Approach: BFS from source to compute minimum distances.
     * Time: O(V + E), Space: O(V)
     */
    public int[] shortestPath(int V, List<List<Integer>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.add(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return dist;
    }
}
