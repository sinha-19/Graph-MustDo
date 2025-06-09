import java.util.*;
public class MostStonesRemoved {
    /*
     * Problem: Max stones removable if sharing row/col
     * Approach: DSU joining row,col nodes then count unique components
     * Time: ~O(n α(n)), Space: O(n)
     */
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DisjointSetByRank ds = new DisjointSetByRank(20000);
        int offset = 10000;
        for (int[] s : stones) {
            ds.union(s[0], s[1] + offset);
        }
        Set<Integer> roots = new HashSet<>();
        for (int[] s : stones) roots.add(ds.find(s[0]));
        return n - roots.size();
    }
}
