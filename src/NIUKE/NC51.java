package NIUKE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC51
 * @Date 2021/1/21 16:25
 * @Version 1.0
 */


public class NC51 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        //合并K个已排序链表，使用优先队列
        if(lists == null || lists.size() == 0) return null;
        ListNode head = new ListNode(0);
        ListNode temp = head;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node: lists){
            if(node != null)   //很重要
            queue.add(node);
        }
        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            ListNode node = new ListNode(n.val);
            temp.next = node;
            temp = temp.next;
           if(n.next !=null){
               queue.add(n.next);
           }
        }
        return head.next;
    }

}
