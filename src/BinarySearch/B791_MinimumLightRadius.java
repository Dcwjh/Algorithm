package BinarySearch;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName B791_MinimumLightRadius
 * @Date 2021/7/9 11:45
 * @Version 1.0
 */


public class B791_MinimumLightRadius {
    public double solve(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(possible(nums, mid)){
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }
        return l/2.0;
    }

    private boolean possible(int[] nums, int mid){  //mid radius
        int index = 0;
        int count  = 0;
        int max = nums[0];
        while(index < nums.length){
            count ++;
            max = nums[index] + mid;
            while(index < nums.length && nums[index] <= max){
                index++;
            }
        }
        if(count >=4)
            return false;
        return true;
    }
}
