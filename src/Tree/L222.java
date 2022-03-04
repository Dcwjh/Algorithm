package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L222
 * @Date 2021/7/2 22:04
 * @Version 1.0
 */


public class L222 {
    public int countNodes(TreeNode root) {
        //用栈
        if(root == null) return 0;
        Queue<TreeNode> que = new ArrayDeque<>();
        int count = 0;
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            count += size;
            for(int i = 0; i < size; i++){
                TreeNode node = que.poll();
                if(node.left!= null)
                    que.add(node.left);
                if(node.right!= null)
                    que.add(node.right);
            }
        }
        return count;
    }
}
