package LinkList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L23_MergeKLists
 * @Date 2021/6/27 22:51
 * @Version 1.0
 */


public class L23_MergeKLists {


    //优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> que = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

//        que.addAll(Arrays.asList(lists));
        for(ListNode list : lists){
            if(list!=null)
                que.add(list);
        }

        while(!que.isEmpty()){
            ListNode node = que.poll();

            cur.next = node;
            cur = cur.next;
            if(node.next != null){
                que.add(node.next);
            }
        }

        return dummy.next;
    }


    //方法二：归并排序
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists==null || lists.length == 0)
                return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right){
        if(left >= right)
            return lists[left];
        int mid = left + (right - left) /2;
        ListNode l1 = mergeSort(lists, left, mid);
        ListNode l2 = mergeSort(lists, mid + 1, right);
        return merge(l1,l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val  < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }

}
