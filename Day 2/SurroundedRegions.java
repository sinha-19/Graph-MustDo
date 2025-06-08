/*
 * Problem: Surrounded Regions (capture 'O' on boundary)
 * Approach: DFS from boundary 'O's, mark safe ones, fill others.
 * Time: O(r*c), Space: O(r*c)
 */
public class SurroundedRegions {
    private int rows, cols;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        rows = board.length;
        if (rows == 0) return;
        cols = board[0].length;
        // Mark boundary-connected Os
        for (int r = 0; r < rows; r++) {
            dfs(board, r, 0);
            dfs(board, r, cols - 1);
        }
        for (int c = 0; c < cols; c++) {
            dfs(board, 0, c);
            dfs(board, rows - 1, c);
        }
        // Flip interior Os to X, restore safe ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == '#') board[r][c] = 'O';
            }
        }
    }
    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') return;
        board[r][c] = '#';  // mark as safe
        for (int[] d : DIRS)
            dfs(board, r + d[0], c + d[1]);
    }
}
