package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L86_Partition
 * @Date 2021/6/28 17:09
 * @Version 1.0
 */


public class L86_Partition {
    public ListNode partition(ListNode head, int x) {
        //两个链表
        ListNode head1 = new ListNode(0);
        ListNode h1 = head1;
        ListNode head2 = new ListNode(0);
        ListNode h2 = head2;
        ListNode cur = head;
        while(cur!= null){
            if(cur.val < x){
                h1.next = cur;
                h1 = h1.next;
            } else{
                h2.next = cur;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        h1.next = head2.next;
        h2.next = null;
        return head1.next;
    }
}
