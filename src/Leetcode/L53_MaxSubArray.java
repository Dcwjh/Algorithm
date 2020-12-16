package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L53_MaxSubArray
 * @Date 12/14/2020 4:46 PM
 * @Version 1.0
 */


public class L53_MaxSubArray {


    /**
     * 动态规划：只是当前状态只与上一个状态有关。dp[i]保存到i的最大值
     * @param nums
     * @return
     * @Version 1.0
     */
    public static  int maxSubArray1(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length;i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;

    }


    /**
     * 简化版本
     * @param nums
     * @return
     * @version 2.0
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for(int num : nums){
            //判断以前的和对现在这个数是否有增益效果，若没有，则重新开始
            pre = Math.max(pre + num, num);
            //保留最大值
            max = Math.max(max, pre);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for(int num : nums){
            //判断以前的和对现在这个数是否有增益效果，若没有，则重新开始
            pre = Math.max(pre + num, num);
            //保留最大值
            max = Math.max(max, pre);
        }
        return max;
    }

    public static int maxSubArray3(int[] nums) {
        if(nums.length == 0) return 0;
        return maxSubArraySum(nums, 0, nums.length - 1);
    }

    private static int maxSubArraySum(int[] nums, int l, int r){
        if(l == r)
            return nums[l];
        int m = (l + r) >>>1;
        return Math.max(maxSubArraySum(nums,l, m), Math.max(maxSubArraySum(nums, m+1, r), meger(nums, l, m,r)));

    }

    private static int meger(int[] nums, int l, int m, int r){
        int sum = 0;
        int leftMaxSum = Integer.MIN_VALUE;
        for(int i = m; i >= 0; i--){
            sum += nums[i];
            leftMaxSum = Math.max(sum, leftMaxSum);
        }
        sum  = 0;
        int rightMaxSum = Integer.MIN_VALUE;
        for(int i = m + 1; i <= r; i++){
            sum += nums[i];
            rightMaxSum = Math.max(sum, rightMaxSum);
        }
        return leftMaxSum + rightMaxSum;
    }


    public static void main(String[] args) {
        System.out.println(maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
