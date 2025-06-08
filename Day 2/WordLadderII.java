/*
 * Problem: Word Ladder II (all shortest transformation sequences)
 * Approach: BFS to build tree of possible transformations, then DFS to retrieve paths.
 * Time: O(N * L^2), Space: O(N*L + result size)
 */
import java.util.*;
public class WordLadderII {
    Map<String, List<String>> graph = new HashMap<>();
    List<List<String>> results = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return results;
        dict.add(beginWord);
        bfsLevels(beginWord, endWord, dict);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfsPaths(beginWord, endWord, path);
        return results;
    }
    private void bfsLevels(String begin, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        Map<String, Integer> level = new HashMap<>();
        level.put(begin, 0);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int lvl = level.get(word);
            for (String nei : getNeighbors(word, dict)) {
                if (!level.containsKey(nei)) {
                    level.put(nei, lvl + 1);
                    queue.add(nei);
                }
                if (level.get(nei) == lvl + 1) {
                    graph.computeIfAbsent(word, k -> new ArrayList<>()).add(nei);
                }
            }
        }
    }
    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char orig = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String nxt = new String(arr);
                if (dict.contains(nxt)) res.add(nxt);
            }
            arr[i] = orig;
        }
        return res;
    }
    private void dfsPaths(String cur, String end, List<String> path) {
        if (cur.equals(end)) {
            results.add(new ArrayList<>(path));
            return;
        }
        if (!graph.containsKey(cur)) return;
        for (String nei : graph.get(cur)) {
            path.add(nei);
            dfsPaths(nei, end, path);
            path.remove(path.size() - 1);
        }
    }
}
