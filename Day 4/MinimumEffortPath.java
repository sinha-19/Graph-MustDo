import java.util.*;
public class MinimumEffortPath {
    /*
     * Problem: Path with minimum effort (minimize max edge difference)
     * Approach: Dijkstra-like: minimize bottleneck edge.
     * Time: O(E log V), Space: O(V + E)
     */
    public int minimumEffortPath(int[][] heights) {
        int R = heights.length, C = heights[0].length;
        int[][] effort = new int[R][C];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 0});
        int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], e = cur[2];
            if (r == R - 1 && c == C - 1) return e;
            if (e > effort[r][c]) continue;
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    int ne = Math.max(e, Math.abs(heights[r][c] - heights[nr][nc]));
                    if (ne < effort[nr][nc]) {
                        effort[nr][nc] = ne;
                        pq.add(new int[]{nr, nc, ne});
                    }
                }
            }
        }
        return -1;
    }
}
