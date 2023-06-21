import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Treenode{
    int val;
    Treenode left;
    Treenode right;
    Treenode(int val){
        this.val=val;
    }

}

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Treenode root=new Treenode(1);
        root.left=new Treenode(2);
        root.right=new Treenode(3);
        root.left.left=new Treenode(4);
        root.left.right=new Treenode(5);

        List<Integer> result = Levelorder(root);
        System.out.println(result);
    }


    static List<Integer> Levelorder(Treenode root){
        Queue <Treenode> queue=new LinkedList<>();
        List<Integer>wraplist=new ArrayList<>();

        if(root==null){
            return wraplist;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            Treenode node=queue.poll();
            wraplist.add(node.val);

            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return wraplist;


    }

}
