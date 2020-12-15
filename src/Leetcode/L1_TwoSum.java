package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1_TwoSum
 * @Date 12/14/2020 3:09 PM
 * @Version 1.0
 */


//hash
public class L1_TwoSum {

    //暴力
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //hash
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }

        return new int[0];
    }

}
