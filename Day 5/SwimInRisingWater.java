import java.util.*;
public class SwimInRisingWater {
    /*
     * Problem: Minimum time to make a path as water rises
     * Approach: DSU union by sorted heights; answer when start connects to end
     * Time: O(n² log n), Space: O(n²)
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++)
            cells.add(new int[]{grid[i][j], i, j});
        cells.sort(Comparator.comparingInt(a -> a[0]));
        DisjointSetBySize ds = new DisjointSetBySize(n * n);
        boolean[][] seen = new boolean[n][n];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] cell : cells) {
            int h = cell[0], r = cell[1], c = cell[2];
            seen[r][c] = true;
            int idx = r * n + c;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr>=0 && nr<n && nc>=0 && nc<n && seen[nr][nc])
                    ds.union(idx, nr*n+nc);
            }
            if (ds.find(0) == ds.find(n*n - 1)) return h;
        }
        return -1;
    }
}
