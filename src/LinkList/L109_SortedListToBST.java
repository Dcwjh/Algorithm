package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L109_SortedListToBST
 * @Date 2021/6/29 14:42
 * @Version 1.0
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class L109_SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        //找到中间节点
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }
}
