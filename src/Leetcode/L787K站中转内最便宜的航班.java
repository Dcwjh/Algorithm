package Leetcode;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L787K站中转内最便宜的航班
 * @Date 2021/9/6 17:26
 * @Version 1.0
 */


public class L787K站中转内最便宜的航班 {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, Integer.MAX_VALUE / 2);
        Arrays.fill(cur, Integer.MAX_VALUE / 2);
        pre[src] = 0;
        for(int i = 1; i <= k + 1; i++){
            for(int[] flight : flights){
                int a = flight[0];
                int b = flight[1];
                int c = flight[2];
                cur[b] = Math.min(cur[b],pre[a] + c);
            }

            for(int p = 0; p < n; p++){
                pre[p] = cur[p];
            }
            System.out.println(Arrays.toString(cur));
        }
        return cur[dst] >= Integer.MAX_VALUE / 2 ?  -1 : cur[dst];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPrice(3, nums, 0,2, 1));
    }
}
