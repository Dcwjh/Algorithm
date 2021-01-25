package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC62
 * @Date 2021/1/22 15:25
 * @Version 1.0
 */


public class NC62 {
    private Boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        getDepth(root);
        return flag;
    }

    private int getDepth(TreeNode root){
        if(root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left - right) > 1){
            flag = false;
        }
        return left > right ? left + 1: right + 1;
    }
}
