/*
Steps to Find the Number of Connected Components:
    - Initialize visited array: Keep track of visited vertices.
    - Iterate through each vertex: For each unvisited vertex, initiate a DFS or BFS.
    - DFS/BFS traversal: Start from the unvisited vertex and mark all reachable vertices as visited.
    - Count components: Each time a new DFS/BFS is initiated, it represents a new connected component.
*/


import java.util.*;

public class connectedComponents {

    static void DFS_traversal(ArrayList<ArrayList<Integer>> graph, int start, Boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int v1, int v2, Boolean isBidir) {
        graph.get(v1).add(v2);
        if (isBidir) {
            graph.get(v2).add(v1);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.print("Is your graph biDirectional (true/false): ");
        Boolean isBidir = sc.nextBoolean();

        System.out.println("\nEnter all the vertices connections: ");
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            addEdge(graph, v1, v2, isBidir);
        }

        Boolean[] visited = new Boolean[v];
        Arrays.fill(visited, false);

        int components = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                DFS_traversal(graph, i, visited);
                components++;
            }
        }

        System.out.println("\nNumber of connected components: " + components);

        sc.close();
    }
    
}
