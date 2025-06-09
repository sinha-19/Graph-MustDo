/*
 * Problem: Disjoint Set (Union by Rank + Path Compression)
 * Approach: Maintain parent & rank arrays to unify sets efficiently
 * Average Time per op: ≈O(α(n)), Space: O(n)
 */
public class DisjointSetByRank {
    private int[] parent, rank;
    public DisjointSetByRank(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        x = find(x); y = find(y);
        if (x == y) return;
        if (rank[x] < rank[y]) parent[x] = y;
        else if (rank[y] < rank[x]) parent[y] = x;
        else { parent[y] = x; rank[x]++; }
    }
}
