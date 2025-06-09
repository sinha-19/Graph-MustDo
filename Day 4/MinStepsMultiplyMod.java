import java.util.*;
public class MinStepsMultiplyMod {
    /*
     * Problem: Min steps to go from 1 to n by multiply+mod
     * Approach: BFS on value graph (state=open remainder).
     * Time: O(n), Space: O(n)
     */
    public int minimumSteps(int n, int[] arr, int mod) {
        int[] dist = new int[mod];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[1 % mod] = 0;
        q.add(1 % mod);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int a : arr) {
                int nxt = (int) ((1L * cur * a) % mod);
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    q.add(nxt);
                }
            }
        }
        return dist[n % mod];
    }
}
