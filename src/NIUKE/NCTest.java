package NIUKE;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NCTest
 * @Date 2021/1/25 16:39
 * @Version 1.0
 */


public class NCTest {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer,Node> map;
    private Node head;
    private Node tail;


    public int[] LRU (int[][] operators, int k) {
        capacity = k;
        int size = 0;
        map = new HashMap<Integer, Node>(capacity);
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < operators.length; i++){
            if(operators[i][0] == 1){
                set(operators[i][1],operators[i][2]);
            } else{
                list.add(get(operators[i][1]));
            }
        }
        int[] ans= new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void set(int key, int value){
        //已经存在
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            update(node);
        }
        //缓存容量还够
        else if(size < capacity){
            Node node = new Node(key, value);
            map.put(key, node);
            size++;
            insert(node);
        }
        //容量不够了
        else{
            Node node = head.next;
            map.remove(node.key);   //remove key
            delete(head.next);
            node = new Node(key, value);
            map.put(key, node);
            insert(node);
        }
    }

    private int get(int key){
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        update(node);
        return node.value;
    }

    private void insert(Node node){
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }

    private void delete(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void update(Node node){
        delete(node);
        insert(node);
    }

}
