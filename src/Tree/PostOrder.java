package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PostOrder
 * @Date 2021/7/2 12:20
 * @Version 1.0
 */


public class PostOrder {

    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        postorderTraversal(root.left); // root --> right - left
        postorderTraversal(root.right); //left -- left.right , left.left
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        int white = 0;
        int gray = 1;
        List<Integer> res= new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(white, root));
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            if(temp.node == null){
                continue;
            }
            if(temp.color == white){
                stack.push(new Node(gray, temp.node));
                stack.push(new Node(white, temp.node.right));
                stack.push(new Node(white, temp.node.left));
            }
            else{
                res.add(temp.node.val);
            }
        }
        return res;
    }

}
