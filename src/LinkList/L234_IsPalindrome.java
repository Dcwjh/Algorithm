package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L234_IsPalindrome
 * @Date 2021/6/30 16:32
 * @Version 1.0
 */


public class L234_IsPalindrome {
    //找到中点，反转链表进行比较
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) //只有一个节点或者没有节点
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head1= head;
        ListNode head2 = slow;
        if(fast !=null){ //判断奇偶 ,如果是奇数，则第二个链表想后一步
            head2 = slow.next;
        }
        head2 = reverse(head2);
        return compare(head1, head2);

    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private boolean compare(ListNode head1, ListNode head2){
        if(head1 == null&&head2 ==null)
            return true;
        if(head1 == null || head2 == null)
            return false;
        while(head1 != null && head2 != null){
            if(head1.val != head2.val){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}
