package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L24_SwapPairs
 * @Date 2021/6/28 15:34
 * @Version 1.0
 */


public class L24_SwapPairs {
    //三个指针
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null){
            ListNode node1 = cur.next;
            ListNode node2 = node1.next;
            ListNode temp = node2.next;
            cur.next = node2;
            node2.next = node1;
            node1.next = temp;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
