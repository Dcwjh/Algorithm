package 美团;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Main
 * @Date 2021/9/25 16:53
 * @Version 1.0
 */


public class Main {

    static class UnionFind {
        int root[];

        public UnionFind(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                root[rootY] = rootX;
            }
        };

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            UnionFind map = new UnionFind(n + 1);
            for(int j = 0; j < m; j++){
                int a = in.nextInt();
                int b = in.nextInt();
                map.union(a,b);
            }
            int parent = -1;
            for(int j = 0; j < k; ){
                int x = in.nextInt();
                if(parent == -1){
                    parent = map.find(x);
                } else {
                    if(parent != map.find(x)){
                        System.out.println("No");
                        break;
                    }
                }
                j++;
                if(j == k){
                    System.out.println("YES");
                }
            }

        }
    }
}
/*
2
4 2 3
1 2
2 3
1 2 3
4 2 3
1 2
2 3
1 2 4

 */