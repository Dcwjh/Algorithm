package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName InOrder
 * @Date 2021/7/2 12:16
 * @Version 1.0
 */


public class InOrder {

    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        int WHITE = 0;
        int GRAY = 1;
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(WHITE, root));
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (temp.node == null)
                continue;
            if (temp.color == WHITE) {
                stack.push(new Node(WHITE, temp.node.right));
                stack.push(new Node(GRAY, temp.node));
                stack.push(new Node(WHITE, temp.node.left));

            } else {
                res.add(temp.node.val);
            }
        }
        return res;
    }
}
