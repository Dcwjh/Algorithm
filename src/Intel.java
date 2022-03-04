/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Intel
 * @Date 2021/9/2 17:43
 * @Version 1.0
 */




public class Intel {

    private static Node fun(Node head, int start, int end, int val){
        Node dummy = new Node(0,head);
        Node cur = dummy;
        Node s = cur;
        Node e = cur;
        Node temp = cur;
        for(int i = 0; i < start - 1; i++){
            cur = cur.next;
        }
        s = cur;
        cur = dummy;
        for(int i = 0; i < end; i++){
            cur = cur.next;
        }
        e = cur;
        temp = cur.next;
        cur.next = null;
        cur = s;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        s.next = reverse(s.next);
        cur = s;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = temp;
        return dummy.next;

    }


    private static Node reverse(Node p){
        Node pre = null;
        Node cur = p;
        while(cur != null){
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        Node res = fun(head,3,6,2);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
