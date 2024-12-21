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

public class Balanced_Binary_Tree {

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

        int left_height = find_height(root.left);
        int right_height = find_height(root.right);

        int maxi = Math.max(left_height, right_height);

        return maxi+1;
    }


    static Boolean is_balanced(Node root){

        if(root==null) return true;   // this case should always be true 

        // check for curr node
        int left_height = find_height(root.left);
        int right_height = find_height(root.right);
        Boolean curr_ans = Math.abs(left_height-right_height)<=1;

        // check for left node (recur call)
        Boolean left_ans = is_balanced(root.left);

        // check for right node (recur call)
        Boolean right_ans = is_balanced(root.right);

        return (curr_ans && left_ans && right_ans);

    }

    public static void main(String args[]){
        Node root = input();
        if(is_balanced(root)){
            System.out.print("Tree is Balanced !");
        }
        else{
            System.out.print("Tree is not balanced !");
        }
    }

    
    
}
