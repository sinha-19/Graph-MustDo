import java.util.*;
public class EventualSafeStates {
    /*
     * Problem: Find all safe nodes (nodes that eventually lead to terminal nodes)
     * Approach: Reverse graph + BFS to pull back safe states (Kahn's variant)
     * Time Complexity: O(V + E), Space: O(V + E)
     */
    public List<Integer> eventualSafeNodes(List<List<Integer>> graph) {
        int V = graph.size();
        List<List<Integer>> rev = new ArrayList<>();
        int[] outdegree = new int[V];
        for (int i = 0; i < V; i++) rev.add(new ArrayList<>());
        for (int u = 0; u < V; u++) {
            for (int v : graph.get(u)) {
                rev.get(v).add(u);
            }
            outdegree[u] = graph.get(u).size();
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (outdegree[i] == 0) queue.offer(i);
        boolean[] safe = new boolean[V];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            safe[u] = true;
            for (int p : rev.get(u)) {
                if (--outdegree[p] == 0) queue.offer(p);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++)
            if (safe[i]) res.add(i);
        Collections.sort(res);
        return res;
    }
}
