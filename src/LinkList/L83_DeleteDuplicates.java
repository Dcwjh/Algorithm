package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L83_DeleteDuplicates
 * @Date 2021/6/28 16:59
 * @Version 1.0
 */


public class L83_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        //只需要考虑后一个和当前是不是一样即可，有重复的删除后一个即可，所以不需要头节点
        while(curr.next != null){
            if(curr.next.val == curr.val){
                curr.next = curr.next.next;
            } else{
                curr = curr.next;
            }
        }
        return head;
    }
}
