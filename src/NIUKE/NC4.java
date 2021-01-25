package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC4
 * @Date 1/11/2021 9:41 PM
 * @Version 1.0
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class NC4 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null|| head.next == null) return false;
        ListNode quick = head.next;
        ListNode slow = head;
        //只要有空指针就不可能有环
        while(quick.next!= null && quick.next.next!= null){
            if(quick == slow)
                return true;
            quick = quick.next.next;
            slow = slow.next;
        }
        return false;
    }
}
