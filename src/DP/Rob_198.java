package DP;

/**
 * @Description 打家劫舍
 * @Author Jianhai Wang
 * @ClassName Rob_198
 * @Date 11/27/2020 3:54 PM
 * @Version 1.0
 */


public class Rob_198 {
    //V3.0
    public static int rob3(int[] nums) {
        int pre = 0;
        int cur = 0;
        int temp = 0;
        for(int num : nums){
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }


    //动态规划 V2.0
    public static int rob2(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }

    //动态规划 V1.0
    public static  int rob1(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
