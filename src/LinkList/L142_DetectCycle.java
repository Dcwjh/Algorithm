package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L142_SetectCycle
 * @Date 2021/7/27 23:23
 * @Version 1.0
 */


public class L142_DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while(quick!= null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(slow == quick){
                while( head != slow){ //相遇了，fast从新开始，一步一步来
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
