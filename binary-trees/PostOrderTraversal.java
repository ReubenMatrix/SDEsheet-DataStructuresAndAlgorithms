import java.util.ArrayList;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }

}


public class PostOrderTraversal {
    static void postorder(Node curr, ArrayList <Integer> postordertrav){
        if(curr==null){
            return;
        }
        postorder(curr.left,postordertrav);
        postordertrav.add(curr.data);
        postorder(curr.right,postordertrav);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList < Integer > postordertrav = new ArrayList < > ();
        postorder(root, postordertrav);

        System.out.print("The PostOrder Traversal is : ");
        for (int i = 0; i < postordertrav.size(); i++) {
            System.out.print(postordertrav.get(i) + " ");
        }

    }
}
