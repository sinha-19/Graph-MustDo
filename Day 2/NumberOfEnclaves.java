/*
 * Problem: Number of Enclaves (cells of 1 not reachable from boundary)
 * Approach: DFS from boundary land cells and mark them.
 * Time: O(r*c), Space: O(r*c)
 */
public class NumberOfEnclaves {
    private int rows, cols;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numEnclaves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        // Flood-fill boundary 1s
        for (int r = 0; r < rows; r++) {
            dfs(grid, r, 0);
            dfs(grid, r, cols - 1);
        }
        for (int c = 0; c < cols; c++) {
            dfs(grid, 0, c);
            dfs(grid, rows - 1, c);
        }
        int total = 0;
        // Count remaining 1s
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) total++;
            }
        }
        return total;
    }
    private void dfs(int[][] g, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || g[r][c] != 1) return;
        g[r][c] = -1; // mark as visited
        for (int[] d : DIRS)
            dfs(g, r + d[0], c + d[1]);
    }
}
