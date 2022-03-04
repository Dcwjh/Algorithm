package JD;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln2
 * @Date 2021/9/11 19:44
 * @Version 1.0
 */


public class ln2 {
    static class Node {
        int key;
        List<Integer> parent = new LinkedList<>();
        List<Integer> children = new LinkedList<>();
        public Node(int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i < n + 1; i++) {
            int num = in.nextInt();
            for (int j = 1; j < num + 1; j++) {
                int temp = in.nextInt();
                nodes[i].parent.add(temp);
                nodes[temp].children.add(i);
            }
        }
        for(int i = 1; i < n + 1; i++) {
            Queue<Node> que = new ArrayDeque<>();
            for (Integer integer : nodes[i].parent) {
                que.add(nodes[integer]);
            }
            while (!que.isEmpty()) {
                Node t = que.poll();
                for (Integer integer : t.parent) {
                    nodes[i].parent.add(integer);
                    que.add(nodes[integer]);
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {
            Queue<Node> que = new ArrayDeque<>();
            for (Integer integer : nodes[i].children) {
                que.add(nodes[integer]);
            }
            while (!que.isEmpty()) {
                Node t = que.poll();
                for (Integer integer : t.children) {
                    nodes[i].children.add(integer);
                    que.add(nodes[integer]);
                }
            }
        }


        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < q; i++) {

            int command = in.nextInt();
            int service = in.nextInt();
            if (command == 1) {
                set.add(service);
                List<Integer> p = nodes[service].parent;
                set.addAll(p);
            }
            if (command == 0) {
                set.remove(service);
                List<Integer> p = nodes[service].children;
                set.removeAll(p);
            }
            System.out.println(set.size());
        }

    }
}
/*
3 2
1 2
1 3
0
1 1
0 2
 */