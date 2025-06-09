import java.util.*;
public class MakingALargeIsland {
    /*
     * Problem: Largest island possible by flipping one 0 to 1
     * Approach: DSU build islands; test flipping each zero
     * Time: O(n² α(n²)), Space: O(n²)
     */
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSetBySize ds = new DisjointSetBySize(n * n);
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for (int r = 0; r < n; r++) for (int c = 0; c < n; c++)
            if (grid[r][c] == 1)
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc] == 1)
                        ds.union(r*n+c, nr*n+nc);
                }
        int res = 0;
        int[] sz = ds.size;
        for (int i = 0; i < n*n; i++)
            if (grid[i/n][i%n] == 1)
                res = Math.max(res, sz[ds.find(i)]);
        for (int r = 0; r < n; r++) for (int c = 0; c < n; c++) 
          if (grid[r][c] == 0) {
            Set<Integer> seen = new HashSet<>();
            int sum = 1;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1) {
                    int root = ds.find(nr*n+nc);
                    if (seen.add(root)) sum += sz[root];
                }
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
