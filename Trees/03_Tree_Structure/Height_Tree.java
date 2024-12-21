// package Trees.03_Tree_Structure;

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

public class Height_Tree {


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

    static int find_height(Node root){

        if(root==null) return 0;

        int right_height = find_height(root.left);
        int left_height = find_height(root.right);

        int maxi = Math.max(right_height, left_height);

        return maxi+1;

    }
    


    public static void main(String args[]){

        Node root = input();
        int height = find_height(root);

        System.out.print("Height of the Tree (max dist b/w root and leaf node) is : " + height);
        
    }
    
}
