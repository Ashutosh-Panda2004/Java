// package Trees.Traversals;

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

public class Level_order_Traversal {

    static Node input(){
        

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of node (-1 for NULL): ");

        int val = sc.nextInt();

        if(val ==-1) return null;

        Node root = new Node(val);

        System.out.print("Entering the left side of " + root.data + " --> ");
        root.left = input();

        System.out.print("Entering the right side of " + root.data + " --> " );
        root.right = input();

        return root;

    }

    static void level_order(Node root){

        if(root == null) return;

        Queue<Node> qu = new LinkedList<>();

        qu.add(root);

        while(!qu.isEmpty()){

            Node front = qu.poll();
            System.out.print(front.data + " ");

            if(front.left!=null){
                qu.add(front.left);
            }

            if(front.right!=null){
                qu.add(front.right);
            }

        }

    }


    public static void main(String args[]){

        Node root = input();

        level_order(root);

    }
    
}

/*
 * Come to root directory
 * javac Trees/Traversals/Inorder_Traversal.java  --> compilation 
 * java Trees.Traversals.Inorder_Traversal   --> runnin og code 
*/