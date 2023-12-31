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


public class InorderTraversal {
    static void inorder(Node curr, ArrayList <Integer> inordertrav){
        if(curr==null){
            return;
        }
        inorder(curr.left,inordertrav);
        inordertrav.add(curr.data);
        inorder(curr.right,inordertrav);
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

        ArrayList < Integer > inordertrav = new ArrayList < > ();
        inorder(root, inordertrav);

        System.out.print("The inOrder Traversal is : ");
        for (int i = 0; i < inordertrav.size(); i++) {
            System.out.print(inordertrav.get(i) + " ");
        }

    }
}
