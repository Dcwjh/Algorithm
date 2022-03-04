package LinkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L146_LRUCache
 * @Date 2021/7/27 23:27
 * @Version 1.0
 */


public class L146_LRUCache {

    //为什么使用链表，是因为，插入和删除的复杂度是O(1).但是查找速度慢，这时候使用hashMap可以瞬间找到
    class LinkedNode{
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;
        public LinkedNode(){}
        public LinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private LinkedNode head;
    private LinkedNode tail;
    private Map<Integer, LinkedNode> map;

    public L146_LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new LinkedNode();
        this.tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        LinkedNode temp = map.get(key);
        //不在尾部
        if(temp.next!=tail){
            update(temp);
        }
        return map.get(key).value;
    }

    public void put(int key, int value) {
        //如果键值已存在，则更新
        if(map.containsKey(key)){
            LinkedNode node = map.get(key);
            node.value = value;
            update(node);
        }

        //如果容量还够，插入尾部
        else  if(size < capacity){
            LinkedNode node = new LinkedNode(key, value);
            //插入
            insert(node);
            size++;
            map.put(key, node);
        } else{
            //容量不够，删除头节点第一个。且插入容量不变
            LinkedNode temp = head.next;
            delete(temp);
            map.remove(temp.key);
            //插入一个新的，
            temp = new LinkedNode(key, value);
            map.put(key, temp);
            insert(temp);
        }

    }

    private void delete(LinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void update(LinkedNode node){
        delete(node);
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre  = node;
    }

    private void insert(LinkedNode node){
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre  = node;
    }
}
