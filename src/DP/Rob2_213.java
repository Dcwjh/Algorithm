package DP;

import java.util.Arrays;

/**
 * @Description 打家劫舍2
 * @Author Jianhai Wang
 * @ClassName Rob2_213
 * @Date 11/27/2020 4:20 PM
 * @Version 1.0
 */


public class Rob2_213 {

    /**
     * 动态规划 V2.0
     *
     */
    public int rob2(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
            myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

    /**
     * 动态规划 V1.0
     *
     */
    //分解问题
    public int rob1(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int pre = 0;
        int cur = 0;
        int temp = 0;
        //第一个不偷
        for(int i = 1; i < nums.length; i++){
            temp = cur;
            cur = Math.max(temp, pre + nums[i]);
            pre = temp;
        }
        int max = cur;

        //最后一个不偷
        pre = 0;
        cur = 0;
        temp = 0;
        //第一个不偷
        for(int i = 0; i < nums.length - 1; i++){
            temp = cur;
            cur = Math.max(temp, pre + nums[i]);
            pre = temp;
        }
        return Math.max(max,cur);

    }
}
