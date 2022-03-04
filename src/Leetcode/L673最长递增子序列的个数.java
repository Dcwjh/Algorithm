package Leetcode;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L673最长递增子序列的个数
 * @Date 2021/8/15 11:58
 * @Version 1.0
 */


public class L673最长递增子序列的个数 {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];   //子序列的长度
        int[] count = new int[nums.length]; //当前长度的个数
        int max = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int index = 0;
        for(int i = 0; i < nums.length; i ++){
            for(int j = i - 1; j >= 0; j--){//
                if(nums[j] < nums[i]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }

                }
            }
            max = Math.max(max, dp[i]);
        }

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(dp[i] == max){
                res += count[i];
            }
        }
        return res;

    }
}
