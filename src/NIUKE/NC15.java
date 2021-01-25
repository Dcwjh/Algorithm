package NIUKE;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC15
 * @Date 1/13/2021 11:31 AM
 * @Version 1.0
 */


public class NC15 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    private ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        if(root == null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 0; i< size; i++){
                TreeNode node = queue.poll();
                ans.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            list.add(ans);

        }
        return list;


    }
}
