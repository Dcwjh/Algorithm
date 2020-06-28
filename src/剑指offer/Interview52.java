package 剑指offer;


import java.util.Stack;

/**
 * @Description 两个链表的公共节点
 * @Address
 * @Author Jianhai Wang
 * @ClassName Interview52
 * @Date 2020/6/27 11:07
 * @Version 1.0
 */
class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class Interview52 {
    //方法一：暴力法，逐一比较 O(m+n)
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        while(p1!=null){
            ListNode p2 = pHead2;
            while (p2!= null){
                if(p2.val == p1.val){
                    return p1;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return null;
    }

    //方法二： 借助栈， 减少时间复杂度
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=null){
            s1.push(p1);
            p1 = p1.next;
        }
        while(p2!=null){
            s2.push(p2);
            p2 = p2.next;
        }
        ListNode com = null;
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.peek().val == s2.peek().val){
                com = s1.pop();
                s2.pop();
            } else{
                return com;
            }
        }
        return com;
    }

    //方法三：通过指针，减少空间复杂度
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1!=null){
            lenA++;
            p1 = p1.next;
        }
        while(p2 != null){
            lenB++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        if(lenA > lenB){
            int len = lenA - lenB;

            for(int i = 0; i < len; i++){
                p1 = p1.next;
            }
        } else{
            int len = lenB - lenA;

            for(int i = 0; i < len; i++){
                p2 = p2.next;
            }
        }
        while(p1!=null && p2!=null){
            if(p1==p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    //简化版，   一共走有L1 + L2 + C步.   若等长，则一次性就判断出来了，None==None，推出循环
    //若不等长，则循环差几步，最后循环几轮，总能有一次是同步的。（取决于链表长度和链表长度差）
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }
}
