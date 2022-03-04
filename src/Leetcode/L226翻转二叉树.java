package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L226翻转二叉树
 * @Date 2021/8/8 16:23
 * @Version 1.0
 */


public class L226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right  = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
