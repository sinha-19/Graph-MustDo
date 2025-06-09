import java.util.*;
public class PrimMST {
    /*
     * Problem: Build MST using Prim’s algorithm
     * Approach: Greedy selection of smallest edge from current MST frontier
     * Time: O(E log V), Space: O(V + E)
     */
    public int primMST(int V, List<List<int[]>> adj) {
        boolean[] vis = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); // weight 0 to start at node 0
        int total = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int w = cur[0], u = cur[1];
            if (vis[u]) continue;
            vis[u] = true;
            total += w;
            for (int[] e : adj.get(u)) {
                if (!vis[e[0]]) pq.offer(new int[]{e[1], e[0]});
            }
        }
        return total;
    }
}
