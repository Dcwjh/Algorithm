package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L199
 * @Date 2021/7/2 21:51
 * @Version 1.0
 */


public class L199 {
    //层次遍历的第一个， 添加顺序右左
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> que = new ArrayDeque<>();
        if(root == null)
            return list;
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = que.poll();
                if(i == 0){
                    list.add(temp.val);
                }
                if(temp.right != null) que.add(temp.right);
                if(temp.left != null) que.add(temp.left);
            }
        }
        return list;
    }
}
