import java.util.*;

public class DFS_Cycle_Detection_UndirectedGraph {
    
    static boolean recursive_DFS_isCycle(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;

        for (int neighbor : graph.get(vertex)) {
            // If the neighbor is not visited, recursively visit it
            if (!visited[neighbor]) {
                if (recursive_DFS_isCycle(graph, neighbor, visited, vertex)) {
                    return true;  // Cycle detected
                }
            }
            // If the neighbor is visited and is not the parent, a cycle is detected
            else if (neighbor != parent) {
                return true;  // Cycle detected
            }
        }

        return false;  // No cycle detected
    }

    static boolean iterative_DFS_isCycle(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
        Stack<int[]> stack = new Stack<>();  // Stack stores pairs of (currentNode, parentNode)
        stack.push(new int[]{start, -1});    // Start from 'start' node, and set its parent to -1

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int vertex = current[0];
            int parent = current[1];

            // Mark the current vertex as visited
            if (visited[vertex]) continue;  // Skip if already visited
            visited[vertex] = true;

            // Explore the neighbors
            for (int neighbor : graph.get(vertex)) {
                // If the neighbor is not visited, push it to the stack
                if (!visited[neighbor]) {
                    stack.push(new int[]{neighbor, vertex});
                }
                // If the neighbor is visited and is not the parent, a cycle is detected
                else if (neighbor != parent) {
                    return true;  // Cycle detected
                }
            }
        }
        return false;  // No cycle detected
    }

    // Function to add an edge to the graph (undirected)
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int v1, int v2, boolean isBidir) {
        graph.get(v1).add(v2);
        if (isBidir) {
            graph.get(v2).add(v1);
        }
    }

    // Main function to read input and detect cycles
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        System.out.print("Is your graph biDirectional (true/false): ");
        boolean isBidir = sc.nextBoolean();

        // Initialize the graph (adjacency list representation)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        // Input the edges
        System.out.println("\nEnter all the vertices connections (v1, v2) [0-based indexing only]: ");
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            addEdge(graph, v1, v2, isBidir);
        }

        // Display the graph
        System.out.println("\nGraph generated: ");
        for (int i = 0; i < v; i++) {
            System.out.print(i + " --> ");
            for (int neighbor : graph.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        // Initialize visited array
        boolean[] visited = new boolean[v];

        // Perform DFS cycle detection for each component of the graph
        boolean cycleDetected = false;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (recursive_DFS_isCycle(graph, i, visited, -1)) {
                    cycleDetected = true;
                    break;  // Stop if cycle is detected
                }
            }
        }

        // Output the result
        if (cycleDetected) {
            System.out.println("Cycle Detected!");
        } else {
            System.out.println("Cycle NOT Detected!");
        }

        sc.close();
    }
}
