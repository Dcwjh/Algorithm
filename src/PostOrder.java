import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PostOrder
 * @Date 2021/9/4 22:24
 * @Version 1.0
 */


public class PostOrder {
    class Node{
        int color;
        TreeNode node;
        public Node(int color, TreeNode node){
            this.color = color;
            this.node = node;

        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

    }

    public void postOrder(TreeNode root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, root));
        ArrayList<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.color == 1){
                res.add(temp.node.val);
            } else {
                queue.add(new Node(1, temp.node));
                if(temp.node.right != null){
                    queue.add(new Node(10, temp.node.right));
                }
                if(temp.node.left != null){
                    queue.add(new Node(10, temp.node.left));
                }
            }
        }
    }
}
