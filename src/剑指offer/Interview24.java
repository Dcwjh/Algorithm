package 剑指offer;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Interview24
 * @Date 1/11/2021 7:27 PM
 * @Version 1.0
 */


public class Interview24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
       //真菜这都不会写
        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }
}
