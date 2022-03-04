package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L152乘积最大子数组
 * @Date 2021/8/15 15:07
 * @Version 1.0
 */


public class L152乘积最大子数组 {
    public int maxProduct(int[] nums) {
        //到dp[i]的时候最大乘积
        if(nums.length == 1) return nums[0];
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];  //负数也要算
        maxF[0] = nums[0];
        minF[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));

        }
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, maxF[i]);
        }
        return max;
    }
}
