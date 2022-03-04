package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L19_RemoveNthFromEnd
 * @Date 2021/6/27 16:49
 * @Version 1.0
 */


public class L19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //因为删除第一个是特殊情况，这样就需要建立一个头节点，可以防止特殊情况
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
