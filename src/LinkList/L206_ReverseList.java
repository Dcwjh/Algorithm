package LinkList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L206_ReverseList
 * @Date 2021/6/27 16:20
 * @Version 1.0
 */


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class L206_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    //如果是前序遍历，我们的代码是这样的：
    public ListNode reverseList2(ListNode head) {
        return dfs(head, null);
    }

    private ListNode dfs(ListNode head, ListNode pre){
        if(head == null)
            return pre;
        ListNode next = head.next;
        head.next = pre;
        return dfs(next, head);

    }


    /**
     * 如果是前序遍历，那么你可以想象前面的链表都处理好了，怎么处理的不用管。
     * 相应地如果是后序遍历，那么你可以想象后面的链表都处理好了，怎么处理的不用管。
     * @param head
     * @return
     */

    //后续遍历的代码是这样的：
    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null)
            return head;
        // 不需要留联系方式了，因为我们后面已经走过了，不需走了，现在我们要回去了。
        ListNode res = reverseList3(head.next);
        head.next.next = head;
        //赋值是为了防止有环
        head.next = null;
        return res;

    }


    //画出图之后，是不是很容易看出图中有一个环？ 现在知道画图的好处了吧？就是这么直观，当你很熟练了，就不需要画了，但是在此之前，请不要偷懒。
    //因此我们需要将 head.next 改为不会造成环的一个值，比如置空。
}
