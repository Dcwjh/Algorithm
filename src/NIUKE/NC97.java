package NIUKE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC97
 * @Date 1/12/2021 11:21 PM
 * @Version 1.0
 */


public class NC97 {
    class Node{
        int num;
        String key;
        String value;
        public Node(){}
        public Node(String key, String value, int num){
            this.key = key;
            this.value = value;
            this.num = num;
        }
    }
    private Node[] nodes;

    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        Map<String, Integer> map  = new HashMap<>();
        for(String s: strings){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        nodes = new Node[map.size()];
        int i = 0;
        for(String s : map.keySet()){
            nodes[i] = new Node(s, map.get(s)+"", map.get(s));
            i++;
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.key.compareTo(o2.key); //先按字母排序，从小到大
            }
        });

        Arrays.sort(nodes, new Comparator<Node>() { //在按照数字排序，要求稳定。从大到小
            @Override
            public int compare(Node o1, Node o2) {
                return o2.num - o1.num;
            }
        });

        String[][] ans = new String[k][2];
        for(i = 0; i < k; i++){
            ans[i][0] = nodes[i].key;
            ans[i][1] = nodes[i].value;
        }
        return ans;

    }
}
