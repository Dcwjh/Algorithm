package NIUKE;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC70
 * @Date 2021/1/21 22:54
 * @Version 1.0
 */


public class NC70 {
    public ListNode sortInList (ListNode head) {
        // write code here
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });
        ListNode cur = head;
        while(cur != null){
            queue.add(cur);
            cur = cur.next;
        }
        ListNode newHead = new ListNode(0);
        cur = newHead;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
        }
        return newHead.next;


    }
}
