package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L237_DeleteNode
 * @Date 2021/6/30 16:49
 * @Version 1.0
 */


public class L237_DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        //可以加个判断
        // if(node.next == null)
        //     node == null;
        // else{
        //     node.val = node.next.val;
        //     node.next = node.next.next;
        // }

    }
}
