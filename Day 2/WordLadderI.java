/*
 * Problem: Word Ladder I (shortest transformation length)
 * Approach: BFS on word graph (neighbors differ by one letter).
 * Time: O(N * L^2), Space: O(N*L)
 */
import java.util.*;
public class WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int d = dist.get(word);
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char orig = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String nxt = new String(arr);
                    if (dict.contains(nxt) && !dist.containsKey(nxt)) {
                        dist.put(nxt, d + 1);
                        queue.add(nxt);
                        if (nxt.equals(endWord)) return d + 1;
                    }
                }
                arr[i] = orig;
            }
        }
        return 0;
    }
}
