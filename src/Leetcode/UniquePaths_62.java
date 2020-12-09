package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName UniquePaths_62
 * @Date 12/9/2020 3:28 PM
 * @Version 1.0
 */


public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i < n+1; i++)
            dp[1][i] = 1;
        for(int i = 1; i < m + 1; i++)
            dp[i][1] = 1;
        for(int i = 2; i < m + 1; i ++) {
            for (int j = 2; j < n + 1; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
