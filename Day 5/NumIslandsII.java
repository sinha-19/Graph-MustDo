import java.util.*;
public class NumIslandsII {
    /*
     * Problem: Number of islands after each land addition
     * Approach: DSU on flattened grid; union adjacent lands
     * Time: O(m*n α(mn)), Space: O(mn)
     */
    public List<Integer> numIslands2(int m, int n, int[][] ops) {
        DisjointSetByRank ds = new DisjointSetByRank(m * n);
        boolean[] grid = new boolean[m * n];
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] op : ops) {
            int r = op[0], c = op[1];
            int idx = r * n + c;
            if (grid[idx]) {
                res.add(count);
                continue;
            }
            grid[idx] = true;
            count++;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                int nidx = nr * n + nc;
                if (nr>=0 && nr<m && nc>=0 && nc<n && grid[nidx]) {
                    if (ds.find(idx) != ds.find(nidx)) {
                        ds.union(idx, nidx);
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
}
