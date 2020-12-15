package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L53_MaxSubArray
 * @Date 12/14/2020 4:46 PM
 * @Version 1.0
 */


public class L53_MaxSubArray {
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
}
