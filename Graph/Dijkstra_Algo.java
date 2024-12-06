// The traversal used in the code for Dijkstra's algorithm is Greedy traversal, facilitated by a Priority Queue (min-heap).

import java.util.*;

// Custom class to represent an edge with a destination vertex and a weight
class Edge {
    int destination;
    int weight;

    Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class Dijkstra_Algo {

    // Method to add an edge to the graph (with weight)
    static void addEdge(ArrayList<ArrayList<Edge>> graph, int v1, int v2, int weight, boolean isBidir) {
        graph.get(v1).add(new Edge(v2, weight));

        if (isBidir) {
            graph.get(v2).add(new Edge(v1, weight));
        }
    }

    // Dijkstra's algorithm using a priority queue
    static void dijkstra(ArrayList<ArrayList<Edge>> graph, int source) {
        int v = graph.size();

        // dist array to store the shortest distance from the source to each vertex
        int[] dist = new int[v];

        // Initially, set all distances to a large number (infinity)
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // Distance to the source from itself is 0
        dist[source] = 0;

        // Priority queue to select the edge with the minimum distance so far
        // Each element in the queue is an array [distance, vertex]
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[0] - b[0] );
        pq.add(new int[] {0, source});

        // Visited array to keep track of processed vertices
        boolean[] visited = new boolean[v];

        // While there are vertices to process in the queue
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int currentVertex = current[1];

            // If we've already visited this vertex, skip it
            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            // Explore neighbors
            for (Edge edge : graph.get(currentVertex)) {
                int neighbor = edge.destination;
                int newDist = currentDist + edge.weight;

                // If a shorter path to neighbor is found
                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    pq.add(new int[] {newDist, neighbor});
                }
            }
        }

        // Print shortest distances from source
        System.out.println("\nShortest distances from vertex " + source + ":");
        for (int i = 0; i < v; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        // Initialize graph with ArrayLists to store edges
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        // Create an empty ArrayList for each vertex
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.print("Is your graph biDirectional (true/false): ");
        boolean isBidir = sc.nextBoolean();

        System.out.println("\nEnter all the edges (v1 v2 weight): ");
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            addEdge(graph, v1, v2, weight, isBidir);
        }

        // Display the graph
        System.out.println("\nGraph generated:");
        for (int i = 0; i < v; i++) {
            System.out.print(i + ": ");
            for (Edge edge : graph.get(i)) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }

        System.out.print("\nEnter the source vertex for Dijkstra's algorithm: ");
        int source = sc.nextInt();

        // Run Dijkstra's algorithm from the given source
        dijkstra(graph, source);

        sc.close();
    }
}
