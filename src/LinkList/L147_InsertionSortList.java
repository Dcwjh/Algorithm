package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L147_InsertionSortList
 * @Date 2021/6/29 21:13
 * @Version 1.0
 */


public class L147_InsertionSortList {
    //开一条新的链表
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0); //表头
        ListNode cur = head; //待插入元素
        while(cur !=null){
            if(dummy.next == null){
                ListNode node = cur.next;  //一定要注意当前插入的节点的后一个赋值为null,将其和后面的节点断开
                cur.next = null;
                dummy.next = cur;
                cur = node;
            } else{
                ListNode pre = dummy;
                ListNode temp = dummy.next;
                while(temp != null && temp.val < cur.val){
                    pre = temp;
                    temp = temp.next;
                }
                ListNode node = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = node;
            }
        }
        return dummy.next;

    }


    //原表进行操作
    public ListNode insertionSortList1(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE,head);
        ListNode cur = head;
        ListNode tail = dummy;
        while(cur != null){
            //最后的节点直接比较
            if(cur.val >= tail.val){
                tail = cur;
                cur = cur.next;
            }else {
                ListNode pre = dummy;
                ListNode now = dummy.next;
                while(now.val < cur.val){
                    pre = now;
                    now = now.next;
                }
                ListNode temp = cur.next;
                pre.next = cur;
                cur.next = now;
                tail.next = temp;
                cur = temp;
            }
        }
        return dummy.next;

    }
}
