package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L203_RemoveElements
 * @Date 2021/6/30 9:48
 * @Version 1.0
 */


public class L203_RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0,head);
        ListNode curr = dummy.next;
        ListNode pre = dummy;
        while(curr != null ){
            if(curr.val == val){
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
