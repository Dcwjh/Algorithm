package LinkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L138_CopyRandomList
 * @Date 2021/6/29 16:34
 * @Version 1.0
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

//映射加递归
public class L138_CopyRandomList {
    //映射真实和虚拟的映射出来
    Map<Node, Node> map = new HashMap<>();
    public Node  copyRandomList(Node head) {
        //既然是递归，那就需要终止条件
        if(head == null)
            return null;
        if(map.containsKey(head))
            return map.get(head);

        Node root = new Node(head.val);
        //创建出来就需要放进去，要不然就超出内存限制了
        map.put(head,root);
        root.random = copyRandomList(head.random);
        root.next = copyRandomList(head.next);
        map.put(head,root);
        return root;
    }
}
