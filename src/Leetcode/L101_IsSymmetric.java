package Leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description 就像人站在镜子前审视自己那样。镜中的反射与现实中的人具有相同的头部，
 *              但反射的右臂对应于人的左臂，反之亦然。
 *              因此每个对象都有两个变量
 * @Author Jianhai Wang
 * @ClassName IsSymmetric_101
 * @Date 2019/12/22 15:02
 * @Version 1.0
 */



public class L101_IsSymmetric {
    public boolean isSymmetric_recursion(TreeNode root) {
        return isMirror(root, root);
    }
    public static boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        return (p.val == q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }

    public boolean isSymmetric_iteration(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);//左臂
        q.add(root);//镜子中左臂（实际调用右臂）

        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2!=null)
                return false;
            if(t1 != null && t2 == null)
                return false;
            if(t1 == null && t2 == null)
                continue;
            if(t1.val != t2.val)
                return false;

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;

    }

}
