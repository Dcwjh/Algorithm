package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L103_ZigzagLevelOrder
 * @Date 12/22/2020 2:02 PM
 * @Version 1.0
 */


public class L103_ZigzagLevelOrder {
    //使用栈
    public static  List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list= new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> l = new ArrayList<>();
            while(!stack1.isEmpty()){
                l.add(stack1.peek().val);
                if(stack1.peek().left!=null){
                    stack2.push(stack1.peek().left);
                }
                if(stack1.peek().right!=null){
                    stack2.push(stack1.peek().right);
                }
                stack1.pop();
            }

            if(l.size()!=0)list.add(l);
            List<Integer> l2 = new ArrayList<>();
            while(!stack2.isEmpty()){

                l2.add(stack2.peek().val);
                if(stack2.peek().right!=null){
                    stack1.push(stack2.peek().right);
                }
                if(stack2.peek().left!=null){
                    stack1.push(stack2.peek().left);
                }
                stack2.pop();
            }
            if(l2.size()!=0)list.add(l2);
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        zigzagLevelOrder(root);
    }
}
