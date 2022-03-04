package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L230
 * @Date 2021/7/2 22:10
 * @Version 1.0
 */


public class L230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list  = new ArrayList<>();
        Inorder(root, list);
        return list.get(k - 1);

    }

    private void Inorder(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        Inorder(root.left,list);
        list.add(root.val);
        Inorder(root.right,list);
    }


    public int kthSmallest1(TreeNode root, int k) {
        LinkedList<TreeNode> que = new LinkedList<>();
        if(root == null)
            return 0;
        while(true){
            //先进
            while(root!=null){
                que.push(root);
                root = root.left;
            }
            TreeNode node = que.pop();
            if(--k == 0) return node.val;
            root = node.right;
        }
    }
}
