/*
 * Problem: Count number of connected components
 * Approach:
 * - Traverse the entire graph using DFS.
 * - Each time DFS starts from an unvisited node, it counts as one component.
 * Time Complexity: O(N + E)
 */
import java.util.*;
public class ConnectedComponents {
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        // Create two separate components
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        // DFS from each unvisited node
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }
        System.out.println("Connected Components: " + count);
    }
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
