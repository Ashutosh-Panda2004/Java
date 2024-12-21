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

class Pair{
    int hd;
    Node node;

    Pair(int hd, Node node){
        this.hd = hd;
        this.node = node;
    }
}

public class Top_View {

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

    static void top_view(Node root){

        if(root==null) return;

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> qu = new LinkedList<>();

        qu.add(new Pair(0, root));

        while(!qu.isEmpty()){

            int size = qu.size();

            for(int i=0; i<size; i++){

                Pair front = qu.poll();
                int hd = front.hd;
                Node node = front.node;

                if(!mp.containsKey(hd)){
                    mp.put(hd, node.data);   // ONLY PUT IF ABSENT
                }

                if(node.left!=null){
                    qu.add(new Pair(hd-1, node.left));
                }

                if(node.right!=null){
                    qu.add(new Pair(hd+1, node.right));
                }
            }
        }

        for(int val : mp.values()){
            System.out.print(val + " ");
        }
    }

    public static void main(String args[]){

        Node root = input();
        top_view(root);


    }
    
}
