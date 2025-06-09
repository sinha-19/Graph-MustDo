import java.util.*;
public class FindCityWithSmallestNeighbors {
    /*
     * Problem: Find city with fewest reachable within threshold
     * Approach: Use Floyd-Warshall or repeated Dijkstra
     * Time: O(n^3) or O(n * (E log V)), Space: O(n^2)
     */
    public int findTheCity(int n, int[][] edges, int distThreshold) {
        int[][] dist = new int[n][n];
        int INF = 1_000_000_000;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }
        // Floyd-Warshall
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        int city = -1, minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distThreshold) count++;
            }
            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }
        return city;
    }
}
