package 剑指offer;

/**
 * @Description 二叉搜索树的第K大节点（树的中序遍历）
 * @Author Jianhai Wang
 * @ClassName Interview54
 * @Date 2020/6/28 10:43
 * @Version 1.0
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }



 //leetcode和剑指offer的题目不一样，这是是右节点，处理，左节点
public class Interview54 {
    private int count;
    private int result = -1;
    public int kthLargest(TreeNode root, int k) {
        if(root == null || k==0)
            return -1;
        this.count = k;
        KthNodeCore(root);
        return result;
    }

    private void KthNodeCore(TreeNode root){
        if(root.right!=null){
            KthNodeCore(root.right);
        }
        if(count == 1){
            result = root.val;
            count--;
            return;
        }
        count--;
        if(root.left!= null)
            KthNodeCore(root.left);
    }

}
