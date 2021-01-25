package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC102
 * @Date 1/20/2021 8:46 PM
 * @Version 1.0
 */


public class NC102 {
    //两种方法：修改数据结构，增加指针parent
    //给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。必定存在
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(root==null) return -1;
        if(o1==root.val || o2==root.val) return root.val; //如果左右节点是一个
        int left = lowestCommonAncestor(root.left, o1, o2); //左子树查找
        int right = lowestCommonAncestor(root.right,o1,o2);//右子树查找
        //递归深度不同，都有可能
        if(left ==-1) return right; //左子树没有，那右子树就是顶点
        if(right ==-1)  return left; //右子树没有，那就在左子树中
        return root.val;
    }
}
