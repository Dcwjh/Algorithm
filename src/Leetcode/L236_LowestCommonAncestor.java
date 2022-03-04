package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L236_LowestCommonAncestor
 * @Date 2021/6/11 11:27
 * @Version 1.0
 */


public class L236_LowestCommonAncestor {
    //模板写答案
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root; //其中一个节点是根节点（不是绝对的根节点）

        TreeNode left = lowestCommonAncestor(root.left, p, q); // 找到其中一个
        TreeNode right = lowestCommonAncestor(root.right, p, q); //可能找打另一个

        if(left == null && right == null){ //一侧都没找找到，就返回空
            return null;
        }
        if(left != null && right != null){ //分布在两侧，那就是根节点了
            return root;
        }

        return left == null? right : left;  //一侧没有就在另一侧，那么他就是公共节点了
    }
}
