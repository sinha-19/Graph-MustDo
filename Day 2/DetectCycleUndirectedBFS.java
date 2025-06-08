/*
 * Problem: Detect cycle in undirected graph using BFS
 * Approach: BFS with parent tracking.
 * Time Complexity: O(V+E), Space Complexity: O(V)
 */
import java.util.*;
public class DetectCycleUndirectedBFS {
    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && bfs(i, visited, adj)) return true;
        }
        return false;
    }
    private boolean bfs(int src, boolean[] visited, List<List<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(new int[]{src, -1}); // node, parent
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], p = cur[1];
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(new int[]{v, u});
                } else if (v != p) {
                    return true; // found cycle
                }
            }
        }
        return false;
    }
}
