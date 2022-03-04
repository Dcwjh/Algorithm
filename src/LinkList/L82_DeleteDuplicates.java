package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L82_DeleteDuplicates
 * @Date 2021/6/28 16:57
 * @Version 1.0
 */


public class L82_DeleteDuplicates {
    //该题特点： 只要出现相同的都需要删除
    public ListNode deleteDuplicates(ListNode head) {
        //至少需要两个节点
        if(head == null || head.next == null) return head; //如果没有节点或者只有一个节点，则直接返回head

        //选择头节点是为了更好的删除第一个节点
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        //后面至少需要两个节点才可以
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val) {//后面两个节点相同，不能删除一个，两个都需要删除
                int x = cur.next.val;
                cur.next = cur.next.next.next;//两个节点都删除掉
                while(cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next; //继续删除。相同就删除
                }

            }else{//值不相同
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
