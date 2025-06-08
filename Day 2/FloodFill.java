/*
 * Problem: Flood Fill (replace area connected to starting pixel)
 * Approach: DFS to update the region.
 * Time Complexity: O(r*c), Space Complexity: O(r*c)
 */
public class FloodFill {
    private int rows, cols, oldColor, newColor;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int nc) {
        rows = image.length;
        cols = image[0].length;
        oldColor = image[sr][sc];
        newColor = nc;
        if (oldColor != newColor)
            dfs(image, sr, sc);
        return image;
    }
    private void dfs(int r, int c, int[][] img) {
        if (r < 0 || r >= rows || c < 0 || c >= cols ||
            img[r][c] != oldColor) return;
        img[r][c] = newColor;
        for (int[] d : DIRS) {
            dfs(r + d[0], c + d[1], img);
        }
    }
}
