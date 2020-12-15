package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName DeleteDuplicates_83
 * @Date 2019/12/22 12:27
 * @Version 1.0
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class L83_DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.next.val == cur.val ){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        deleteDuplicates(head);
        while(head != null ){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
