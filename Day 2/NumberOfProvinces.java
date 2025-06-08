/*
 * Problem: Number of Provinces (connected components in adjacency matrix)
 * Approach: BFS for each unvisited city in connectivity matrix.
 * Time Complexity: O(n^2), Space Complexity: O(n)
 */
import java.util.*;
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, count = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v = 0; v < n; v++) {
                        if (isConnected[u][v] == 1 && !visited[v]) {
                            visited[v] = true;
                            queue.add(v);
                        }
                    }
                }
            }
        }
        return count;
    }
}
