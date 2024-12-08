/*
In both trees and graphs, BFS traversal explores nodes level by level, starting from the source (root in trees, starting node in graphs).

- In trees, BFS (level-order) visits all nodes at the current level before moving to the next level.

- In graphs, BFS explores all neighboring nodes of the current node before moving to the next level of neighbors.

In both cases, a queue is used to manage the nodes to be visited.

*/

import java.util.*;

public class BFS_traversal_graph {

    static void BFS_traversal(ArrayList<ArrayList<Integer>> graph , int start, ArrayList<Integer>BFS_ans){

        int vertices = graph.size();
        Boolean visited[] = new Boolean[vertices];
        Arrays.fill(visited, false);            // Remember this !!!
        Queue<Integer> qu = new LinkedList<>();

        qu.offer(start);
        visited[start] = true;

        while(!qu.isEmpty()){

            int front = qu.poll();
            BFS_ans.add(front);

            for(int neighbor : graph.get(front)){
                if(!visited[neighbor]){
                    visited[neighbor] =  true;
                    qu.offer(neighbor);
                }
            }

        }
        

    }

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

        System.out.print("\nEnter the starting point of the BFS traversal: ");
        int start = sc.nextInt();

        ArrayList<Integer>BFS_ans = new ArrayList<>();
        BFS_traversal(graph, start, BFS_ans);

        System.out.println("\nBFS traversal sequence: ");
        for(int i : BFS_ans){
            System.out.print(i + " ");
        }



        sc.close();





    }
    
}
