package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L33_Search
 * @Date 1/8/2021 4:22 PM
 * @Version 1.0
 */


public class L33_Search {
    public int search(int[] nums, int target) {
        for(int i = 0; i<nums.length;i++){ if(nums[i]==target) return i; } return -1;
    }
}
