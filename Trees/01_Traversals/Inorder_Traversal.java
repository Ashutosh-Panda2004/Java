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

public class Inorder_Traversal {

    static Node input(){

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the node value (-1 for NULL): ");
        
        int val = sc.nextInt();

        if(val==-1) return null;

        Node root = new Node(val);


        System.out.print("Entering the left side of the "+ root.data + " --> ");
        root.left = input();

        System.out.print("Entering the right side of the "+ root.data + " --> ");
        root.right = input();

        return root;
    }

    // inorder --> LNR
    // preorder --> NLR
    // postorder --> LRN

    static void inorderTrav(Node root){

        if(root==null) return;
        inorderTrav(root.left);
        System.out.print(root.data + " ");
        inorderTrav(root.right);

    }

    
    
    public static void main(String args[]){

        Node root = input();

        inorderTrav(root);

    }


    
}

