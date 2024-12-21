// package Trees.Views;

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


public class Left_View {

    static Node input(){

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the node value (-1 for NULL): ");
        int val = sc.nextInt();
        
        if(val == -1 ) return null;

        Node root = new Node(val);

        System.out.print("Entering left side of " + root.data + " --> ");
        root.left = input();

        System.out.print("Entering right side of " + root.data + " --> ");
        root.right = input();


        return root;
        
    }

    static void left_view(Node root){

        if(root==null) return;

        Queue<Node> qu = new LinkedList<>();

        qu.add(root);

        while(!qu.isEmpty()){
            int size = qu.size();

            for(int i=0; i<size; i++){

                Node front = qu.poll();

                if(i==0){
                    System.out.print(front.data + " ");
                }

                if(front.left!=null){
                    qu.add(front.left);
                }

                if(front.right!=null){
                    qu.add(front.right);
                }
            }
        }
    }

    public static void  main(String args[]){

        Node root = input();

        left_view(root);

    }
    
}
