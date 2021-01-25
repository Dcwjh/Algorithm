package Leetcode;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L202
 * @Date 1/11/2021 9:03 AM
 * @Version 1.0
 */


public class L1202_SmallestStringWithSwaps {

    //有瑕疵，使用并查集吧
    public String smallestStringWithSwaps_temp(String s, List<List<Integer>> pairs) {
        for(int i = 0; i < pairs.size(); i++){
            if(pairs.get(i).get(0) == pairs.get(i).get(1))
                pairs.remove(pairs.get(i));
        }
        int[][] pair = new int[pairs.size()][2];
        for(int i = 0; i < pair.length; i++){
            if(pairs.get(i).get(0) < pairs.get(i).get(1)) {
                pair[i][0] = pairs.get(i).get(0);
                pair[i][1] = pairs.get(i).get(1);
            } else if(pairs.get(i).get(0) > pairs.get(i).get(1)){
                pair[i][0] = pairs.get(i).get(1);
                pair[i][1] = pairs.get(i).get(0);
            }
        }
        Arrays.sort(pair, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p2[1] - p1[1];
            }
        });
        Arrays.sort(pair, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0];
            }
        });

        for(int i = 0; i < pair.length; i ++){
            System.out.println(pair[i][0] + " " + pair[i][1]);
        }
        char[] str = s.toCharArray();
        int index = 0;
        boolean flag = true;
        while(index < s.length() && flag) {
            flag = false;
            for (int i = 0; i < pair.length; i++) {
                if (str[pair[i][0]] > str[pair[i][1]]) {
                    char temp = str[pair[i][0]];
                    str[pair[i][0]] = str[pair[i][1]];
                    str[pair[i][1]] = temp;
                    flag = true;
                }
            }
            index ++;
        }
        return String.valueOf(str);
    }


    /**
     *
     * 并查集:
     *
     * 思想：在同一个并查集中的字符用同一个并查集表示，然后
     * @param s
     * @param pairs
     * @return
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() == 0)
            return s;
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for(List<Integer> pair: pairs){
            int p1 = pair.get(0);
            int p2 = pair.get(1);
            unionFind.union(p1, p2);
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>(len);
        for(int i = 0; i < len; i++){
            int temp = unionFind.find(i);
            if(!map.containsKey(temp)){
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(s.charAt(i));
                map.put(temp, minHeap);
            } else{
                map.get(temp).offer(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            int root = unionFind.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }

    class UnionFind{
        private int[] parents;
        public UnionFind(int size){
            parents = new int[size];
            for(int i = 0; i < size; i++){
                parents[i] = i;
            }
        }

        public int find(int num){
            if(num != parents[num]){
                parents[num] = find(parents[num]);
            }
            return parents[num];
        }

        public void union(int x, int y){
            if(find(x) != find(y)){
                parents[find(y)] = find(x);
            }

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(3);
        list.add(l);
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        list.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(2);
        list.add(l2);
    }
}
