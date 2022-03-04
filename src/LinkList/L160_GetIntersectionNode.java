package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L160_GetIntersectionNode
 * @Date 2021/6/30 9:41
 * @Version 1.0
 */


public class L160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //统计第一个链表长度
        int ca = 0;
        ListNode p = headA;
        while(p != null){
            ca++;
            p = p.next;
        }
        int cb = 0;
        p = headB;
        while (p != null) {
            cb++;
            p = p.next;
        }
        if(ca < cb){
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        int n = Math.abs(ca - cb);
        while(n > 0){  //减操作和移动同步进行
            headA = headA.next;
            n--;
        }
        while(headA != null){
            if(headA == headB)
                return headB;
            headB = headB.next;
            headA = headA.next;
        }

        return null;
    }
}
