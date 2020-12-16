package Leetcode;

import java.util.LinkedList;
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
    /**
     *
     * @param root
     * @return
     * @version 1.0
     */
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

    /**
     * @version 2.0
     */

    /**
     * 错误思路： 中序遍历后判断是否回文
     * 我是采用中序遍历，先LNR，再用RNL返回字符串，判断字符串是否相等的思路
     * 错误用例： [1,2,2,2,null,2] ，改测试用例中序遍历是一个回文序列
     *                             1
     *                           /  \
     *                         2      2
     *                       / \     / \
     *                      2   #   2   #
     *                    / \      / \
     *                   #  #     #  #
     *
     */
    static StringBuilder sb1  = new StringBuilder();
    static StringBuilder sb2  = new StringBuilder();

    //LNR 和 LRN序列岂不是一样的
    public static boolean isSymmetric1(TreeNode root) {
            if(root == null) return true;
            return LNR(root).equals(RNL(root));
        }

        private static String LNR(TreeNode root){
            if(root == null)
                return null;

            if(root.left == null) sb1.append("#");
            LNR(root.left);
            sb1.append(root.val);
            if(root.right == null) sb1.append("#");
            LNR(root.right);
            return sb1.toString();
        }

        private static String RNL(TreeNode root){
            if(root == null)
                return null;
            if(root.right == null) sb2.append("#");
            RNL(root.right);
            sb2.append(root.val);
            if(root.left == null) sb2.append("#");
            RNL(root.left);
            return sb2.toString();
    }


    /**
     *
     * @param args
     * @version 1.0
     */
    public boolean isSymmetric2(TreeNode root) {
            if(root == null) return true;
            return recure(root.left, root.right);
        }

        private boolean recure(TreeNode left, TreeNode right){
            if(left == null && right==null)
                return true;
            if(left == null || right == null)
                return false;
            if(left.val != right.val)
                return false;
            //仔细看，这里容易出错
            return recure(left.left,right.right) && recure(left.right,right.left);
    }





    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(3);
        System.out.println(isSymmetric1(root1));
    }

}
