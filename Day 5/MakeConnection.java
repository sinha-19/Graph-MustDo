public class MakeConnection {
    /*
     * Problem: Min ops to connect all computers (network)
     * Approach: DSU builds components; operations = cc - 1
     * Time: O(n + connections), Space: O(n)
     */
    public int makeConnected(int n, int[][] conn) {
        if (conn.length < n - 1) return -1;
        DisjointSetByRank ds = new DisjointSetByRank(n);
        for (int[] c : conn) ds.union(c[0], c[1]);
        int comps = 0;
        for (int i = 0; i < n; i++)
            if (ds.find(i) == i) comps++;
        return comps - 1;
    }
}
