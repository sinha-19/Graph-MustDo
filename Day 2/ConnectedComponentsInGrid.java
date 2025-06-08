/*
 * Problem: Connected Components in a matrix (4-directional)
 * Approach: DFS from each unvisited '1' cell to mark a component.
 * Time Complexity: O(r*c), Space Complexity: O(r*c) recursion
 */
public class ConnectedComponentsInGrid {
    private int rows, cols;
    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int countComponents(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    dfs(r, c, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int r, int c, int[][] g, boolean[][] visited) {
        visited[r][c] = true;
        for (int[] d : directions) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                g[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc, g, visited);
            }
        }
    }
}
