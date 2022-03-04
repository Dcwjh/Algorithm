package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PreOrder
 * @Date 2021/7/2 11:50
 * @Version 1.0
 */



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        int WHITE = 0;//第一次入栈，访问需要他的右左子节点入栈
        int GRAY = 1;//第二次入栈其实下次访问要输出，没屌用。（标识用的）
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(WHITE, root));
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (temp.node == null)
                continue;
            if (temp.color == WHITE) {
                stack.push(new Node(WHITE, temp.node.right));
                stack.push(new Node(WHITE, temp.node.left));
                stack.push(new Node(GRAY, temp.node));
            } else {
                res.add(temp.node.val);
            }
        }
        return res;
    }

    //递归
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root == null)
            return list;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }



}
