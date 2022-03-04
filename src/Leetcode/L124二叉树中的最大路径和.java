package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L124二叉树中的最大路径和
 * @Date 2021/8/7 21:09
 * @Version 1.0
 */


public class L124二叉树中的最大路径和 {
    int res = Integer.MIN_VALUE;
    /*
    这是一个错误答案，他返回的是一条叶子节点到叶子节点的路径
     */
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return res;
        res = Math.max(maxPathSum(root.left), res);
        res = Math.max(maxPathSum(root.right), res);
        res = Math.max(dfs(root.left, 0) + root.val + dfs(root.right, 0), res);
        return res;
    }

    public int dfs(TreeNode root, int sum){
        if(root == null) return sum;
        sum += root.val;
        return Math.max(dfs(root.left, sum), dfs(root.right, sum));
    }







    public int maxPathSum3(TreeNode root) {
        if(root == null)
            return res;
        dfs(root);
        return res;
    }

    //找到节点的单边最大路径，起辅助功能
    public int dfs(TreeNode root){
        //空节点 无贡献
        if(root == null) return 0;
        //保存左右节点的最大单边路径，若小于0，则还不如不加,一旦加了0就相当于，那边不用在递归了
        int l = Math.max(dfs(root.left), 0);
        int r = Math.max(dfs(root.right), 0);
        //当前节点为顶点的最大路径，更新max
        res = Math.max(res, l + r + root.val);
        //返回以当前节点为顶点的单边最大路径，为上一层节点做贡献
        return root.val + Math.max(l, r);
    }
}
