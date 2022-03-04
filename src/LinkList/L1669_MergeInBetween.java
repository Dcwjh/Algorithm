package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1669_MergeInBetween
 * @Date 2021/7/1 13:33
 * @Version 1.0
 */


public class L1669_MergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        //找到第a - 1个节点
        for(int i = 1; i < a; i++){
            cur= cur.next;
        }
        ListNode head1 = cur;
        cur = list1;
        //找到第b个节点
        for(int i = 1; i <= b; i++){
            cur= cur.next;
        }
        //指向b+1个节点
        ListNode head2 = cur.next;
        head1.next = list2;
        cur = list2;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = head2;
        return list1;
    }
}
