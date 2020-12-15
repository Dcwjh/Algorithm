package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L217_containsDuplicate
 * @Date 12/14/2020 11:47 AM
 * @Version 1.0
 */


public class L217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
