package 剑指offer;

/**
 * @Description 判断是否是平衡二叉树
 * @Author Jianhai Wang
 * @ClassName Interview55_2
 * @Date 2020/6/28 14:18
 * @Version 1.0
 */


public class Interview55_2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //从顶至底（暴力法）,会导致重复遍历
    public boolean isBalanced1(TreeNode root) {
        if(root == null) return true;
        return Math.abs(depth(root.left)- depth(root.right)) < 2 && isBalanced1(root.left) && isBalanced1(root.right);

    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }


    //从底到上，先序遍历          不平衡返回-1
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return recure(root) != -1;
    }

    private int recure(TreeNode root){
        if(root == null) return 0;
        int left = recure(root.left);
        if(left == -1) return -1; //不平衡直接返回，不在计算
        int right = recure(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1: -1;
    }
}
