package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC68
 * @Date 1/13/2021 3:50 PM
 * @Version 1.0
 */


public class NC68 {
    //递归
    public int JumpFloor(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return JumpFloor(n - 1) + JumpFloor(n - 2);
    }

    //动态规划
    public int JumpFloor1(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n + 1; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
