/*
 * Problem: Why is a PriorityQueue used in Dijkstra?
 * Approach: It ensures extraction of current minimum distance vertex efficiently.
 * Time: This is a conceptual explanation, not code.
 * Space: Conceptual
 *
 * Explanation:
 * - Dijkstra uses a min-heap (priority queue) to always pick the unvisited vertex
 *   with the smallest tentative distance. Without it, choosing the next closest
 *   vertex in O(V) would hurt total complexity (O(V^2) vs O(E log V)).
 */
