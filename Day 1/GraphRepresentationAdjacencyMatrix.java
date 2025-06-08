/*
 * Problem: Graph Representation using Adjacency Matrix
 * Approach:
 * - Use a 2D array to mark edges between nodes.
 * - Suitable for dense graphs.
 * Time Complexity: O(N^2)
 */
public class GraphRepresentationAdjacencyMatrix {
    public static void main(String[] args) {
        int n = 5;  // Number of nodes
        int[][] matrix = new int[n + 1][n + 1];  // 1-indexed
        // Add undirected edges
        addEdge(matrix, 1, 2);
        addEdge(matrix, 1, 3);
        addEdge(matrix, 2, 4);
        addEdge(matrix, 3, 5);
        // Print the matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    // Mark connection in both directions
    static void addEdge(int[][] matrix, int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1; // For undirected graph
    }
}
