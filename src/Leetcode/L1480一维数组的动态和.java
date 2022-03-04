package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1480一维数组的动态和
 * @Date 2021/8/6 21:57
 * @Version 1.0
 */


public class L1480一维数组的动态和 {
    public int[] runningSum(int[] nums) {
        int[] help = new int[nums.length];
        help[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            help[i] = help[i - 1] +  nums[i];
        }
        return help;
    }
}
