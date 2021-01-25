package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1143_LongCommonSubString
 * @Date 1/14/2021 5:01 PM
 * @Version 1.0
 */


//牛客：https://www.nowcoder.com/questionTerminal/02e7cc263f8a49e8b1e1dc9c116f7602
    //最长公共子串
public class L1143_LongCommonSubString {
    public int findLongest(String A, int n, String B, int m) {
        // write code here
        
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = 0;
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
