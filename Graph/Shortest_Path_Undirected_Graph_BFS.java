import java.util.*;

public class Shortest_Path_Undirected_Graph_BFS {


    static void addEdge(ArrayList<ArrayList<Integer>> graph, int v1, int v2, Boolean isBidir){

        graph.get(v1).add(v2);

        if(isBidir){
            graph.get(v2).add(v1);
        }

        return;
    }


    static ArrayList<ArrayList<Integer>> buildGraph(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        System.out.print("Is your graph bidirectional (true/false): ");
        Boolean isBidir = sc.nextBoolean();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<v; i++){
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter the connections (v1,v2): ");
        for(int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            if (v1 >= v || v2 >= v || v1 < 0 || v2 < 0) {
                System.out.println("Invalid vertices, please enter values within the range 0 to " + (v - 1));
                i--;  // Re-enter the current edge input
                continue;
            }

            addEdge(graph, v1, v2, isBidir);

        }

        return graph;

    }

    static void  displayGraph(ArrayList<ArrayList<Integer>> graph){

        System.out.println("\nGraph generated: ");

        for(int i=0; i<graph.size(); i++){
            System.out.print(i + " --> ");
            for(int neighbor : graph.get(i)){
                System.out.print(neighbor + " ");
            }
            System.out.println(" ");
        }


        System.out.println(" ");
    }

    static void find_ShortestPath(ArrayList<ArrayList<Integer>> graph){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the source: ");
        int src = sc.nextInt();

        System.out.print("Enter the destination: ");
        int dest = sc.nextInt();

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] distArr = new int[graph.size()];
        Arrays.fill(distArr, Integer.MIN_VALUE);

        bfs(graph, src, dest, visited,queue, distArr);

        System.out.println("Shortest dist b/w " + src + " and " +  dest + " is: " + distArr[dest]);

    
    }


    static void bfs(ArrayList<ArrayList<Integer>> graph, int src, int dest, Set<Integer> visited, Queue<Integer> queue, int[] distArr){

        queue.offer(src);
        visited.add(src);
        distArr[src]=0;

        while(!queue.isEmpty()){

            int curr = queue.poll();

           for(int neighbor : graph.get(curr)){
            if(!visited.contains(neighbor)){
                queue.offer(neighbor);
                visited.add(neighbor);
                distArr[neighbor] = distArr[curr]+1;
            }
           }


        }





    }



    public static void main(String args[]){

         ArrayList<ArrayList<Integer>> graph = buildGraph();

        displayGraph(graph);

        find_ShortestPath(graph);




    }

    
    
}
