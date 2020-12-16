package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L121_MaxProfit
 * @Date 12/15/2020 5:23 PM
 * @Version 1.0
 */


public class L121_MaxProfit {

    //两个变量搞定：一个保存最大值，一个保存当前最小值
    public int maxProfit(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 0;
        int min = nums[0];
        for(int num : nums){
            if(num < min){
                min = num;
            }
            max = Math.max(max,num - min);
        }
        return max;
    }

}
