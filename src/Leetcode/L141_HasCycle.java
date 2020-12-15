package Leetcode;

import java.util.HashSet;

/**
 * @Description 141. 环形链表
 * @Address https://leetcode-cn.com/problems/linked-list-cycle/
 * @Author Jianhai Wang
 * @ClassName LeetCode_141
 * @Date 2020/7/21 20:16
 * @Version 1.0
 */


public class L141_HasCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return false;
        ListNode quick = head.next.next;
        ListNode slow = head.next;
        while(quick.next != null && quick.next.next != null){
            if(quick== slow)
                return true;
            quick = quick.next.next;
            slow = slow.next;
        }
        return false;

    }

    //哈希表，把所有元素添加进hash表中
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null )
            return false;
        HashSet<ListNode> hash  = new HashSet();
        ListNode p = head;
        while(p!=null){
            if(hash.contains(p))
                return true;
            hash.add(p);
            p = p.next;
        }
        return false;
    }
}
