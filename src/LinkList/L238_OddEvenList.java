package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L238_OddEvenList
 * @Date 2021/6/30 16:50
 * @Version 1.0
 */


public class L238_OddEvenList {
    //两个链表搞定
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode dummyOdd = odd;
        ListNode even = new ListNode(0);
        ListNode dummyEven = even;
        int num = 1;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            if(num % 2 == 1){
                odd.next = cur;
                odd = odd.next;
            } else {
                even.next = cur;
                even = even.next;
            }
            num++;
            cur.next = null;
            cur = next;
        }
        odd.next = dummyEven.next;
        return dummyOdd.next;
    }
}
