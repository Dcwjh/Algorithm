package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName LRU_niuke
 * @Date 1/11/2021 9:22 PM
 * @Version 1.0
 */


public class LRU_niuke {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */

    //set操作复杂度为O(1), 即插入，删除为1， 链表操作
    //get操作复杂度为O(1),数组或者hash
    class Node{
        private int key;
        private int value;
        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        private Node pre;
        private Node next;
    }

    private int size;
    private int capacity;
    private Map<Integer, Node> map;
    private  Node head;
    private Node tail;

    public int[] LRU (int[][] operators, int k) {
        this.size = 0;
        this.capacity = k;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(k);
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < operators.length; i ++){
            if(operators[i][0] == 1){
                set(operators[i][1],operators[i][2]);
            }else{
                list.add(get(operators[i][1]));
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
            System.out.println(ans[i]);
        }
        return ans;
    }

    public void set(int key, int value){
        //如果键值已存在，更新
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            update(node);
        }
        //如果键值不存在，且容量够
        else if(size < capacity){
            Node node = new Node(key,value);
            map.put(key,node);
            insert(node);
            size++;
        }
        //容量不够，删除第一个，并将新的插入到最后
        else {
            Node node = head.next;
            map.remove(node.key);
            delete(head.next);
            node = new Node(key, value);
            map.put(key, node);
            insert(node);
        }
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        if(node.next!= tail){
            update(map.get(key));
        }
        return map.get(key).value;
    }

    //插入一般是最新的，放在尾节点
    private void insert(Node node){
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }

    //删除当前节点
    private void delete(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void update(Node node){
        //先删除
        delete(node);
        //再插入
        insert(node);
    }

    public static void main(String[] args) {
        new LRU_niuke().LRU(new int[][]{{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}},3);
    }

}
