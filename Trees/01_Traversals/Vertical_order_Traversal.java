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

class Pair{
    int hd;
    Node node;

    Pair(int hd, Node node){
        this.hd = hd;
        this.node = node;
    }
}

public class Vertical_order_Traversal {

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

    static void vertical_order(Node root){

        if(root == null) return;

        TreeMap<Integer, List<Integer>> mp  = new TreeMap<>();

        Queue<Pair> qu = new LinkedList<>(); 
        qu.add(new Pair(0, root));

        while(!qu.isEmpty()){
            Pair front = qu.poll();
            int hd = front.hd;
            Node node = front.node;

            if(!mp.containsKey(hd)){
                mp.put(hd, new ArrayList<>());
            }

            mp.get(hd).add(node.data);

            if(node.left!=null){
                qu.add(new Pair(hd-1, node.left));
            }

            if(node.right!=null){
                qu.add(new Pair(hd+1, node.right));
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : mp.entrySet()){
            for(int value : entry.getValue()){
                System.out.print(value + " ");
            }
        }


    }

    public static void main(String args[]){

        Node root = input();

        vertical_order(root);

    }
    
}


/*
 * Come to root directory
 * javac Trees/Traversals/Vertical_order_Traversal.java  --> compilation 
 * java Trees.Traversals.Vertical_order_Traversal   --> runnin og code 
*/