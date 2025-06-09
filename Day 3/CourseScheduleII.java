import java.util.*;
public class CourseScheduleII {
    /*
     * Problem: Return order to finish courses, or empty if impossible
     * Approach: Kahn’s topological sort + cycle detection
     * Time Complexity: O(numCourses + prerequisites), Space: O(numCourses)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] order = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order[idx++] = u;
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0) queue.add(v);
            }
        }
        return (idx == numCourses) ? order : new int[0];
    }
}
