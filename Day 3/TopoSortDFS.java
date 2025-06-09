import java.util.*;
public class TopoSortDFS {
    /*
     * Problem: Topological Sort of a Directed Acyclic Graph (DAG)
     * Approach: DFS post-order with stack reversal.
     * Time Complexity: O(V + E), Space Complexity: O(V + E)
     */
    public List<Integer> topoSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfs(i, adj, visited, stack);
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) res.add(stack.pop());
        return res;
    }
    private void dfs(int u, List<List<Integer>> adj, boolean[] visited, Deque<Integer> stack) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) dfs(v, adj, visited, stack);
        }
        stack.push(u); // post-order add
    }
}
