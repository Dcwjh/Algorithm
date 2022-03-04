import java.util.HashMap;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName LRU
 * @Date 2021/9/2 22:22
 * @Version 1.0
 */


public class LRU {


    class Node {
        int value;
        Node pre;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private int size; //链表node个数
    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            update(temp);
            return temp.value;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        //先判断改key是否在hashmap中
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            update(temp);
        } else if (size < capacity) {
            //容量够
            Node temp = new Node(value);
            map.put(key, temp);
            insert(temp);
            size++;
        } else {
            delete(tail.pre);
            map.remove(tail.pre.value);
            Node temp = new Node(value);
            map.put(key, temp);
            insert(temp);
        }
    }

    private void update(Node node) {
        delete(node);
        insert(node);
    }

    private void delete(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void insert(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public static void main(String[] args) {

    }

}

