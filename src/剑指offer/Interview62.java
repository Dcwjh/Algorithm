package 剑指offer;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Interview62
 * @Date 2020/6/30 17:59
 * @Version 1.0
 */


public class Interview62 {
    //循环链表，时间超了
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public int lastRemaining(int n, int m) {
        if(n== 0)
            return 0;
        if(m == 1)
            return n-1;
        Node head = new Node(0);
        Node p = head;
        for(int i = 1; i < n; i++){
            p.next = new Node(i);
            p = p.next;
        }
        p.next = head;
        p = head;
        Node current = p;
        while(p.next!=p){
            for(int i = 1; i < m; i++){
                current = p;
                p = p.next;
            }
            current.next = current.next.next;
            p = current.next;
        }
        return p.val;
    }


    //方法二：

    /**
     * 假设当前删除的位置是 idx，下一个删除的数字的位置是 idx + m。
     * 但是，由于把当前位置的数字删除了，后面的数字会前移一位，
     * 所以实际的下一个位置是 idx + m - 1。由于数到末尾会从头继续数，
     * 所以最后取模一下，就是 (idx + m - 1) mod n。

     * @param args
     */

    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    //方法三：数学解法，O(n)
    public int lastRemaining3(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Interview62().lastRemaining(70866
                ,116922));
    }
}
