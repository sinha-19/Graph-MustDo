import java.util.*;
public class AlienDictionary {
    /*
     * Problem: Given sorted words in unknown alien language,
     *           determine lexicographical order of characters.
     * Approach: Build graph from pairwise letter comparisons, then topological sort with BFS.
     * Time Complexity: O(V + E), Space: O(V + E)
     */
    public String alienOrder(String[] words) {
        // build graph nodes from letters
        Map<Character, List<Character>> adj = new HashMap<>();
        int[] indegree = new int[26];
        boolean[] present = new boolean[26];
        for (String w : words)
            for (char c : w)
                present[c - 'a'] = true;
        // build edges based on first difference
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1], w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.computeIfAbsent(w1.charAt(j), x->new ArrayList<>())
                        .add(w2.charAt(j));
                    indegree[w2.charAt(j) - 'a']++;
                    break;
                }
            }
        }
        // BFS topo sort
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (present[i] && indegree[i] == 0)
                queue.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!queue.isEmpty()) {
            char u = queue.poll(); sb.append(u); count++;
            if (adj.containsKey(u)) {
                for (char v : adj.get(u)) {
                    if (--indegree[v - 'a'] == 0)
                        queue.offer(v);
                }
            }
        }
        if (count < Arrays.stream(present).filter(b -> b).count()) return "";
        return sb.toString();
    }
}
