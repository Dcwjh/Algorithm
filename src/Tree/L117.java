package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L117
 * @Date 2021/7/2 21:23
 * @Version 1.0
 */


public class L117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            Node pre = null;
            Node cur = null;
            for(int i = 0; i < size; i++){
                cur = que.poll();
                if(pre != null){
                    pre.next = cur;
                }
                pre = cur;
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
            }
        }
        return root;
    }
}
