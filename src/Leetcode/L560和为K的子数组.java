package Leetcode;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L560和为K的子数组
 * @Date 2021/8/6 14:57
 * @Version 1.0
 */


public class L560和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);

        }
        return count;
    }
}
