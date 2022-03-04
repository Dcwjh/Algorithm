package LinkList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L114_Flatten
 * @Date 2021/6/29 14:58
 * @Version 1.0
 */


public class L114_Flatten {
    //中序遍历
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root == null) return;
        preorder(root);
        if(list.size() == 1)
            return;
        int size = list.size();
        TreeNode cur = root;
        for(int i = 1; i < size; i++){
            cur.right = list.get(i);
            cur.left = null;
            cur = cur.right;
        }
    }

    private void preorder(TreeNode root){
        if(root == null)
            return;
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }


    //递归
    public void flatten1(TreeNode root) {
        if(root == null)
            return;
        if(root.left != null){
            //左节点变成右节点。并保存右节点
            TreeNode right = root.right;
            root.right = root.left;
            //寻找左节点的最右子节点，然后将根结点的右子树接上。
            TreeNode temp = root.left;
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = right;
            root.left = null;
        }
        flatten(root.right);
    }


    //迭代
    public void flatten3(TreeNode root) {
        while(root != null){
            if(root.left != null){
                TreeNode temp = root.right;
                root.right = root.left;
                TreeNode cur = root.left;
                while(cur.right != null){
                    cur = cur.right;
                }
                cur.right = temp;
                root.left = null;
            }
            root = root.right;
        }
    }

}
