package 剑指offer;

/**
 * @Description  删除链表的节点
 * @Address https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @Author Jianhai Wang
 * @ClassName Interview18
 * @Date 2020/7/4 11:13
 * @Version 1.0
 */


public class Interview18 {
    //原题是给了要删除的节点位置，要求用O(1)的方法解决。
    //解法：把要删除的节点的下一个值复制到该该节点，删除下一个节点
    class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return null;
        ListNode p = head;

        if(p.val == val){
            p.val = p.next.val;
            p.next = p.next.next;
            return head;
        }
        ListNode current = p.next;
        while(current!= null && current.val!= val){
            p = current;
            current = p.next;
        }
        p.next = current.next;

        return head;
    }
}
