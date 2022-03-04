package 华为;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName In2
 * @Date 2021/9/8 20:18
 * @Version 1.0
 */


public class In2 {
    static class Node{
        int row;
        int col;
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static int distance(Node node1, Node node2){
        return Math.abs(node2.row - node1.row) + Math.abs(node2.col - node1.col);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String[] line1s = line1.split(",");
        String[] line2s = line2.split(" ");
        int m = Integer.parseInt(line1s[0]);
        int n = Integer.parseInt(line1s[1]);
        int[][] nums = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                nums[i][j] = Integer.parseInt(line2s[i*m + j]);
        }
        Queue<Node> nodes = new ArrayDeque<>();
        int[][] dp = new int[m][n];
        for(int i =0; i < m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        nodes.add(new Node(0,0));
        while(!nodes.isEmpty()){
            Node node = nodes.poll();
            int step = nums[node.row][node.col];
            for(int i = step; i > 0; i--){
                for(int row = node.row + i; row >= node.row; row--) {
                    int col = i - (row - node.row) + node.col ;
                    if (row < m && col < n && nums[row][col] != 0) {
                        dp[row][col] = Math.min(dp[row][col], dp[node.row][node.col] + 1);
                        Node temp = new Node(row, col);
                        nodes.add(new Node(row, col));
                        if(temp.row == m -1 && temp.col ==n - 1){
                            System.out.println(dp[m - 1][n - 1]);
                            System.exit(0);
                        }

                    }
                }
            }
        }
        System.out.println(-1);
    }
}

/*
3,3
3 2 2 0 1 0 1 1 1


2
 */
/*
3,3
2 0 0 3 0 0 0 0 0

-1
 */

/*
5,5
2 3 1 1 0 0 0 0 1 0 0 0 3 1 0 0 0 0 1 4 0 0 0 0 1

4
 */