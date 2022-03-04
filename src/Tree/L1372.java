package Tree;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1372
 * @Date 2021/7/2 15:57
 * @Version 1.0
 */


public class L1372 {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, -1, 0); //左
        dfs(root, 1, 0); //右
        return max;
    }

    private void dfs(TreeNode root, int dir, int len){
        //没有节点，终止
        if(root == null)
            return;
        max = Math.max(len, max);
        if(dir == -1){
            if(root.left !=null){
                //变方向，长度加一
                dfs(root.left, dir * -1, len + 1);
                //不变方向， 新开始
                dfs(root.left, dir, 0);
            }
        } else{
            if(root.right != null){
                //同上
                dfs(root.right, dir * -1, len + 1);
                dfs(root.right, dir, 0);
            }
        }
    }
}
