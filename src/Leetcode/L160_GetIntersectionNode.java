package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L160_GetIntersectionNode
 * @Date 12/15/2020 11:11 AM
 * @Version 1.0
 */


public class L160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //统计第一个链表长度
        int ca = 0;
        ListNode p = headA;
        while (p != null) {
            ca++;
            p = p.next;
        }
        int cb = 0;
        p = headB;
        while (p != null) {
            cb++;
            p = p.next;
        }
        if (ca > cb) {
            p = headA;
            while (ca - cb > 0) {
                p = p.next;
                cb++;
            }
            ListNode p2 = headB;
            while (p != null) {
                if (p == p2) {
                    return p;
                }
                p = p.next;
                p2 = p2.next;
            }
        } else {
            p = headB;
            while (cb - ca > 0) {
                p = p.next;
                ca++;
            }
            ListNode p2 = headA;
            while (p != null) {
                if (p == p2) {
                    return p;
                }
                p = p.next;
                p2 = p2.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
