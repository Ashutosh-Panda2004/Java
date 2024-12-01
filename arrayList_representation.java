// ArrayList representation of Graph for 0 based indexing 


import java.util.*;
public class arrayList_representation {


    static void addEdge(ArrayList<ArrayList<Integer>> graph, int v1, int v2, Boolean isBidir){

        graph.get(v1).add(v2);

        if(isBidir){
            graph.get(v2).add(v1);
        }

    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter the number of edges: ");
        int e  = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<v ; i++){
            graph.add(new ArrayList<>());
        }

        System.out.print("Is your graph biDirectional (true/false): ");
        Boolean isBidir = sc.nextBoolean();

        System.out.println("\n Enter all the vertices connections: ");
        for(int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            addEdge(graph, v1, v2, isBidir);
        }

        System.out.println("\n" + "Graph generated:");

        for(int i=0; i<v; i++){
            System.out.print(i + ": ");
            
            for(int j=0; j<graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j) + " ");
            }

            System.out.println(" ");
        }

        sc.close();





    }
    
}
