package Tree;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L129
 * @Date 2021/7/2 21:43
 * @Version 1.0
 */


public class L129 {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum){
        if(root == null)
            return 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
