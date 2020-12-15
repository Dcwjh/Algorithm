package Leetcode;

/**
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * @Author Jianhai Wang
 * @ClassName SearchRange_34
 * @Date 12/1/2020 9:20 AM
 * @Version 1.0
 */


public class L34_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};
        int mid = 0;
        int left = 0;
        int right =  nums.length;
        while(left < right){
            mid = left + (right - left)/2;
            if(nums[mid] > target)
                right = mid;
            else if(nums[mid] < target){
                left = mid + 1;
            }else {
                left = mid;
                right = mid;
            }
        }
        //没找到
        if(nums[mid] != target){
            return new int[]{-1,-1};
        }

        while(left > 0){
            if(nums[left] == target)
                left--;
            else
                break;

        }
        if(nums[0] == target){
            left = -1;
        }
        while(right<nums.length){
            if(nums[right] == target)
                right++;
            else
                break;
        }
        if(nums[nums.length - 1] == target){
            right = nums.length;
        }
        return new int[]{left + 1, right - 1};
    }
}
