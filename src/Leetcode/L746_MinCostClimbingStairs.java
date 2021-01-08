package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName MinCostClimbingStairs_746
 * @Date 11/30/2020 3:46 PM
 * @Version 1.0
 */


public class L746_MinCostClimbingStairs {
    //dp问题，当前状态由前两个状态决定，打家劫舍是由前一个状态决定（是否抢劫前一家，判断当前收益和上次收益的最大值）
    //利用动态规划的时候，dp[i]就代表跨上第i个台阶时候的最小花费，记住是已经在第i个台阶上。所以dp初始化dp[0] = cost[0]; dp[1] = cost[1];
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++){
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i -2]);
        }
        return Math.min(dp[cost.length -1], dp[cost.length - 2]);
    }

    //只需要三个变量
    public int minCostClimbingStairs2(int[] cost) {
        int pre1 = 0;
        int pre2 = 0;
        int dp = 0;
        for (int num : cost) {
            dp = num + Math.min(pre1, pre2);  //当前台阶一定要上的
            pre1 = pre2;
            pre2 = dp;
        }
        return Math.min(pre1, pre2);
    }
}
