package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L547省份数量
 * @Date 2021/9/6 20:56
 * @Version 1.0
 */


public class L547省份数量 {

    class FindUnion{
        int[] root;
        int[] rank;
        int count;
        public FindUnion(int size){
            root = new int[size];
            rank = new int[size];
            count = size;
            for(int i = 0; i < size; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(x == root[x])
                return x;
            return root[x] = find(root[x]);
        }

        public void union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx != rooty){
                if(rank[rootx] > rank[rooty]) {
                    root[rooty] = rootx;
                } else if(rank[rootx] < rank[rooty]){
                    root[rootx] = rooty;
                } else{
                    root[rooty] = rootx;
                    rank[rootx] ++;
                }
                count --;
            }
        }

        public boolean connected(int x, int y){
            return find(x) == find(y);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        //连通是相互的，所以矩阵一般是对称的
        FindUnion union = new FindUnion(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    union.union(i,j);
                }
            }
        }
        return union.count;
    }
}
