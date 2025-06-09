import java.util.*;
public class CycleDetectionDirectedBFS {
    /*
     * Problem: Detect cycle in directed graph using BFS (Kahn's)
     * Approach: Run Kahn's and check if topo count < V.
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public boolean hasCycle(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (List<Integer> edges : adj)
            for (int v : edges) indegree[v]++;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0) queue.add(v);
            }
        }
        return count != V;
    }
}
