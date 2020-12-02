package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName waysToStep_Interview_08_01
 * @Date 12/1/2020 10:50 AM
 * @Version 1.0
 */


public class WaysToStep_Interview_08_01 {

    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        if(n ==3)
            return 4;
        int a = 1;
        int b = 2;
        int c = 4;
        int d = 0;
        for (int i = 4; i < n+1; i++) {
            d = (a + (b + c) % 1000000007) % 1000000007;
            a = b;
            b = c;
            c = d;
        }
        return d;

    }


    public int waysToStep1(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < n+1; i++) {
            //取模，对两个较大的数之和取模再对整体取模，防止越界（这里也是有讲究的）
            //假如对三个dp[i-n]都 % 1000000007，那么也是会出现越界情况（导致溢出变为负数的问题）
            //因为如果本来三个dp[i-n]都接近 1000000007 那么取模后仍然不变，但三个相加则溢出
            //但对两个较大的dp[i-n]:dp[i-2],dp[i-3]之和mod 1000000007，那么这两个较大的数相加大于 1000000007但又不溢出
            //取模后变成一个很小的数，与dp[i-1]相加也不溢出
            //所以取模操作也需要仔细分析
            dp[i] = (dp[i-1] + (dp[i-2] + dp[i-3]) % 1000000007) % 1000000007;
        }
        return dp[n];
    }


}
