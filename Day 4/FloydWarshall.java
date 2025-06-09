public class FloydWarshall {
    /*
     * Problem: All pairs shortest path
     * Approach: Dynamic programming triple loop
     * Time: O(V^3), Space: O(V^2)
     */
    public void floydWarshall(int[][] dist) {
        int V = dist.length;
        for (int k = 0; k < V; k++) 
            for (int i = 0; i < V; i++) 
                for (int j = 0; j < V; j++)
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
    }
}
