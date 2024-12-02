/*
One-line step points for the BFS Cycle Detection solution in an Undirected Graph:
    - Initialize Data Structures: Set up an array for parent tracking and visited nodes.
    - Start BFS: Initialize the BFS queue with the start vertex and mark it as visited.
    - Process Queue: Dequeue a vertex, and explore its neighbors.
    - Check for Unvisited Neighbors: If a neighbor is not visited, mark it as visited and enqueue it, updating its parent.
    - Cycle Detection: If a visited neighbor is not the parent of the current vertex, a cycle is detected.
    - Return Result: If a cycle is detected, return true; otherwise, continue processing the graph.
    - Graph Construction: Add edges between vertices based on user input, ensuring it's undirected if specified.
    - Output: Display the graph's adjacency list and whether a cycle exists starting from the user-specified vertex.

*/

import java.util.*;

public class BFS_Cycle_Detection_UndirectedGraph {

    static Boolean BFS_isCycle(ArrayList<ArrayList<Integer>> graph, int start) {

        int v = graph.size();
        int parentArr[] = new int[v];  
        Arrays.fill(parentArr, -1);    

        Boolean visited[] = new Boolean[v];
        Arrays.fill(visited, false);   

        Queue<Integer> qu = new LinkedList<>();

        qu.offer(start);    
        visited[start] = true;

        while (!qu.isEmpty()) {
            int front = qu.poll();

            for (int neighbor : graph.get(front)) {
                // If the neighbor is not visited, mark it as visited and add to queue
                if (!visited[neighbor]) {
                    qu.offer(neighbor);
                    visited[neighbor] = true;
                    parentArr[neighbor] = front;  // Update the parent of the neighbor
                }
                // If the neighbor is visited and is not the parent, a cycle is detected
                else if (parentArr[front] != neighbor) { 
                    System.out.println("Front: " + front + " Neighbor: " + neighbor);
                    return true;
                }
            }
        }

        return false;  
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

        System.out.print("Is your graph biDirectional (true/false): ");
        Boolean isBidir = sc.nextBoolean();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.print("\nEnter all the vertices connections (v1,v2) [0 based indexing only]: ");
        for (int i = 0; i < e; i++) {

            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            addEdge(graph, v1, v2, isBidir);
        }

        System.out.println("\nGraph generated: ");
        for (int i = 0; i < v; i++) {
            System.out.print(i + " --> ");
            for (int neighbors : graph.get(i)) {
                System.out.print(neighbors + " ");
            }
            System.out.println(" ");
        }

        System.out.print("\nEnter your starting vertex: ");
        int start = sc.nextInt();

        Boolean cycle = BFS_isCycle(graph, start);

        if (cycle == true) {
            System.out.println("Cycle Detected !");
        } else {
            System.out.println("Cycle NOT Detected !");
        }

        sc.close();
    }
}
