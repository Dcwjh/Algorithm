package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Interview55
 * @Date 2020/6/28 13:55
 * @Version 1.0
 */





public class Interview55 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //递归
    public int maxDepth1(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth1(root.left),maxDepth1(root.right)) + 1;
    }

    //非递归,    层次遍历，每一层获取当前层的数目，遍历完一层，depth加一
    public int maxDepth2(TreeNode root) {
        if(root == null)
            return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int size = list.size();
        int depth = 0;
        while(!list.isEmpty()){
            while(size > 0){
                TreeNode temp = list.pop();
                if(temp.left!=null)
                    list.add(temp.left);
                if(temp.right!=null)
                    list.add(temp.right);
                size--;
            }
            depth++;
            size = list.size();
        }
        return depth;
    }

}
