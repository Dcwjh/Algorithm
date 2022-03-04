package Leetcode;

import java.util.HashSet;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1049最后一块石头的重量II
 * @Date 2021/8/18 17:00
 * @Version 1.0
 */


public class L1049最后一块石头的重量II {

    public static int lastStoneWeightII(int[] stones) {
        HashSet<Integer> target = new HashSet<>();

        for(int num : stones){
            HashSet<Integer> temp = new HashSet<>();
            if(target.size() == 0){
                temp.add(num);
                temp.add(-num);
            } else {
                for (Integer t : target) {
                    temp.add(t + num);
                    temp.add(t - num);
                }
            }
            target.clear();
            target.addAll(temp);
            for(Integer i : target)
                System.out.print(i + " ");
            System.out.println();
        }
        int res = Integer.MAX_VALUE;
        for(int num : target){
            if(num >= 0){
                res = Math.min(res, num);
            }
        }
        System.out.println("res" + res);
        return res;
    }


    public int lastStoneWeightII2(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int num : stones){
            sum += num;
        }
        int[][] dp = new int[2][sum/2 + 1];
        //0不拿，1拿
        for(int i = 1; i < stones.length + 1; i++){
            int stone = stones[i - 1];
            for(int j = 0; j < dp[0].length; j++){
                dp[i & 1][j] = dp[(i - 1) & 1][j];
                if(j >= stone){
                    dp[i & 1][j] = Math.max(dp[i & 1][j], dp[(i - 1) & 1][j - stone] + stone);
                }

            }
        }

        return sum - 2 * dp[stones.length & 1][sum/2];
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{40, 33, 31, 26, 21}));
    }
}
