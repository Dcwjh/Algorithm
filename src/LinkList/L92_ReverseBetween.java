package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L92_ReverseBetween
 * @Date 2021/6/28 17:14
 * @Version 1.0
 */


public class L92_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode curr = dummy;
        //第left - 1节点
        for(int i = 1; i < left; i++){
            curr = curr.next;
        }
        //需要反转的前一个节点
        ListNode prev = curr;
        ListNode node = prev.next; //反转后的最后一个节点
        //需要反转的个数  right - left + 1
        for(int i = 0; i < right - left + 1; i++){
            curr = curr.next;
        }
        //断链并保存下一个节点
        ListNode temp = curr.next;
        curr.next = null;
        prev.next = reverse(prev.next);
        node.next = temp;
        return dummy.next;

    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
