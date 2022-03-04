package Tree;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Node
 * @Date 2021/7/2 12:19
 * @Version 1.0
 */


public class Node {
    int color; //0 , 1
    TreeNode node;

    Node(int color, TreeNode node) {
        this.color = color;
        this.node = node;
    }
}
