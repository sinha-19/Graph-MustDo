/*
 * Problem: Graph Representation using Adjacency List
 * Approach:
 * - Use a list of lists to store neighbors for each node.
 * - Suitable for sparse graphs.
 * Time Complexity: O(N + E)
 */
import java.util.*;
public class GraphRepresentationAdjacencyList {
    public static void main(String[] args) {
        int n = 5;  // Number of nodes
        List<List<Integer>> adj = new ArrayList<>();
        // Initialize adjacency list
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        // Add undirected edges
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 5);
        // Print the adjacency list
        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    // Adds an edge between u and v
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Because the graph is undirected
    }
}
