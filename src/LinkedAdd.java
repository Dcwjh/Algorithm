/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName LinkedAdd
 * @Date 2021/7/27 20:23
 * @Version 1.0
 */

class Node{
    int val;
    Node next ;
    public Node(){}
    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node node){
        this.val = val;
        this.next = node;
    }

}


public class LinkedAdd {

    public Node reverse(Node node){
        Node pre = null;
        Node cur = node;
        while(cur != null){
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public Node add(Node node1, Node node2){
        node1 = reverse(node1);
        node2 = reverse(node2);
        int carry = 0;
        Node dummy = new Node();
        Node cur = dummy;
        Node cur1 = node1;
        Node cur2 = node2;
        while(cur1!= null && cur2 != null){
            int val = cur1.val + cur2.val + carry;
            carry = val / 10;
            val = val % 10;
            cur.next = new Node(val);
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while(cur1!= null){
            int val = cur1.val  + carry;
            carry = val / 10;
            val = val % 10;
            cur.next = new Node(val);
            cur = cur.next;
            cur1 = cur1.next;
        }

        while(cur2!= null){
            int val = cur2.val  + carry;
            carry = val / 10;
            val = val % 10;
            cur.next = new Node(val);
            cur = cur.next;
            cur2 = cur.next;
        }
        if(carry == 1){
            cur.next = new Node(1);
            cur = cur.next;
        }
        dummy  = reverse(dummy.next);
        return dummy.next;
    }
}
