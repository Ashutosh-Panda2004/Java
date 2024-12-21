/*
A binary heap is a complete binary tree that satisfies the heap property. There are two types of heaps:

1.) Max Heap: The value of each node is greater than or equal to the values of its children.
2.) Min Heap: The value of each node is less than or equal to the values of its children.


For this example, we will focus on checking if a given binary tree is a Max Heap. A tree is a max heap if:
1.) It is a complete binary tree.
2.) The value of each node is greater than or equal to the values of its children.

*/

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

public class Binary_Tree_Heap_or_Not {

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

    static int count_nodes(Node root){
        if(root==null) return 0;
        int left_nodes = count_nodes(root.left);
        int right_nodes = count_nodes(root.right);

        return (left_nodes+right_nodes+1);
    }


    static Boolean is_complete(Node root, int idx, int node_count){

        if(root==null) return true;

        if(idx>=node_count) return false;

        return is_complete(root, 2*idx + 1, node_count) && is_complete(root, 2*idx + 2, node_count) ;

    }


    static Boolean is_max_heap(Node root){

        if(root == null) return true;

        if(root.left==null && root.right==null){  // if leave return true
            return true;
        }

        if(root.left != null && root.data < (root.left.data)){
            return false;
        }

        if(root.right != null && root.data < (root.right.data)){
            return false;
        }

        return (is_max_heap(root.left) && is_max_heap(root.right));


    }

    public static void main(String args[]){
        Node root = input();

        int node_count = count_nodes(root);
        int idx = 0;

        if(is_complete(root, idx, node_count) && is_max_heap(root)){
            System.out.print("This binary tree is a heap !");
        }
        else{
            System.out.print("This binary tree is not a heap !");
        }
      
    }
    
}
