/*
 * Problem: Disjoint Set (Union by Size + Path Compression)
 * Approach: Attach smaller tree under larger to balance heights
 * Average Time per op: ≈O(α(n)), Space: O(n)
 */
public class DisjointSetBySize {
    public int[] parent, size;
    public DisjointSetBySize(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) { parent[i] = i; size[i] = 1; }
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        x = find(x); y = find(y);
        if (x == y) return;
        if (size[x] < size[y]) parent[x] = y;
        else { parent[y] = x; size[x] += size[y]; }
    }
}
