package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC40两个链表生成相加链表
 * @Date 2021/7/27 22:27
 * @Version 1.0
 */


public class NC40两个链表生成相加链表 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        head1 = reverse(head1);
        head2 = reverse(head2);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;

        while(head1 != null && head2 != null){
            int val = head1.val + head2.val + carry;
            carry = val/10;
            val = val % 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        while(head1 != null){
            int val = head1.val + carry;
            carry = val/10;
            val = val %10;
            cur.next = new ListNode(val);
            cur = cur.next;
            head1 = head1.next;
        }
        while(head2 != null){
            int val =  head2.val + carry;
            carry = val/10;
            val = val %10;
            cur.next = new ListNode(val);
            cur = cur.next;
            head2 = head2.next;
        }

        if(carry == 1){
            cur.next = new ListNode(1);
        }
        dummy.next = reverse(dummy.next);
        return dummy.next;
    }

    public ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
