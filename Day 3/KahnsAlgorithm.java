import java.util.*;
public class KahnsAlgorithm {
    /*
     * Problem: Kahn's Algorithm for Topological Sort using BFS
     * Approach: Maintain indegree array, queue nodes with indegree 0.
     * Time Complexity: O(V + E), Space Complexity: O(V)
     */
    public List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (List<Integer> edges : adj) {
            for (int v : edges) indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res.add(u);
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0) queue.offer(v);
            }
        }
        return res.size() == V ? res : new ArrayList<>(); // cycle check
    }
}
