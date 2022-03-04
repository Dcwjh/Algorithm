package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L148_SortList
 * @Date 2021/6/30 9:07
 * @Version 1.0
 */


public class L148_SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        return mergeSort(head, null);
    }


    //递归的终止条件是链表的节点个数小于或等于 1，即当链表为空或者链表只包含 1 个节点时，不需要对链表进行拆分和排序。
    private ListNode mergeSort(ListNode head, ListNode tail){
        if(head == null)
            return tail;
        if(tail == null)
            return head;
        if(head.next == tail){
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }


        ListNode head1 = mergeSort(head, slow);
        ListNode head2 = mergeSort(slow , tail);
        return merge(head1, head2);

    }
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy, temp1 = head1, temp2 = head2;
        while(temp1!= null && temp2 != null){
            if(temp1.val <= temp2.val){
                curr.next = temp1;
                temp1 = temp1.next;
            } else{
                curr.next = temp2;
                temp2 = temp2.next;
            }
            curr = curr.next;
        }
        if(temp1 != null){
            curr.next = temp1;
        } else{
            curr.next = temp2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        L148_SortList sort = new L148_SortList();
        head = sort.sortList(head);

    }
}
