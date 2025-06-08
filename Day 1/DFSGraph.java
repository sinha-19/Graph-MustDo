/*
 * Problem: DFS (Depth First Search)
 * Approach:
 * - Use recursion to explore as far as possible along a branch before backtracking.
 * - Use visited array to avoid cycles.
 * Time Complexity: O(N + E)
 */
import java.util.*;
public class DFSGraph {
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 5);
        boolean[] visited = new boolean[n + 1];
        System.out.print("DFS traversal: ");
        dfs(1, adj, visited);
    }
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
