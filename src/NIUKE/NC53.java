package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC53
 * @Date 1/13/2021 4:08 PM
 * @Version 1.0
 */


public class NC53 {
    private class ListNode {
        int val;
        ListNode next = null;
    }
    //没有头节点的问题，找到要删除的节点
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        //为什么要搞一个头节点，是因为防止删除第一个节点。
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode quick = head;
        ListNode slow = dummy;
        //qucik先走n步
        for(int i = 0; i < n; i++){
            quick = quick.next;
        }
        //循环直到quick为空
        while(quick!=null){
            slow = slow.next;
            quick = quick.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2 (ListNode head, int n) {
        // write code here
        ListNode quick = head;
        ListNode slow = head;
        int index = 0;
        while(index < n){
            quick = quick.next;
            index++;
        }
        while(quick.next != null){
            quick = quick.next;
            slow = slow.next;
        }
        if(slow.next!=null)
            slow.next = slow.next.next;
        else
            head = head.next;
        return head;
    }
}
