/*

DFS in Trees:
    - Typically follows Preorder, Inorder, or Postorder traversal.
        Preorder: Visit node, left, right.
        Inorder: Visit left, node, right.
        Postorder: Visit left, right, node.

DFS in Graphs:
    - Same traversal concept as trees, but requires a visited check to avoid revisiting nodes.
    - Can be implemented recursively or iteratively.
    - The traversal order depends on how you visit neighbors, but in general, it explores as deep as possible along one path before backtracking.

*/

import java.util.*;

public class recursive_DFS_traversal_graph {

    static void DFS_traversal(ArrayList<ArrayList<Integer>> graph, int start, Boolean[] visited, ArrayList<Integer> DFS_ans) {

        visited[start] = true;
        DFS_ans.add(start);  

        for (int neighbor : graph.get(start)) {
            if (!visited[neighbor]) {
                DFS_traversal(graph, neighbor, visited, DFS_ans);  
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
            addEdge(graph, v1, v2, isBidir);  // Add edge between v1 and v2
        }

        System.out.println("\nGraph generated:");
        for (int i = 0; i < v; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.print("\nEnter the starting point of the DFS traversal: ");
        int start = sc.nextInt();

        Boolean[] visited = new Boolean[v];
        Arrays.fill(visited, false);  // Initialize all vertices as unvisited
        ArrayList<Integer> DFS_ans = new ArrayList<>();

        DFS_traversal(graph, start, visited, DFS_ans);

        System.out.println("\nDFS traversal sequence: ");
        for (int i : DFS_ans) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}
