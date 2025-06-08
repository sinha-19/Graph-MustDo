/*
 * Problem: Check if an undirected graph is bipartite
 * Approach: BFS + 2-coloring.
 * Time Complexity: O(V + E), Space Complexity: O(V)
 */
import java.util.*;
public class IsBipartiteGraph {
    public boolean isBipartite(int V, List<List<Integer>> adjacency) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : adjacency.get(u)) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.add(v);
                        } else if (color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
