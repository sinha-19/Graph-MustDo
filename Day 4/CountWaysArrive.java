import java.util.*;
public class CountWaysArrive {
    /*
     * Problem: Count shortest paths to dest
     * Approach: Dijkstra + DP: track number of ways to reach each node
     * Time: O(E log V), Space: O(V + E)
     */
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] r : roads) {
            adj.get(r[0]).add(new int[]{r[1], r[2]});
            adj.get(r[1]).add(new int[]{r[0], r[2]});
        }
        int MOD = 1_000_000_007;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        long[] ways = new long[n];
        ways[0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            var cur = pq.poll();
            int u = cur[0];
            long d = dist[u];
            for (int[] e : adj.get(u)) {
                int v = e[0], w = e[1];
                long nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    ways[v] = ways[u];
                    pq.add(new int[]{v, (int) nd});
                } else if (nd == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return (int) ways[n - 1];
    }
}
