package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L141_HasCycle
 * @Date 2021/6/29 16:38
 * @Version 1.0
 */


public class L141_HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while(quick != null && quick.next!= null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow)
                return true;

        }
        return false;
    }
}
