package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC33
 * @Date 1/13/2021 2:42 PM
 * @Version 1.0
 */


public class NC33 {


    private class ListNode {
       int val;
       ListNode next = null;
    }

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        //将l2加在l1上
        ListNode p1 = l1;
        ListNode p2 = l2;
        //找到头
        ListNode head = (l1.val>l2.val)? l2:l1;
        while(p1 != null && p2!= null){
            //l1大l2小, 在l2中找到第一个比l1大的数
            if(p1.val > p2.val){    //和上方一样确定头节点
                while(p2.next!= null && p1.val > p2.next.val) p2 = p2.next;
                ListNode node = p2.next;
                p2.next = p1;
                p2 = node;
            }
            //l1小l2大，在l1中找到第一个不比l2小的数
            else{
                while(p1.next!=null && p1.next.val <= p2.val) p1 = p1.next;
                ListNode node = p1.next;
                p1.next = p2;
                p1 = node;
            }
        }
        return head;

    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeNode = null;
        if (l1.val < l2.val) {
            mergeNode = l1;
            mergeNode.next = mergeTwoLists1(l1.next, l2);
        } else {
            mergeNode = l2;
            mergeNode.next = mergeTwoLists1(l1, l2.next);
        }
        return mergeNode;
    }
}
