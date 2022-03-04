package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L143_ReorderList
 * @Date 2021/6/29 17:03
 * @Version 1.0
 */


public class L143_ReorderList {
    public void reorderList(ListNode head) {
        //找到中点，分成两个链，后面链反转后在将两个链合并
        if(head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode quick = head.next;
        while(quick != null && quick.next!=null){
            slow = slow.next;
            quick = quick.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        merge(head, head2);
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(head1!=null && head2 != null){
            curr.next = head1;
            ListNode temp = head1.next;
            curr = curr.next;
            curr.next = head2;
            head1 = temp;
            head2 = head2.next;
            curr = curr.next;
        }
        if(head1!=null){
            curr.next = head1;
        }
        return head.next;
    }
}
