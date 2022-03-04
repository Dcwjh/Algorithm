package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L37序列化二叉树
 * @Date 2021/8/9 13:40
 * @Version 1.0
 */


public class L37序列化二叉树 {


    //DFS
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        String res = rserialize(root, sb).toString();
        System.out.println(res);
        return res;
    }

    public StringBuilder rserialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
        } else{
            sb.append(root.val + ",");
            rserialize(root.left, sb);
            rserialize(root.right, sb);
        }
        return sb;
    }


    // Decodes your encoded data to tree.
    int i = 0;  //这个i一定要是全局变量，如果是参数可能就在
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        String[] str =  data.split(",");
        return rdeserialize(str);
    }

    public TreeNode rdeserialize(String[] str){
        if(str[i].equals("null")){
            i++; //如果局部变量，这里++传不出去。可以使用链表，链表可以传出去
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str[i]));
        i++;
        root.left = rdeserialize(str);
        root.right = rdeserialize(str);
        return root;
    }


    //BFS
    public String serialize2(TreeNode root) {
        if(root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        String res = "";
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp != null) {
                    res += temp.val + ",";
                    queue.add(temp.left);
                    queue.add(temp.right);
                } else{
                    res += "null,";
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public TreeNode deserialize2(String data) {
        if(data.equals(""))
            return null;
        String[] str = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(str[i++]));
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(deque.isEmpty()){
            int size = deque.size();
            for(int j = 0; j < size; j++){
                TreeNode temp = deque.poll();
                if(str[i].equals("null")){
                    temp.left = null;
                    i++;
                } else{
                    temp.left = new TreeNode(Integer.parseInt(str[i++]));
                    deque.add(temp.left);
                }

                if(str[i].equals("null")){
                    temp.right = null;
                    i++;
                } else{
                    temp.right = new TreeNode(Integer.parseInt(str[i++]));
                    deque.add(temp.right);
                }
            }
        }
        return root;
    }

}
