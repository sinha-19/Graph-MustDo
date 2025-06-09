import java.util.*;
public class ShortestPathBinaryMaze {
    /*
     * Problem: Shortest path in binary grid (0 = wall, 1 = free)
     * Approach: BFS with distance tracking.
     * Time: O(r*c), Space: O(r*c)
     */
    public int shortestPath(int[][] grid, int sr, int sc, int tr, int tc) {
        int R = grid.length, C = grid[0].length;
        int[][] dist = new int[R][C];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sr, sc});
        dist[sr][sc] = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int r = cur[0], c = cur[1];
            if (r == tr && c == tc) break;
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 1) {
                    if (dist[r][c] + 1 < dist[nr][nc]) {
                        dist[nr][nc] = dist[r][c] + 1;
                        dq.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return dist[tr][tc] == Integer.MAX_VALUE ? -1 : dist[tr][tc];
    }
}
