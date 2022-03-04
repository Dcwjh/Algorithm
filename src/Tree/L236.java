package Tree;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L236
 * @Date 2021/7/3 16:23
 * @Version 1.0
 */


public class L236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null){
            return null;
        }
        if(left != null && right != null){
            return root;
        }
        return left == null? right : left;
    }
}
