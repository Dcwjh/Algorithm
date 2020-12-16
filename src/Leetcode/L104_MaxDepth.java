package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 二叉树的最大深度
 * @Author Jianhai Wang
 * @ClassName MaxDepth_104
 * @Date 2019/12/22 15:39
 * @Version 1.0
 */


public class L104_MaxDepth {

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1 ;
    }


    //队列
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

}
