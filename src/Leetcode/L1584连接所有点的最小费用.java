package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1584连接所有点的最小费用
 * @Date 2021/9/7 16:11
 * @Version 1.0
 */


public class L1584连接所有点的最小费用 {
    class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int distance(Node node){
            return Math.abs(node.x - this.x) + Math.abs(node.y - this.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        Node[] nodes = new Node[points.length];
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            nodes[i] = new Node(points[i][0], points[i][1]);
            list.add(nodes[i]);
        }
        int max = 0;
        Node start = list.get(0);
        List<Node> cur = new ArrayList<>();
        cur.add(start);
        Node next = null;
        int cost = 0;
        int size = cur.size();
        while(size < points.length){
            for(Node node : list){
                if(cur.contains(node)){
                    continue;
                }
                if(next == null){
                    next = node;
                    cost = start.distance(node);
                    cur.add(node);
                } else{
//                    for(Node c : cur){
//                        if(node.distance(c) < cost){
//
//                        }
//                    }
                }
            }
        }
        return 0;

    }
}
