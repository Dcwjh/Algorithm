package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName IsSameTree_100
 * @Date 2019/12/22 14:47
 * @Version 1.0
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class IsSameTree_100 {
    public static boolean isSameTree(TreeNode p, TreeNode q){
        String s1 = trace(p);
        String s2 = trace(q);
        return s1.equals(s2);
    }

    private static String trace(TreeNode root){
        if(root == null)
            return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(trace(root.left));
        sb.append(trace(root.right));
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(1);
        head.right = new TreeNode(4);
        System.out.println(trace(head));
    }
}
