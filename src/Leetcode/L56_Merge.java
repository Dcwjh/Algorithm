package Leetcode;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName merge_56
 * @Date 2019/11/14 0:10
 * @Version 1.0
 */


public class L56_Merge {

    class Node{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge2(int[][] intervals) {
        List<int []> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        //如果我们按照区间的左端点排序，那么在排完序的列表中，可以合并的区间一定是连续的。
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        for(int i = intervals.length - 1; i >= 0; i--){
            stack.add(new Node(intervals[i][0],intervals[i][1]));
        }

        while(stack.size() > 1){
            Node node1 = stack.pop();
            Node node2 = stack.pop();
            if(node1.end < node2.start){
                int[] temp = new int[2];
                temp[0] = node1.start;
                temp[1] = node1.end;
                res.add(temp);
                stack.push(node2);
            } else if(node1.end <= node2.end){
                Node node = new Node(node1.start, node2.end);
                stack.push(node);
            } else if(node1.end > node2.end){
                stack.push(node1);
            }
        }
        if(!stack.isEmpty()){
            Node node = stack.pop();
            int[] temp = new int[2];
            temp[0] = node.start;
            temp[1] = node.end;
            res.add(temp);
        }
        return res.toArray(new int[res.size()][2]);
    }


}
