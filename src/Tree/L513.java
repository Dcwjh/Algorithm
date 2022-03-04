package Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L513
 * @Date 2021/7/2 15:12
 * @Version 1.0
 */


public class L513 {
    //返回每层第一个
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == 0) res = cur.val;//每一层的第一个点
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return res;
    }


    //右左根， 最后一个节点
    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                res = cur.val;
                if (cur.right != null) q.offer(cur.right);
                if (cur.left != null) q.offer(cur.left);
            }
        }
        return res;
    }


    int maxDepth = -1, res = 0;

    public int findBottomLeftValue3(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        dfs(root.left, depth + 1);
        if (depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        }
        dfs(root.right, depth + 1);
    }

    //自己写的

    public int findBottomLeftValue4(TreeNode root) {
        int max = maxLength(root);
        int deep = 1;
        Queue<TreeNode> que  = new ArrayDeque<TreeNode>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                TreeNode node = que.poll();
                if(max == deep){
                    return node.val;
                }
                if( node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            deep++;
        }

        return -1;
    }


    private int maxLength(TreeNode root){
        if(root == null)
            return 0;

        return Math.max(maxLength(root.left),maxLength(root.right)) + 1;
    }

}
