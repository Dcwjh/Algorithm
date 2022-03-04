package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L543二叉树的直径
 * @Date 2021/8/8 16:42
 * @Version 1.0
 */


public class L543二叉树的直径 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return max - 1;
    }


    public int dfs(TreeNode root){
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        max = Math.max(l + r + 1, max);
        return Math.max(l, r) + 1;
    }
}
