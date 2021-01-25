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

    public ListNode removeNthFromEnd2 (ListNode head, int n) {
        //第一种方法，先统计总个数，然后减去n，就得出要走的个数
        //第二种办法加上一个头节点，想让一个节点走n步，然后两个指针同步

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode quick = head;
        ListNode slow = dummy;
        //快节点先走n步
        for(int i = 0; i < n; i++){
            quick = quick.next;
        }

        while(quick!=null){
            slow = slow.next;
            quick = quick.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
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
