package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L199二叉树的右视图
 * @Date 2021/8/7 19:26
 * @Version 1.0
 */


public class L199二叉树的右视图 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root != null )
            deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = deque.poll();
                if(i == 0) res.add(temp.val);
                if(temp.right != null) deque.add(temp.right);
                if(temp.left != null) deque.add(temp.left);
            }

        }
        return res;
    }



    public List<Integer> rightSideView2(TreeNode root) {
        if(root == null)
            return res;
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int length){
        if(root == null)
            return;
        if(length == res.size()){
            res.add(root.val);
        }
        length ++;
        dfs(root.right, length);
        dfs(root.left, length);
    }
}
