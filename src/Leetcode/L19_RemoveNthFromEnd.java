package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L19_RemoveNthFromEnd
 * @Date 1/8/2021 10:52 AM
 * @Version 1.0
 */


public class L19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int count = 0;
        while(p!=null){
            count++;
            p = p.next;
        }
        if(count == n){
            return head.next;
        } else {
            int end = count - n;
            int start = 1;
            p = head;
            while(start < end){
                start++;
                p = p.next;
            }
            p.next = p.next.next;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new L19_RemoveNthFromEnd().removeNthFromEnd(head,2);
    }
}
