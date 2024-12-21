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

public class Diameter_Tree {

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

        if(root ==null) return 0;

        int left_height = find_height(root.left);

        int right_height = find_height(root.right);

        return Math.max(left_height, right_height) +1;

    }


    static int find_diameter(Node root){

        if(root==null) return 0;

        int left_ans = find_height(root.left);

        int right_ans = find_height(root.right);

        int root_combined = left_ans + right_ans +1;

        int left_diameter = find_diameter(root.left);
        int right_diameter = find_diameter(root.right);

        return Math.max(root_combined, Math.max(left_diameter, right_diameter));

        

    }

    public static void main(String args[]){
        Node root = input();

        System.out.print("Diameter of the tree is : " + find_diameter(root));



        
    }

    
}
