package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L61
 * @Date 2021/6/28 16:42
 * @Version 1.0
 */


public class L61_RotateRight {
    //双指针
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode quick = head;
        int length = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            length ++;
        }
        k = k % length;
        if(k == 0) return head;
        for(int i = 0; i < k; i++){
            quick = quick.next;
        }
        while(quick.next != null){
            quick = quick.next;
            slow = slow.next;
        }
        curr = slow.next;
        quick.next = head;
        slow.next = null;
        return curr;
    }


    //直接找到需要旋转的节点进行操作
    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null) return head;
        int length = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(cur.next != null){
            length++;
            cur = cur.next;
        }
        System.out.print(length);

        cur = dummy;
        k = k % length;
        if(k == 0) return head;
        int m = length - k;
        for(int i = 0; i < m; i++){
            cur = cur.next;
        }
        ListNode temp = cur.next;
        cur.next = null;
        dummy.next = temp;
        cur = temp;
        while(cur.next!= null){
            cur = cur.next;
        }
        cur.next = head;

        return dummy.next;

    }
}
