package Testpad_Sawaals;
import java.util.*;

class Edge {
    int vertex; 
    int weight;

    Edge(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Dijkstra_Algorithm {

    static void Dijkstra(ArrayList<ArrayList<Edge>> graph){

        


    }



    static void display(ArrayList<ArrayList<Edge>> graph){

        System.out.println("\nGraph Generated : ");

        for(int i=0; i<graph.size(); i++){
            System.out.print(i + " --> ");
            for(Edge e : graph.get(i)){
                System.out.print(e.vertex + " ");
                System.out.print(e.weight);
            }
            System.out.println("");
        }

    }



    static void addEdge(ArrayList<ArrayList<Edge>>graph ,int v1, int v2, int w, Boolean isBidir){

        graph.get(v1).add(new Edge(v2, w));

        if(isBidir){
            graph.get(v2).add(new Edge(v1, w));
        }


    }



    

    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter the number of Vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter the number of Edges: ");
        int e = sc.nextInt();

        System.out.print("Is your graph Bidirectional (true/false): ");
        Boolean isBidir = sc.nextBoolean();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.print("Enter the V1 and V2 and correspoding weight in form of v1, v2, w");

        for(int i=0; i<e; i++){

            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();

            addEdge(graph, v1, v2,w, isBidir);
            
        }






        sc.close();





      
        
    }
    
}
