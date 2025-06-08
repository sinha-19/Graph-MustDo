/*
 * Problem: 0/1 Matrix (distance to nearest 0)
 * Approach: Multi-source BFS from all zeros.
 * Time Complexity: O(r*c), Space Complexity: O(r*c)
 */
import java.util.*;
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] res = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        // Initialize queue with zero cells
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        int dist = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                res[cur[0]][cur[1]] = dist;
                for (int[] d : dirs) {
                    int nr = cur[0] + d[0], nc = cur[1] + d[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            dist++;
        }
        return res;
    }
}
