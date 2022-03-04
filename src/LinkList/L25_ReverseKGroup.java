package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L25_ReverseKGroup
 * @Date 2021/6/28 16:14
 * @Version 1.0
 */


public class L25_ReverseKGroup {

    //注意细节操作
    //   dummy-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o
    //     |   |             | |
    //    pre  node1            temp
    //第一步需要保存前一节节点pre，
    //第二保存节点头node1（防止在遍历一次寻找下一个节点头，这个就是下一段的开始节点，如果不保存反转链表后，就需要从pre从新遍历才能找到）
    //第三点需要锻炼操作，要不然都反转了，且需要保存下一个开始temp。cur.next = null;断链操作，断链之前要保存
    //反转之后的操作就是pre.next = 反转，node1.next = temp;  cur = node1;
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1)
            return head;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int length = 0;
        while(cur.next != null){
            cur = cur.next;
            length++;
        }
        int n = length / k;
        cur = dummy;
        for(int i = 0; i < n; i++){
            ListNode pre = cur;
            ListNode node1 = pre.next;
            //从下一个节点开始计数
            for(int j = 0; j < k; j++){
                cur = cur.next;
            }
            ListNode temp = cur.next;
            cur.next = null;
            pre.next = reverse(pre.next);
            node1.next = temp;
            cur = node1;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
