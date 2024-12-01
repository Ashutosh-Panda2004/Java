// adjacencyMatrix representation of graph

import java.util.Scanner;

public class matrix_representation {

    static void addEdge(int[][] graph, int v1, int v2, boolean isBidir) {
        graph[v1][v2] = 1;

        if (isBidir) {
            graph[v2][v1] = 1;
        }
    }


    static void printMatrix(int[][] graph) {
        int V = graph.length;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        int[][] graph = new int[v][v];

        System.out.print("Is your graph biDirectional (true/false): ");
        boolean isBidir = sc.nextBoolean();

        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter all the vertices connections (v1 v2): ");
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();  
            int v2 = sc.nextInt();  
            addEdge(graph, v1, v2, isBidir);
        }

        System.out.println("Adjacency Matrix Representation of the Graph:");
        printMatrix(graph);

        sc.close();
    }
}
