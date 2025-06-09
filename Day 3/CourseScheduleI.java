import java.util.*;
public class CourseScheduleI {
    /*
     * Problem: Determine if all courses can be finished (detect cycle)
     * Approach: Use BFS cycle detection on prerequisites graph.
     * Time Complexity: O(numCourses + prerequisites), Space: O(numCourses)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll(); count++;
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0) queue.offer(v);
            }
        }
        return count == numCourses;
    }
}
