package 剑指offer;

import java.util.Arrays;

/**
 * @Description 扑克牌中的顺子
 * @Author Jianhai Wang
 * @ClassName Interview61
 * @Date 2020/6/30 17:50
 * @Version 1.0
 */


public class Interview61 {
    public boolean isStraight(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        Arrays.sort(nums);
        int numbersOfZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) numbersOfZero ++;
        }
        int small = numbersOfZero;
        int big = small +1;
        int gap = 0;
        for(;big < nums.length; big++){
            if(nums[big] == nums[small])
                return false;
            gap += nums[big] - nums[small] - 1;
            small = big;
        }
        if(gap > numbersOfZero) return false;
        return true;
    }
}
