package NIUKE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC14
 * @Date 1/18/2021 11:27 AM
 * @Version 1.0
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }
}

public class NC14 {




    //实现：两个栈实现队列
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        // write code here
        //思路两个栈，一个从左到右，一个从右到左

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> ans = new ArrayList<>();

            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                ans.add(node.val);
                if(node.left!= null) stack2.push(node.left);
                if(node.right!= null) stack2.push(node.right);
            }
            list.add(ans);
            ans = new ArrayList<>();

            while(!stack2.isEmpty()){
                TreeNode node = stack2.pop();
                ans.add(node.val);
                if(node.right!= null) stack1.push(node.right);
                if(node.left!= null) stack1.push(node.left);
            }

            if(ans.size() > 0) list.add(ans);
        }
        return list;

    }


    //还是队列层次遍历，只不过加一个标志，确定是正序还是倒叙
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder1 (TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        while(!queue.isEmpty()){
            ArrayList<Integer> ans = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                node = queue.poll();
                if(flag){
                    ans.add(node.val);//正序添加
                } else{
                    ans.add(0, node.val);//头插法
                }
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right!= null){
                    queue.add(node.right);
                }
            }

            flag = !flag;
            list.add(ans);
        }
        return list;



    }

    public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.left.left =  new TreeNode(4);
       root.right.right = new TreeNode(5);
       new NC14().zigzagLevelOrder(root);

    }
}
