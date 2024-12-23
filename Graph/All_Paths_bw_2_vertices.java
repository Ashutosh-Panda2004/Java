import java.util.*;

public class All_Paths_bw_2_vertices {

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

    static void giveAllPaths(ArrayList<ArrayList<Integer>> graph){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the source: ");
        int src = sc.nextInt();

        System.out.print("Enter the destination: ");
        int dest = sc.nextInt();

        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> currPath = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();

        dfs(graph, src, dest, visited, currPath, allPaths);

        System.out.println("\nAll Paths from " + src + " to " + dest + " :");
        for(int i=0; i<allPaths.size(); i++){
            System.out.print("{");
            for(int j = 0; j < allPaths.get(i).size(); j++){
                System.out.print(allPaths.get(i).get(j) + " ");
            }
            System.out.print("} ");
        }



        
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int src, int dest,   Set<Integer> visited ,ArrayList<Integer> currPath, ArrayList<ArrayList<Integer>> allPaths){

        if(src==dest){
            currPath.add(src);
            allPaths.add(new ArrayList<>(currPath));
            currPath.remove(currPath.size()-1);
            return;
        }


        visited.add(src);
        currPath.add(src);

        for(int neighbor : graph.get(src)){
            if(!visited.contains(neighbor)){
                dfs(graph, neighbor, dest, visited ,currPath, allPaths);
            }
        }

        currPath.remove(currPath.size()-1);
        visited.remove(src);
        return;


    }


    public static void main(String args[]){

        ArrayList<ArrayList<Integer>> graph = buildGraph();

        displayGraph(graph);

        giveAllPaths(graph);

        




    }



    
}
