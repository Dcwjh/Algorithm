package BinarySearch;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName B817_Solve
 * @Date 2021/7/9 10:07
 * @Version 1.0
 */


public class B817_Solve {
    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        int l = 0;
        int r = max - min;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(count_not_great(mid, nums) > k)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    private long count_not_great(int mid, int[] nums){
        int i = 0;
        long c = 0;
        for(int j = 1; j < nums.length; j++){
            while(nums[j] - nums[i] > mid){
                i++;
            }
            c += (j - i);
        }
        return c;
    }
}
