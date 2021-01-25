package NIUKE;

import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC40
 * @Date 1/20/2021 11:15 PM
 * @Version 1.0
 */

 class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
  }


public class NC40 {

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        //栈，头插法
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(head1!=null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while(head2!= null){
            stack2.push(head2);
            head2 = head2.next;
        }

        int carry = 0;
        ListNode head = new ListNode(0);
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int m = stack1.pop().val;
            int n = stack2.pop().val;
            if(m + n + carry > 10){
                carry = 1;
                insert(head, new ListNode((m + n+ carry)%10));
            } else{
                insert(head, new ListNode((m + n+ carry)%10));
                carry = 0;
            }

        }
        while(!stack1.isEmpty()){
            int m = stack1.pop().val;
            insert(head, new ListNode(( m+ carry)%10));
            carry = 0;
        }

        while(!stack2.isEmpty()){
            int n = stack2.pop().val;
            insert(head, new ListNode(( n + carry)%10));
            carry = 0;
        }
        if(carry == 1){
            insert(head, new ListNode(1));
        }
        return head.next;
    }

    private void insert(ListNode head, ListNode temp){
        temp.next = head.next;
        head.next = temp;
    }
}
