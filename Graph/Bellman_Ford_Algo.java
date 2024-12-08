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

public class Bellman_Ford_Algo {

    // Method to add an edge to the graph (with weight)
    static void addEdge(ArrayList<ArrayList<Edge>> graph, int v1, int v2, int weight, boolean isBidir) {
        graph.get(v1).add(new Edge(v2, weight));
        if (isBidir) {
            graph.get(v2).add(new Edge(v1, weight));
        }
    }

    // Bellman-Ford algorithm
    static void bellmanFord(ArrayList<ArrayList<Edge>> graph, int source) {
        int V = graph.size();
        int[] dist = new int[V];

        // Initialize distances: infinity for all except source which is 0
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge edge : graph.get(u)) {
                    int v = edge.destination;
                    int w = edge.weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        // Check for negative weight cycles by trying to relax once more
        boolean negativeCycle = false;
        for (int u = 0; u < V; u++) {
            for (Edge edge : graph.get(u)) {
                int v = edge.destination;
                int w = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    negativeCycle = true;
                    break;
                }
            }
            if (negativeCycle) break;
        }

        if (negativeCycle) {
            System.out.println("\nGraph contains a negative weight cycle reachable from the source.");
        } else {
            System.out.println("\nShortest distances from vertex " + source + ":");
            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + ": " + dist[i]);
            }
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

        System.out.print("\nEnter the source vertex for Bellman-Ford algorithm: ");
        int source = sc.nextInt();

        // Run Bellman-Ford from the given source
        bellmanFord(graph, source);

        sc.close();
    }
}
