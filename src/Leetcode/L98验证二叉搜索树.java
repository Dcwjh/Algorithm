package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L98验证二叉搜索树
 * @Date 2021/8/9 0:16
 * @Version 1.0
 */


public class L98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if(root == null ) return true;
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }
    public boolean dfs(TreeNode root, long left, long right){
        if(root == null) return true;

        if(root.val <= left) return false;
        if(root.val >= right) return false;

        return dfs(root.left, left, root.val) && dfs(root.right, root.val, right);
    }


    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
