package NIUKE;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC3
 * @Date 1/15/2021 3:23 PM
 * @Version 1.0
 */


public class NC3 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }


    //使用额外空间
    public ListNode detectCycle1(ListNode head) {
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode l = head;
        while (l != null) {
            if (arr.contains(l)) {
                return l;
            } else {
                arr.add(l);
            }
            l = l.next;
        }
        return null;
    }


    //画个图，距离为a,b,c.    快指针，2倍速。
    // a + b + n(b + c) 快指针走的距离
    // a + b 慢指针的距离
    //2（a + b） =  a + b + n(b + c) ===> a = (n - 1) b + n c ===> a= (n - 1)(b + c) + c
    //此刻在找一个链表从head开始，然后同步慢节点的速度。慢节点需要n - 1圈且多走一个c，最终相遇了
    public ListNode detectCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while(quick!= null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(slow == quick){
                //头节点开始走
                ListNode temp = head;
                //慢节点在走N圈，且少走一个b
                while(temp != slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                //等于就找到了入口节点，返回
                return slow;
            }
        }
        return null;

    }
}
