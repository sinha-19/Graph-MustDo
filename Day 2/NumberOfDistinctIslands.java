/*
 * Problem: Number of Distinct Islands (shapes)
 * Approach: DFS and encode shape via relative moves.
 * Time: O(r*c), Space: O(r*c)
 */
import java.util.*;
public class NumberOfDistinctIslands {
    private int rows, cols;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private String[] dirCode = {"D","U","R","L"};
    public int countDistinctIslands(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> shapes = new HashSet<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, visited, r, c, sb, "O");
                    shapes.add(sb.toString());
                }
            }
        }
        return shapes.size();
    }
    private void dfs(int[][] g, boolean[][] vis, int r, int c, StringBuilder sb, String dir) {
        vis[r][c] = true;
        sb.append(dir);
        for (int i = 0; i < 4; i++) {
            int nr = r + dirs[i][0], nc = c + dirs[i][1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                g[nr][nc] == 1 && !vis[nr][nc]) {
                dfs(g, vis, nr, nc, sb, dirCode[i]);
            }
        }
        sb.append("B"); // backtrack marker
    }
}
