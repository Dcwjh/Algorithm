package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L445_AddTwoNumbers
 * @Date 2021/7/1 12:53
 * @Version 1.0
 */


public class L445_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while(l1!=null && l2 != null){
            int a = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            curr.next = new ListNode(a);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int a = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            curr.next = new ListNode(a);
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int a = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            curr.next = new ListNode(a);
            curr = curr.next;
            l2 = l2.next;
        }
        if(carry == 1){
            curr.next = new ListNode(1);
        }
        return reverse(dummy.next);

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
}
