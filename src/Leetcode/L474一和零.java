package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L474一和零
 * @Date 2021/8/18 22:55
 * @Version 1.0
 */


public class L474一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp, 第i个数组，0的容量为j, 1的容量为k，父集需要占用更多的背包
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for(int i = 1; i < strs.length + 1; i ++){
            int[] zerosones = findZerosOnes(strs[i - 1]);
            int zero = zerosones[0];
            int one = zerosones[1];
            System.out.println("zero：" + zero + "  , ones:" + one);
            for(int j = 0;j < m + 1; j ++){
                for(int k = 0; k < n + 1; k++){
                    dp[i][j][k] = dp[i - 1][j][k];
                    if(j >= zero && k >= one){
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zero][k-one] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int[] findZerosOnes(String str){
        int[] ans = new int[2];
        for(int i = 0; i < str.length();i++){
            ans[str.charAt(i) - '0'] ++;
        }

        return ans;
    }

    private void print(int[] nums){
        for(int num : nums){
            System.out.printf("%2d",num);
        }
    }


}
