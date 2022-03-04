package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L2_AddTwoNumbers
 * @Date 2021/6/27 16:41
 * @Version 1.0
 */


public class L2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        // ListNode cur = head.next;  ////错就错在它是一个指针，他需要指向一个对象。 这里为啥什么不能指向head.next呢？
        // 因为这里的head.next是null, 也就是说这里的cur没有指向任何东西。但是初始化他需要指向一个对象。
        ListNode cur = head;
        int carry = 0;
        while(l1!= null && l2!= null){
            int val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
        }

        while(l2!=null){
            int val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l2 = l2.next;
        }

        if(carry != 0){
            cur.next = new ListNode(1);
        }

        return head.next;

    }
}
