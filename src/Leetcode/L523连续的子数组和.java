package Leetcode;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L523连续的子数组和
 * @Date 2021/8/6 14:07
 * @Version 1.0
 */


public class L523连续的子数组和 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;
        int [] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1;i < nums.length; i++ ){
            sum[i] = sum[i - 1] + nums[i];
        }

        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if((k != 0 && (sum[j] - sum[i] + nums[i] )% k == 0) )
                    return true;
            }
        }
        return false;
    }

    /*
    思路

    sum[0:i] = n * k + 余数1;
    sum[0:j] = m * k + 余数2;
    若余数相同，则i+1, i + 2, ... j相加能被k整除
     */
    public boolean checkSubarraySum1(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //下标从-1开始，且能被k整除，意思就是从第一个开始 i+1 = （-1） + 1 = 0
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sum %= k;
            if(map.containsKey(sum) && i - map.get(sum) > 1){
                return true;
            } else if(!map.containsKey(sum)){ //还有一种情况就是只有一个数i - map.get(sum) == 1
                map.put(sum, i);
            }
        }

        return false;

    }

}
