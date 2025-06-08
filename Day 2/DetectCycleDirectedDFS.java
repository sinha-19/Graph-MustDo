/*
 * Problem: Detect cycle in directed graph using DFS
 * Approach: DFS with recursion-stack tracking (back-edge detection).
 * Time Complexity: O(V + E), Space Complexity: O(V)
 */
import java.util.*;
public class DetectCycleDirectedDFS {
    public boolean isCyclic(int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, visited, recStack, adjList))
                return true;
        }
        return false;
    }
    private boolean dfs(int u, boolean[] visited, boolean[] recStack, List<List<Integer>> adjList) {
        visited[u] = true;
        recStack[u] = true;
        for (int v : adjList.get(u)) {
            if (!visited[v] && dfs(v, visited, recStack, adjList)) return true;
            else if (recStack[v]) return true;
        }
        recStack[u] = false;  // backtrack
        return false;
    }
}
