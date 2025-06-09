import java.util.*;
public class ShortestPathDAG {
    /*
     * Problem: Shortest path in a directed acyclic graph
     * Approach: Topological sort + relax edges in order.
     * Time: O(V + E), Space: O(V + E)
     */
    public int[] shortestPath(int V, List<List<int[]>> adj, int src) {
        List<Integer> topo = topologicalSort(V, adj);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int u : topo) {
            if (dist[u] != Integer.MAX_VALUE) {
                for (int[] edge : adj.get(u)) {
                    int v = edge[0], w = edge[1];
                    dist[v] = Math.min(dist[v], dist[u] + w);
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }
    private List<Integer> topologicalSort(int V, List<List<int[]>> adj) {
        int[] indegree = new int[V];
        for (List<int[]> edges : adj) for (int[] e : edges) indegree[e[0]]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (indegree[i] == 0) q.add(i);
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);
            for (int[] e : adj.get(u)) {
                if (--indegree[e[0]] == 0) q.add(e[0]);
            }
        }
        return topo;
    }
}
