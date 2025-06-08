/*
 * Problem: Detect cycle in undirected graph using DFS
 * Approach: DFS with parent tracking.
 * Time Complexity: O(V+E), Space Complexity: O(V)
 */
import java.util.*;
public class DetectCycleUndirectedDFS {
    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, -1, visited, adj)) return true;
        }
        return false;
    }
    private boolean dfs(int u, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                if (dfs(v, u, visited, adj)) return true;
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }
}
